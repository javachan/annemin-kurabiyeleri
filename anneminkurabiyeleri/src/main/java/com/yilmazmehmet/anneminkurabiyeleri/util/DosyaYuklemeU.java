package com.yilmazmehmet.anneminkurabiyeleri.util;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

public class DosyaYuklemeU {

	private static final String ABS_PATH = "C:/Users/yyilmazmehmet/git/annemin-kurabiyeleri/anneminkurabiyeleri/src/main/webapp/assets/images/";
	private static String REAL_PATH = "";

	private static final Logger logger = LoggerFactory
			.getLogger(DosyaYuklemeU.class);

	public static void dosyaYukle(HttpServletRequest request,
			MultipartFile file, String kod) {
		REAL_PATH = request.getSession().getServletContext()
				.getRealPath("/assets/images/");
		logger.info(REAL_PATH);

		if (!new File(ABS_PATH).exists()) {

			new File(ABS_PATH).mkdirs();

		}

		if (!new File(REAL_PATH).exists()) {

			new File(REAL_PATH).mkdirs();

		}
		
		try {
			//server yukleme
			file.transferTo(new File(REAL_PATH+kod+".jpg"));
			//proje dosyasýna yukleme
			file.transferTo(new File(ABS_PATH+kod+".jpg"));
		} catch (IOException e) {
			// TODO: handle exception
		}

	}

}
