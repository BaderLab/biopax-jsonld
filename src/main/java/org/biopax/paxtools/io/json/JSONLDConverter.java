package org.biopax.paxtools.io.json;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.jena.riot.Lang;
import org.apache.jena.riot.RDFDataMgr;
import org.biopax.paxtools.io.SimpleIOHandler;
import org.biopax.paxtools.model.BioPAXLevel;

import com.hp.hpl.jena.rdf.model.*;

import org.biopax.paxtools.model.Model;




//import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.util.FileManager;


public class JSONLDConverter {
	public static void main (String args[]) throws IOException {
		String jsonldTestFileName="test.jsonld";
		String rdfTestFileName="test.rdf";
		 OutputStream outLD=null;
		 //OutputStream outRDF=null;
		 //InputStream inputLD=null;
	    String inputFileNameOriginal="PC2v5test-Signaling-By-BMP-Pathway-REACT_12034.2.owl";
		//String inputFileNameOriginal=args[0];
	    //String noExtFileName=inputFileNameOriginal.substring(inputFileNameOriginal.length()-3);

	
	   JSONLDInterface intf = new JSONLDImpl();	   

   MyClass dummyClass=new MyClass();
   /*		Model model = io.convertFromOWL(
				dummyClass.getClass().getClassLoader()
					.getResourceAsStream("PC2v5test-Signaling-By-BMP-Pathway-REACT_12034.2.owl"));*/
   InputStream in=dummyClass.getClass().getClassLoader().getResourceAsStream("PC2v5test-Signaling-By-BMP-Pathway-REACT_12034.2.owl");
	 
   intf.convertToJSONLD(in, outLD);
   
   InputStream  inputLD = new FileInputStream(jsonldTestFileName);
   OutputStream  outRDF=new FileOutputStream (rdfTestFileName);
	   intf.convertFromJSONLD(inputLD,outRDF);

	}

}
	 