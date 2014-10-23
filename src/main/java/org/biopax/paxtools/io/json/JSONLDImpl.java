package org.biopax.paxtools.io.json;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.jena.riot.Lang;
import org.apache.jena.riot.RDFDataMgr;
import org.biopax.paxtools.io.SimpleIOHandler;
import org.biopax.paxtools.model.BioPAXLevel;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.util.FileManager;

public class JSONLDImpl implements JSONLDInterface  {
	
	public void  convertToJSONLD(InputStream in , OutputStream os) throws IOException{
		 String outputFileName="test.jsonld";
		 OutputStream fos=null;
		 File inputProcessedFile = preProcessFile(in);
		
		 System.out.println("OWl File processed successfully "); 
		    // print current time
		    	SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		    	
		    	System.out.println( "Conversion RDF to JSON started "+sdf.format(Calendar.getInstance().getTime()) );
		    	
		    // create an empty model
		    	com.hp.hpl.jena.rdf.model.Model modelJena = ModelFactory.createDefaultModel();		    		    
		    InputStream internalInputStream = new FileInputStream(inputProcessedFile);
		    
		   if ( internalInputStream== null) {
		       throw new IllegalArgumentException(
		                                    "File: " + inputProcessedFile.getName() + " not found");
		   }
		   try {
			    fos = new FileOutputStream("test.jsonld");
		} catch (FileNotFoundException e) {
			 System.out.println("File: " + outputFileName + " not found");
			e.printStackTrace();
		}
		   // read the RDF/XML file
		 
		   RDFDataMgr.read(modelJena,internalInputStream,Lang.RDFXML);
		   System.out.println( "Read into Model finished "+sdf.format(Calendar.getInstance().getTime()) );
	   
		   RDFDataMgr.write(fos,modelJena, Lang.JSONLD) ;
		   System.out.println( "Conversion RDF to JSON finished "+sdf.format(Calendar.getInstance().getTime()) );
		   System.out.println(" JSON-LD file "+" is written successfully.");
		   //os.close();
		
		   
		
		
	}
	

		
		
		 public void convertFromJSONLD(InputStream in,OutputStream out){
			    
			    com.hp.hpl.jena.rdf.model.Model modelJena = ModelFactory.createDefaultModel();
	
			   if (in == null) {
			       throw new IllegalArgumentException(
			                                    "Input File: "  + " not found");
			   }
			   if (out == null) {
			       throw new IllegalArgumentException(
			                                    "Output File: "  + " not found");
			   }

			   // read the JSONLD file
			   modelJena.read(in,null,"JSONLD");

			   RDFDataMgr.write(out, modelJena, Lang.RDFXML) ;
			   System.out.println(" RDF file "+" is written successfully.");
		
		 }

		
		// Instantiate a simple (StAX based) biopax reader/writer - SimpleIOHandler 
		
		public  File preProcessFile(InputStream in) throws IOException{

	    	SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");  	
	    	System.out.println( "BIOPAX Conversion started "+sdf.format(Calendar.getInstance().getTime()) );
	    	  
	   if (in == null) {
	       throw new IllegalArgumentException(
	                                    "Input File: "  + " is not found");
	   }
			
		SimpleIOHandler simpleIO = new SimpleIOHandler(BioPAXLevel.L3);

		//create a Paxtools Model from the BioPAX L3 RDF/XML input file (stream)

		org.biopax.paxtools.model.Model model =  simpleIO.convertFromOWL(in);

		//set for the IO to output full URIs:

		simpleIO.absoluteUris(true);

		
		File fullUriBiopaxInput = File.createTempFile("biopaxTemp", "owl"); 
		//(the tmp directory can be also set to a non-default by using -Djava.io.tmpdir=... JVM option, e.g., for debugging)
		//fullUriBiopaxInput.deleteOnExit(); //delete on JVM exits
		FileOutputStream outputStream = new FileOutputStream(fullUriBiopaxInput);
		
		//write to an output stream (back to RDF/XML)

		simpleIO.convertToOWL((org.biopax.paxtools.model.Model) model, outputStream); //it closes the stream internally

		model = null; 

		
		System.out.println( "BIOPAX Conversion finished "+sdf.format(Calendar.getInstance().getTime()) );
		return fullUriBiopaxInput;
		}

	}

		 