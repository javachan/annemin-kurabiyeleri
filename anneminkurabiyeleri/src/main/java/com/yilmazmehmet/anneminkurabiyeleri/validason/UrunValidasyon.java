package com.yilmazmehmet.anneminkurabiyeleri.validason;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.yilmazmehmet.anneminkurabiyeleribackend.dto.Urun;

public class UrunValidasyon implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Urun.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		 Urun urun = (Urun) target;
		 
		 if(urun.getFile()==null || urun.getFile().getOriginalFilename().equals("")){
			 
			 errors.rejectValue("file", null,"Lutfen resim seciniz !");
			 return;
		 }
		 
		 
		 if(! (urun.getFile().getContentType().equals("image/jpeg") ||
			   urun.getFile().getContentType().equals("image/png") ||
			   urun.getFile().getContentType().equals("image/gif")
		 )){
			 
			 errors.rejectValue("file", null,"Lutfen sadece resim seciniz .");
			 
			 return;
			 
			 
		 }
	}

}
