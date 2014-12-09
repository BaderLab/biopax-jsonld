package org.biopax.paxtools.io.json;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * test class with main method as an example how to run jsonld converter from java code
 * (it's not true Main class yet...)
 * 
 * @author yurishiyanov
 */
public class JSONLDConverter {
	public static void main(String args[]) throws IOException {

		String jsonldTestFileName = "test.jsonld";
		String rdfTestFileName = "test.rdf";

		JSONLDInterface intf = new JSONLDImpl();

		// convert owl test file in resource directory to jsonld format
		InputStream in = intf.getClass().getResourceAsStream(
				"/PC2v5test-Signaling-By-BMP-Pathway-REACT_12034.2.owl");
		intf.convertToJSONLD(in, new FileOutputStream(jsonldTestFileName));

		// convert jsonld test file back to rdf format
		InputStream inputLD = new FileInputStream(jsonldTestFileName);
		OutputStream outRDF = new FileOutputStream(rdfTestFileName);
		intf.convertFromJSONLD(inputLD, outRDF);
	}

}
