package com.aebd.jMetro.misc;

import java.io.InputStream;

public class GetResource {

	public InputStream getResource(String s) {

		return getClass().getResourceAsStream(s);
	}
}
