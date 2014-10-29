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

/* 
 * test class with main method as an example how to run jsonld converter from java code
 */
public class JSONLDConverter {
	public static void main (String args[]) throws IOException {
		String jsonldTestFileName="test.jsonld";
		String rdfTestFileName="test.rdf";
		OutputStream outLD=null;

	    String inputFileNameOriginal="PC2v5test-Signaling-By-BMP-Pathway-REACT_12034.2.owl";

	   JSONLDInterface intf = new JSONLDImpl();	 
	   
	   //convert owl test file in resource directory to jsonld format 
	   MyClass dummyClass=new MyClass(); 
	   InputStream in=dummyClass.getClass().getClassLoader().getResourceAsStream("PC2v5test-Signaling-By-BMP-Pathway-REACT_12034.2.owl");
	   intf.convertToJSONLD(in, outLD);
	   
	   //convert jsonld test file back to rdf format
	   InputStream  inputLD = new FileInputStream(jsonldTestFileName);
	   OutputStream  outRDF=new FileOutputStream (rdfTestFileName);
	   intf.convertFromJSONLD(inputLD,outRDF);

	}

}
	 