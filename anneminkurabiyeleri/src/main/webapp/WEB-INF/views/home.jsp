
<div class="container">

	<div class="row">

		<div class="col-md-3">

			<%@include file="./shared/yantaraf.jsp"%>

		</div>

		<div class="col-md-9">

			<div class="row carousel-holder">

				<div class="col-md-12">
					<div id="carousel-example-generic" class="carousel slide"
						data-ride="carousel">
						<ol class="carousel-indicators">
							<li data-target="#carousel-example-generic" data-slide-to="0"
								class="active"></li>
							<li data-target="#carousel-example-generic" data-slide-to="1"></li>
							<li data-target="#carousel-example-generic" data-slide-to="2"></li>
							<li data-target="#carousel-example-generic" data-slide-to="3"></li>
						<li data-target="#carousel-example-generic" data-slide-to="4"></li>
						</ol>
						<div class="carousel-inner">
							<div class="item active">
								<img class="slide-image" src="${images}/s5.jpg"
									alt="">
							</div>
							<div class="item">
								<img class="slide-image" src="${images}/s2.jpg"
									alt="">
							</div>
							<div class="item">
								<img class="slide-image" src="${images}/s3.jpg"
									alt="">
							</div>
							<div class="item">
								<img class="slide-image" src="${images}/s4.jpg"
									alt="">
							</div>
							<div class="item">
								<img class="slide-image" src="${images}/s1.jpg"
									alt="">
							</div>
						</div>
						<a class="left carousel-control" href="#carousel-example-generic"
							data-slide="prev"> <span
							class="glyphicon glyphicon-chevron-left"></span>
						</a> <a class="right carousel-control"
							href="#carousel-example-generic" data-slide="next"> <span
							class="glyphicon glyphicon-chevron-right"></span>
						</a>
					</div>
				</div>

			</div>
			<c:choose>
	<c:when test="${not empty urunler}">
			<div class="row">
			<c:forEach items="${urunler}" var="urun">
			
			
			
					<div class="col-sm-4 col-lg-4 col-md-4">
						<div class="thumbnail">
							<img src="${images}/${urun.kod}.jpg" alt=""  style="width:100%" >
							<div class="caption">
								<h4 class="pull-right">${urun.fiyat}  &#8378;</h4>
								<h4>
									<a href="${contextRoot}/goster/${urun.id}/urun">${urun.ad}</a>
								</h4>
								<p>
									${urun.aciklama}
								</p>
							</div>
							
							<security:authorize access="hasAuthority('KULLANICI')">
							<div class="ratings">
								<a href="${contextRoot}/sepet/ekle/${urun.id}/urun"
							class="btn btn-success"><span
							class="glyphicon glyphicon-shopping-cart"></span>Sepete Ekle</a>
							</div>
							</security:authorize>
							
							
							<security:authorize access="hasAuthority('ADMIN')">
							<div class="ratings">
								<a href="${contextRoot}/yonetim/${urun.id}/urun"
							class="btn btn-success"><span
							class="glyphicon glyphicon-pencil"></span>Duzenle</a>
							</div>
							</security:authorize>
						</div>
					</div>

</c:forEach>
				</c:when>
				</c:choose>

				<!-- aa -->

			</div>

		</div>

	</div>

</div>
<!-- /.container -->