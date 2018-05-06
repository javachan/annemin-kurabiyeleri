CREATE TABLE kategori(
	id IDENTITY,
	ad VARCHAR(50),
	aciklama VARCHAR(255),
	resimUrl VARCHAR(255),
	aktif BOOLEAN,
	
	CONSTRAINT pk_kategori_id PRIMARY KEY(id)

);


INSERT INTO kategori (ad,aciklama,resimUrl,aktif) VALUES ('Tuzlu Kurabiye','Tuzlu kurabiye Açıklama	','KAT_1.png',true);
INSERT INTO kategori (ad,aciklama,resimUrl,aktif) VALUES ('Tatli Kurabiye','Tatlı kurabiye Açıklama','KAT_2.png',true);
INSERT INTO kategori (ad,aciklama,resimUrl,aktif) VALUES ('Makaron','Makaron yeni aciklama	','KAT_3.png',true);
INSERT INTO kategori (ad,aciklama,resimUrl,aktif) VALUES ('Ekler','Ekler aciklamasi	','EKLER.png',true);


CREATE TABLE kullanici_detay (
	id IDENTITY,
	ad VARCHAR(50),
	soyad VARCHAR(50),
	role VARCHAR(50),
	aktifMi BOOLEAN,
	sifre VARCHAR(50),
	email VARCHAR(100),
	telefon VARCHAR(15),	
	CONSTRAINT pk_kullanici_id PRIMARY KEY(id),
);

INSERT INTO kullanici_detay 
(ad, soyad, role, aktifMi, sifre, email, telefon) 
VALUES ('Mehmet', 'Yilmaz', 'ADMIN', true, '$2b$10$jyWeis2YSQ.l75jg4mZjDeIgjYOkk59MU5ZVQCmklK9myAY07JFA.
', 'mehmet@cankaya.pro', '05374942346');

INSERT INTO kullanici_detay 
(ad, soyad, role, aktifMi, sifre, email, telefon) 
VALUES ('Ahmet', 'Yilmaz', 'SATICI', true, '$2b$10$S/NJoWnmfcvL3h4gwI0i5OrOM4Ugtt8WfSUG0O1VyBPRF9dIyu.vy
', 'ahmet@cankaya.pro', '05374942347');

INSERT INTO kullanici_detay 
(ad, soyad, role, aktifMi, sifre, email, telefon) 
VALUES ('Deniz', 'Yilmaz', 'SATICI', true, '$2b$10$S/NJoWnmfcvL3h4gwI0i5OrOM4Ugtt8WfSUG0O1VyBPRF9dIyu.vy
', 'deniz@cankaya.pro', '05374942348');


CREATE TABLE urun (
	id IDENTITY,
	kod VARCHAR(20),
	ad VARCHAR(50),
	marka VARCHAR(50),
	aciklama VARCHAR(255),
	fiyat DECIMAL(10,2),
	miktar INT,
	aktifMi BOOLEAN,
	kategori_id INT,
	satici_id INT,
	satinAlma INT DEFAULT 0,
	goruntulenme INT DEFAULT 0,
	CONSTRAINT pk_urun_id PRIMARY KEY (id),
 	CONSTRAINT fk_urun_kategori_id FOREIGN KEY (kategori_id) REFERENCES kategori (id),
	CONSTRAINT fk_urun_satici_id FOREIGN KEY (satici_id) REFERENCES kullanici_detay(id),	
);	


INSERT INTO urun (kod, ad, marka, aciklama, fiyat, miktar, aktifMi, kategori_id, satici_id)
VALUES ('PRDABC123DEFX', 'Tuzlu Un Kurabiyesi', 'Yilmaz Kurabiye', 'En iyi kurabiye !', 18000, 50, true, 1, 2 );

INSERT INTO urun (kod, ad, marka, aciklama, fiyat, miktar, aktifMi, kategori_id, satici_id)
VALUES ('PRDDEF123DEFX', 'Tatli Un Kurabiyesi', 'Yilmaz Kurabiye', 'En iyi kurabiye !', 18000, 50, true, 2, 2 );

INSERT INTO urun (kod, ad, marka, aciklama, fiyat, miktar, aktifMi, kategori_id, satici_id)
VALUES ('PRDPQR123WGTX', 'Meyveli Makaron', 'Makaron Evi', 'En iyi makaron !', 17000, 50, true, 3, 3 );

INSERT INTO urun (kod, ad, marka, aciklama, fiyat, miktar, aktifMi, kategori_id, satici_id)
VALUES ('PRDMNO123PQRX', 'Cikilotalı Makaron', 'Makaron Evi', 'En iyi makaron !', 18500, 50, true, 3, 3 );

INSERT INTO urun (kod, ad, marka, aciklama, fiyat, miktar, aktifMi, kategori_id, satici_id)
VALUES ('PRDABCXYZDEFX', 'Meyveli Ekler', 'Ekler Evi', 'En iyi ekler !', 18000, 50, true, 5, 2 );