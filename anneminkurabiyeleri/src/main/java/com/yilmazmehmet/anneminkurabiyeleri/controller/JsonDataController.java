package com.yilmazmehmet.anneminkurabiyeleri.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yilmazmehmet.anneminkurabiyeleribackend.dao.UrunDAO;
import com.yilmazmehmet.anneminkurabiyeleribackend.dto.Urun;

@Controller
@RequestMapping("/json/data")
public class JsonDataController {
	@Autowired
	private UrunDAO urunDAO;

	@RequestMapping("/hepsi/urunler")
	@ResponseBody
	public List<Urun> tumUrunleriGetir() {
		return urunDAO.aktifUrunleriListele();
	}
	
	
	@RequestMapping("/kategori/{id}/urunler")
	@ResponseBody
	public List<Urun> tumUrunleriKategoriyeGoreGetir(@PathVariable int id) {
		return urunDAO.aktifUrunleriKategoriyeGoreListele(id);
	}
}
