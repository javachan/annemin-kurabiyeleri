<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>


<%@include file="../shared/flows-header.jsp" %>
		 <div class="container">
		 
	<div class="row">
   
   <div class="col-md-6 col-md-offset-3">
    
    <div class="panel panel-primary">
    
     <div class="panel-heading">
      <h4>Kayit - Adres</h4>
     </div>
     
     <div class="panel-body">
          
      <sf:form
       method="POST"      
       class="form-horizontal"
       id="billingForm"
       modelAttribute="fatura"

      >
      
       
       <div class="form-group">
        <label class="control-label col-md-4" for="adresBir">Birinci Adres</label>
        <div class="col-md-8">
         <sf:input type="text" path="adresBir" class="form-control"
          placeholder="Birinci Adres Giriniz" />
          
          <sf:errors path="adresBir" cssClass="help-block" element="em" />
        </div>
       </div>

       <div class="form-group">
        <label class="control-label col-md-4" for="adresIki">Adres Iki</label>
        <div class="col-md-8">
         <sf:input type="text" path="adresIki" class="form-control"
          placeholder="Adres Ikiyi Giriniz" />
          
          <sf:errors path="adresIki" cssClass="help-block" element="em" />
        </div>
       </div>

       <div class="form-group">
        <label class="control-label col-md-4" for="sehir">Sehir</label>
        <div class="col-md-8">
         <sf:input type="text" path="sehir" class="form-control"
          placeholder="Sehir Giriniz" />
          
          <sf:errors path="sehir" cssClass="help-block" element="em" />
        </div>
       </div>
       
       <div class="form-group">
        <label class="control-label col-md-4" for="postaKodu">Posta Kodu</label>
        <div class="col-md-8">
         <sf:input type="text" path="postaKodu" class="form-control"
          placeholder="XXXXXX" />
          
          <sf:errors path="postaKodu" cssClass="help-block" element="em" />
        </div>
       </div>       
      
       

       <div class="form-group">
        <label class="control-label col-md-4" for="ilce">Ilce</label>
        <div class="col-md-8">
         <sf:input type="text" path="ilce" class="form-control"
          placeholder="Ilce Giriniz" />
          <sf:errors path="ilce" cssClass="help-block" element="em" />
        </div>
       </div>
       
       <div class="form-group">
        <label class="control-label col-md-4" for="ulke">Ulke</label>
        <div class="col-md-8">
         <sf:input type="text" path="ulke" class="form-control"
          placeholder="Ulke Giriniz" />
          
          
          <sf:errors path="ulke" cssClass="help-block" element="em" />
        </div>
       </div>
       
       <div class="form-group">
        <div class="col-md-offset-4 col-md-8">
        	<!-- submit button for moving to the personal -->
<button type="submit" class="btn btn-primary" name="_eventId_kisi">
				
				
			<span class="glyphicon glyphicon-chevron-left"></span>	Onceki - Kisi Kayit 
				</button>

        	<!-- submit button for moving to the confirm -->
<button type="submit" class="btn btn-primary" name="_eventId_onay">
				
				
			Sonraki - Onay <span class="glyphicon glyphicon-chevron-right"></span>	
				</button>
        </div>
       </div>
      
      
      </sf:form>     
     </div>
    </div>
   </div>
  </div>

	 
	 
	 
	 
		 </div>



		<%@include file="../shared/flows-footer.jsp" %>