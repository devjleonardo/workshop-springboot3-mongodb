package com.joseleonardo.workshopmongo.controllers.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class URL {

	public static String decodificarParametro(String parametro) {
		try {
			return URLDecoder.decode(parametro, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			return "";
		}
	}
	
}
