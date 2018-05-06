<%@taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
	<div class="container">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#bs-example-navbar-collapse-1">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="${contextRoot }/anasayfa">Annemin
				Kurabiyeleri</a>
		</div>
		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li id="hakkimizda"><a href="${contextRoot }/hakkimizda">Hakkimizda</a>
				</li>

				<li id="iletisim"><a href="${contextRoot }/iletisim">Iletisim</a>
				</li>

				<li id="urunleriListele"><a
					href="${contextRoot }/goster/hepsi/urunler">Urunler</a></li>
<security:authorize access="hasAuthority('ADMIN')">
				<li id="urunleriYonet"><a
					href="${contextRoot }/yonetim/urunler">Urunleri Yonet</a></li></security:authorize>
			</ul>

			<ul class="nav navbar-nav navbar-right">

				<security:authorize access="isAnonymous()">




					<li id="kayit"><a href="${contextRoot }/kayit">Kaydol</a></li>
					<li id="giris"><a href="${contextRoot }/login">Giris</a></li>
				</security:authorize>

				<security:authorize access="isAuthenticated()">




					<li class="dropdown"><a hred="$javascript:void(0)"
						class="btn btn-default dropdown-toggle" id="dropdownMenu1"
						data-toggle="dropdown">${kullaniciModel.adSoyad}<span
							class="caret"></span></a>

						<ul class="dropdown-menu">
							<security:authorize access="hasAuthority('KULLANICI')">


								<li><a href="${contextRoot}/sepet"> <span
										class="glyphicon glyphicon-shopping-cart"></span> <span
										class="badge">${kullaniciModel.sepet.sepettekiler }</span> -
										${kullaniciModel.sepet.toplamTutar} &#8378;
								</a></li>
								<li class="divider" role="reparator"></li>
							</security:authorize>
							<li><a href="${contextRoot}/yap-logout">Cikis</a></li>
						</ul></li>
				</security:authorize>
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container -->
</nav>

<script>
window.kullaniciRole='${kullaniciModel.role}';

</script>
