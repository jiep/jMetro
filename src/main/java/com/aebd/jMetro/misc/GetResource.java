package com.aebd.jMetro.misc;

import java.io.InputStream;

public class GetResource {

	public InputStream getResource(String s) {

		return getClass().getResourceAsStream(s);
	}

	/*public File getResource(String s) {
		URL url = getClass().getResource(s);
	    return new File(url.getFile());
	}*/
}
