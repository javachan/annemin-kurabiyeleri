package com.yilmazmehmet.anneminkurabiyeleri.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalDefaultExceptionHandler {

	
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView handlerNoHandlerFoundException(){
		
		ModelAndView mv=new ModelAndView("error");
		
		mv.addObject("hataBasligi", "Sayfa Bulunamad�");
		mv.addObject("hataAciklamasi", "Bu sayfa kullan�lamaz ");
		mv.addObject("title", "404 Sayfa Bulunamad�");
		return mv;
		
	}
	
	@ExceptionHandler(UrunBulunamadiException.class)
	public ModelAndView handlerUrunBulunamadiHandlerFoundException(){
		
		ModelAndView mv=new ModelAndView("error");
		
		mv.addObject("hataBasligi", "�r�n Bulunamad�");
		mv.addObject("hataAciklamasi", "Bu �r�n kullan�lamaz ");
		mv.addObject("title", "404 �r�n Bulunamad�");
		return mv;
		
	}
	
	
	
	@ExceptionHandler(Exception.class)
	public ModelAndView handlerException(Exception ex){
		
		ModelAndView mv=new ModelAndView("error");
		
		mv.addObject("hataBasligi", "Webmaster ile ileti�ime ge� ");
		
		// sadece debug i�in
		StringWriter sw= new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		
		
		ex.printStackTrace(pw);
		
		mv.addObject("hataAciklamasi", sw.toString());
		mv.addObject("title", "Hata");
		return mv;
		
	}
	
	
}
