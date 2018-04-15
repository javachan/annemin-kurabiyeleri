<div class="container">


	<div class="row">
		<!-- yan taraf gözükecek -->
		<div class="col-md-3">
			<%@include file="./shared/yantaraf.jsp"%>

		</div>
		<!-- md3 kapa -->

		<!-- urunler  gözükecek -->
		<div class="col-md-9">

			<!-- yer tutucu  gözükecek -->
			<div class="row">
				<div class="col-lg-12">

					<c:if test="${tumUrunleriListeleMi==true }">
					
					<script>
					
					window.kategoriId ='';
					
					</script>
						<ol class="breadcrumb">


							<li><a href="${contextRoot}/anasayfa">Anasayfa</a></li>
							<li class="active">Urunler</li>



						</ol>
					</c:if>


					<c:if test="${kategoriyeGoreListeliMi==true }">
					
					<script>
					
					window.kategoriId ='${kategori.id}';
					
					</script>
						<ol class="breadcrumb">


							<li><a href="${contextRoot}/anasayfa">Anasayfa</a></li>
							<li class="active">Kategori</li>
							<li class="active">${kategori.ad}</li>




						</ol>
					</c:if>


				</div>

			</div>

			<div class="row">
			<div class="col-xs-12">
			
			
			<table id="urunleriListeleTable" class="table table-striped table-bordered">
			
			<thead>
			<tr>
			<th></th>
			<th>Ad</th>
			<th>Marka</th>
			<th>Fiyat</th>
			<th>Miktar</th>
			<th></th>
			</tr>
			
			</thead>
			
			<tfoot>
			<tr>
			<th></th>
			<th>Ad</th>
			<th>Marka</th>
			<th>Fiyat</th>
			<th>Miktar</th>
						<th></th>
			
			</tr>
			
			</tfoot>
			
			</table>
			
			</div>
			
			</div>
		</div>
		<!-- md9 kapa -->


	</div>


</div>
<!-- container kapa -->