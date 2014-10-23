package org.biopax.paxtools.io.json;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public interface JSONLDInterface {

	public void  convertToJSONLD(InputStream in, OutputStream os) throws IOException;
	 public void convertFromJSONLD(InputStream in,OutputStream out);
	
}
