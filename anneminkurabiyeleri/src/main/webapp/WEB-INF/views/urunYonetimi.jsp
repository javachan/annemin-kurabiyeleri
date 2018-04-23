<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

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
					
					<sf:form class="form-horizontal" modelAttribute="urun" action="${contextRoot}/yonetim/urunler" method="POST" >
						<div class="form-group">
							<label class="control-label col-md-4">Ad</label>
							<div class="col-md-8">
								<sf:input type="text" path="ad" class="form-control"
									placeholder="Urun Adi" />
								<sf:errors path="ad" cssClass="help-block" element="em"/> 
							</div>
						</div>
						
						<div class="form-group">
							<label class="control-label col-md-4">Marka</label>
							<div class="col-md-8">
								<sf:input type="text" path="marka" class="form-control"
									placeholder="Marka Adi" /> 
								<sf:errors path="marka" cssClass="help-block" element="em"/>	
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4">Aciklama</label>
							<div class="col-md-8">
								<sf:textarea path="aciklama" class="form-control"
									placeholder="Urun Aciklamasini gir !" /> 
								<sf:errors path="aciklama" cssClass="help-block" element="em"/>
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4">Fiyat</label>
							<div class="col-md-8">
								<sf:input type="number" path="fiyat" class="form-control"
									placeholder="Fiyat Gir" />
								<sf:errors path="fiyat" cssClass="help-block" element="em"/>
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4">Miktar</label>
							<div class="col-md-8">
								<sf:input type="number" path="miktar" class="form-control"
									placeholder="Miktar Gir" />
								<sf:errors path="miktar" cssClass="help-block" element="em"/> 
							</div>
						</div>


						<div class="form-group">
							<label class="control-label col-md-4">Kategori</label>
							<div class="col-md-8">
								<sf:select path="kategoriId" items="${kategoriler}" itemLabel="ad" itemValue="id" class="form-control"/>
							
								<div class="text-right">
									<br/>			
									<sf:hidden path="id"/>
									<sf:hidden path="kod"/>
									<sf:hidden path="saticiId"/>
									<sf:hidden path="aktifMi"/>														
									<button type="button" class="btn btn-warning btn-xs" data-toggle="modal" data-target="#myCategoryModal">Yeni Kategori Ekle</button>
								</div>							
							</div>
							
						</div>


					
						<div class="form-group">
							
							<div class="col-md-offset-4 col-md-4">
							
								<input type="submit" name="gonder" value="Kaydet" class="btn btn-primary"/>
								
							</div>
						</div>						
										
					</sf:form>



				</div>


			</div>


		</div>


	</div>


</div>