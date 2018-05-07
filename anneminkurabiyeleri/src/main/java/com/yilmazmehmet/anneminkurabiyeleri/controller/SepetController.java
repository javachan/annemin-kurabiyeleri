package com.yilmazmehmet.anneminkurabiyeleri.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.yilmazmehmet.anneminkurabiyeleri.service.SepetService;

@Controller
@RequestMapping("/sepet")
public class SepetController {

	@Autowired
	SepetService sepetService;

	@RequestMapping("/goster")
	public ModelAndView sepetGoster(
			@RequestParam(name = "sonuc", required = false) String sonuc) {
		ModelAndView mv = new ModelAndView("page");

		if (sonuc != null) {

			switch (sonuc) {
			case "guncellendi":
				mv.addObject("mesaj", "Sepet Guncellendi !");

				break;

			case "silindi":
				mv.addObject("mesaj", "Sepet Silindi !");

				break;

			case "hata":
				mv.addObject("mesaj", "Yanlis giden birseyler var!");

				break;
			}

		}

		mv.addObject("title", "Kullanici Sepeti");
		mv.addObject("sepetGosterTiklandi", true);
		mv.addObject("sepetAlani", sepetService.sepetAlaniGetir());

		return mv;

	}

	@RequestMapping("{sepetAlanId}/guncelle")
	public String sepetGuncelle(@PathVariable int sepetAlanId,
			@RequestParam int adet) {

		String response = sepetService.sepetAlanGuncelle(sepetAlanId, adet);

		return "redirect:/sepet/goster?" + response;
	}

	@RequestMapping("{sepetAlanId}/sil")
	public String sepetSil(@PathVariable int sepetAlanId) {

		String response = sepetService.sepetAlanSil(sepetAlanId);

		return "redirect:/sepet/goster?" + response;
	}

}
