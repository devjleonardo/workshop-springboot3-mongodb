package com.joseleonardo.workshopmongo.controllers.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class URL {

	public static String decodificarParametro(String parametro) {
		try {
			return URLDecoder.decode(parametro, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			return "";
		}
	}
	
	public static Date converterData(String textoData, Date dataPadrao) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		format.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		try {
			return format.parse(textoData);
		} catch (ParseException e) {
			return dataPadrao;
		}
	}
	
}
