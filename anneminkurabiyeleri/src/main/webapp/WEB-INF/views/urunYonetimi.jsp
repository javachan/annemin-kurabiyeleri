<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<div class="container">

	<div class="row">
		<c:if test="${not empty mesaj}">

			<div class="col-xs-12">
				<div class="alert alert-success alert-dismissible">

					<button type="button" class="close" data-dismiss="alert">&times;</button>
					${mesaj}
				</div>

			</div>

		</c:if>
		<div class="col-md-offset-2 col-md-8">


			<div class="panel panel-primary">


				<div class="panel-heading">

					<h4>Urun Yonetimi</h4>

				</div>
				<div class="panel-body">




					<!-- form elementleri gelecek -->

					<sf:form class="form-horizontal" modelAttribute="urun"
						action="${contextRoot}/yonetim/urunler" method="POST"
						enctype="multipart/form-data">
						<div class="form-group">
							<label class="control-label col-md-4">Ad</label>
							<div class="col-md-8">
								<sf:input type="text" path="ad" class="form-control"
									placeholder="Urun Adi" />
								<sf:errors path="ad" cssClass="help-block" element="em" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4">Marka</label>
							<div class="col-md-8">
								<sf:input type="text" path="marka" class="form-control"
									placeholder="Marka Adi" />
								<sf:errors path="marka" cssClass="help-block" element="em" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4">Aciklama</label>
							<div class="col-md-8">
								<sf:textarea path="aciklama" class="form-control"
									placeholder="Urun Aciklamasini gir !" />
								<sf:errors path="aciklama" cssClass="help-block" element="em" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4">Fiyat</label>
							<div class="col-md-8">
								<sf:input type="number" path="fiyat" class="form-control"
									placeholder="Fiyat Gir" />
								<sf:errors path="fiyat" cssClass="help-block" element="em" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4">Miktar</label>
							<div class="col-md-8">
								<sf:input type="number" path="miktar" class="form-control"
									placeholder="Miktar Gir" />
								<sf:errors path="miktar" cssClass="help-block" element="em" />
							</div>
						</div>


						<div class="form-group">
							<label class="control-label col-md-4" for="file">Resim
								Sec :</label>
							<div class="col-md-8">
								<sf:input type="file" path="file" class="form-control" />
								<sf:errors path="file" cssClass="help-block" element="em" />

							</div>
						</div>



						<div class="form-group">
							<label class="control-label col-md-4">Kategori</label>
							<div class="col-md-8">
								<sf:select path="kategoriId" items="${kategoriler}"
									itemLabel="ad" itemValue="id" class="form-control" />



								<c:if test="${urun.id==0}">
									<div class="text-right">
										<br />
										<sf:hidden path="id" />
										<sf:hidden path="kod" />
										<sf:hidden path="saticiId" />
										<sf:hidden path="aktifMi" />
										</br>
										<button type="button" class="btn btn-warning btn-xs"
											data-toggle="modal" data-target="#myKategoriModal">Yeni
											Kategori Ekle</button>
									</div>
								</c:if>



							</div>

						</div>



						<div class="form-group">

							<div class="col-md-offset-4 col-md-4">

								<input type="submit" name="gonder" value="Kaydet"
									class="btn btn-primary" />

							</div>
						</div>

					</sf:form>



				</div>


			</div>


		</div>


	</div>
	<div class="row">


		<div class="col-xs-12">

			<h3>Urunler</h3>
			</hr>
		</div>


		<div class="col-xs-12">


			<div class="container-fluid">


				<div class="table-responsive">


					<table id="adminUrunListele"
						class="table table-striped table-bordered">


						<thead>
							<tr>
								<th>Id</th>
								<th>&#160;</th>
								<th>Ad</th>
								<th>Marka</th>
								<th>Miktar</th>
								<th>Fiyat</th>
								<th>Aktif</th>
								<th>Duzenle</th>
							</tr>

						</thead>

						<tfoot>
							<tr>
								<th>Id</th>
								<th>&#160;</th>
								<th>Ad</th>
								<th>Marka</th>
								<th>Miktar</th>
								<th>Fiyat</th>
								<th>Aktif</th>
								<th>Duzenle</th>
							</tr>

						</tfoot>

					</table>



				</div>


			</div>


		</div>




	</div>



	<div class="modal fade" id="myKategoriModal" role="dialog"
		tabindex="-1">


		<div class="modal-dialog" role="document">

			<div class="modal-content">

				<!-- modal baslik -->

				<div class="modal-header">

					<button type="button" class="close" data-dismiss="modal">

						<span>&times;</span>

					</button>
					<h4 class="modal-title">Yeni Kategori Ekle</h4>


				</div>
				<div class="modal-body">

					<!-- Kategori form -->

					<sf:form id="kategoriForm" modelAttribute="kategori"
						action="${contextRoot}/yonetim/kategori" method="POST"
						class="form-horizontal">


						<div class="form-group">

							<label for="k_ad" class="control-label col-md-4">Kategori
								Adi</label>
							<div class="col-md-8">

								<sf:input type="text" path="ad" id="k_ad" class="form-control" />

							</div>
						</div>


						<div class="form-group">

							<label for="k_aciklama" class="control-label col-md-4">Aciklama</label>
							<div class="col-md-8">

								<sf:textarea cols="" rows="5" type="text" path="aciklama"
									id="aciklama" class="form-control" />

							</div>
						</div>


						<div class="form-group">


							<div class="col-md-offset-4 col-md-8">

								<input type="submit" value="Kategori Ekle"
									class="btn btn-primary" />

							</div>
						</div>



					</sf:form>

				</div>

			</div>


		</div>




	</div>


</div>