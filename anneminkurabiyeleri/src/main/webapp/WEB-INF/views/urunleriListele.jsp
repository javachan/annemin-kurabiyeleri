<div class="container">


	<div class="row">
		<!-- yan taraf gözükecek -->
		<div class="col-md-3">
			<%@include file="./shared/yantaraf.jsp"%>

		</div> <!-- md3 kapa -->

		<!-- urunler  gözükecek -->
		<div class="col-md-9">

			<!-- yer tutucu  gözükecek -->
			<div class="row">
				<div class="col-lg-12">

					<c:if test="${tumUrunleriListeleMi==true }">
						<ol class="breadcrumb">


							<li><a href="${contextRoot}/anasayfa">Anasayfa</a></li>
							<li class="active">Urunler</li>



						</ol>
					</c:if>
					
					
					<c:if test="${kategoriyeGoreListeliMi==true }">
						<ol class="breadcrumb">


							<li><a href="${contextRoot}/anasayfa">Anasayfa</a></li>
							<li class="active">Kategori</li>
							<li class="active">${kategori.ad}</li>
							



						</ol>
					</c:if>
					
					
				</div>

			</div>


		</div><!-- md9 kapa -->


	</div>


</div> <!-- container kapa -->