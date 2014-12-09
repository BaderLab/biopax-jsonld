package org.biopax.paxtools.io.json;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public interface JSONLDInterface {
	
	/**
	 * Convert inputstream in owl/rdf format to outputsream in jsonld format.
	 * 
	 * @param in
	 * @param os
	 * @throws IOException
	 */	
	public void  convertToJSONLD(InputStream in, OutputStream os) throws IOException;
	
	/** 
	 * Convert inputstream in jsonld format to outputsream in owl/rdf format.
	 * 
	 * @param in
	 * @param out
	 */	
	 public void convertFromJSONLD(InputStream in, OutputStream out);
	
}
