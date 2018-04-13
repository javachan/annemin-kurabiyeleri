CREATE TABLE kategori(
	id IDENTITY,
	ad VARCHAR(50),
	aciklama VARCHAR(255),
	resimUrl VARCHAR(255),
	aktif BOOLEAN,
	
	CONSTRAINT pk_kategori_id PRIMARY KEY(id)

);
