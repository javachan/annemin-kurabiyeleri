<div class="container">

	<!-- yer tutucu -->
	<div class="row">


		<div class="col-xs-12">


			<ol class="breadcrumb">

				<li><a href="${contextRoot }/anasayfa">Anasayfa</a></li>
				<li><a href="${contextRoot }/goster/hepsi/urunler">Urunler</a></li>
				<li class="active">${urun.ad}</li>



			</ol>

		</div>



	</div>



<div class="row">
	<!-- urun resmi -->
	<div class="col-xs-12 col-sm-4">
	<div class="thumbnail">
	
	<img src="${images}/${urun.kod}.jpg" class="img img-responsive"/>
	
	
	</div>
	
	
	</div>
	
	<!--  urun aciklamasi -->
	<div class="col-xs-12 col-sm-8">
	
	<h3>${urun.ad }</h3>
	<hr/>
	<p>${urun.aciklama }</p>
	<hr/>
	<h4>Fiyat : <strong>${urun.fiyat} &#8378;</strong></h4>
	<hr/>
	<h6>Stok : ${urun.miktar}</h6>
	
	<a href="${contextRoot}/sepet/ekle/${urun.id}/urun" class="btn btn-success"><span class="glyphicon glyphicon-shopping-cart"></span>Sepete Ekle</a>
	<a href="${contextRoot}/goster/hepsi/urunler" class="btn btn-success">Geri Dön</a>
	
	</div>

</div>

</div>

