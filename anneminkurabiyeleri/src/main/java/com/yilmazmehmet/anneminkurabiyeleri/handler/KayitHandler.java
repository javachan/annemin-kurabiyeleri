package com.yilmazmehmet.anneminkurabiyeleri.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.stereotype.Component;

import com.yilmazmehmet.anneminkurabiyeleri.model.KayitModel;
import com.yilmazmehmet.anneminkurabiyeleribackend.dao.KullaniciDAO;
import com.yilmazmehmet.anneminkurabiyeleribackend.dto.Adres;
import com.yilmazmehmet.anneminkurabiyeleribackend.dto.Kullanici;
import com.yilmazmehmet.anneminkurabiyeleribackend.dto.Sepet;

@Component
public class KayitHandler {

	@Autowired
	private KullaniciDAO kullaniciDAO;

	public KayitModel init() {

		return new KayitModel();
	}

	public void kullaniciEkle(KayitModel kayitModel, Kullanici kullanici) {

		kayitModel.setKullanici(kullanici);
	}

	public void faturaEkle(KayitModel kayitModel, Adres fatura) {

		kayitModel.setFatura(fatura);
	}

	public String kaydet(KayitModel model) {

		Kullanici kullanici = model.getKullanici();

		if (kullanici.getRole().equals("KULLANICI")) {

			Sepet sepet = new Sepet();
			sepet.setKullanici(kullanici);
			kullanici.setSepet(sepet);

		}

		kullaniciDAO.kullaniciEkle(kullanici);

		Adres fatura = model.getFatura();
		fatura.setKullaniciId(kullanici.getId());
		fatura.setFatura(true);

		kullaniciDAO.adresEkle(fatura);

		String transitionValue = "basarili";
		return transitionValue;
	}

	public String kullaniciValidasyon(Kullanici kullanici, MessageContext error) {

		String transitionValue = "basarili";
		// sifre kontrol
		if (!(kullanici.getSifre().equals(kullanici.getSifreOnayla()))) {

			error.addMessage(new MessageBuilder().error().source("sifreOnayla")
					.defaultText("Sifreler Uyusmuyor").build());
			transitionValue = "hata";
		}

		// benzersiz email

		if (kullaniciDAO.emaileGoreGetir(kullanici.getEmail()) != null) {

			error.addMessage(new MessageBuilder().error().source("email")
					.defaultText("Bu email mevcut !!").build());

			transitionValue = "hata";
		}
		return transitionValue;
	}
}
