<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>


<%@include file="../shared/flows-header.jsp" %>
		 <div class="container">
		 
		<div class="row">
 
 <div class="col-md-6 col-md-offset-3">
  
  <div class="panel panel-primary">
  
   <div class="panel-heading">
    <h4>Kisi Kayit</h4>
   </div>
   
   <div class="panel-body">
        
    <sf:form
     method="POST"
     class="form-horizontal"
     id="registerForm"
     modelAttribute="kullanici"
    >
      
       
    <div class="form-group">
     <label class="control-label col-md-4">Ad</label>
     <div class="col-md-8">
      <sf:input type="text" path="ad" class="form-control"
       placeholder="Ad" />
     </div>
    </div>


       <div class="form-group">
        <label class="control-label col-md-4">Soyad</label>
        <div class="col-md-8">
         <sf:input type="text" path="soyad" class="form-control"
          placeholder="Soyad" />
        </div>
       </div>
      
       <div class="form-group">
        <label class="control-label col-md-4">E-mail</label>
        <div class="col-md-8">
         <sf:input type="text" path="email" class="form-control"
          placeholder="abc@zyx.com" />
        </div>
       </div>

       <div class="form-group">
        <label class="control-label col-md-4">Telefon</label>
        <div class="col-md-8">
         <sf:input type="text" path="telefon" class="form-control"
          placeholder="XXXXXXXXXX" maxlength="10" />
        </div>
       </div>
       
       <div class="form-group">
        <label class="control-label col-md-4">Sifre</label>
        <div class="col-md-8">
         <sf:input type="password" path="sifre" class="form-control"
          placeholder="Sifre" />
        </div>
       </div>
       
       <!-- radio button using bootstrap class of radio-inline -->
	   <div class="form-group">
	     <label class="control-label col-md-4">Rol Sec</label>
	     <div class="col-md-8">
	       <label class="radio-inline">
	        <sf:radiobutton path="role" value="KULLANICI" checked="checked"/> Kullanici     
	       </label>
	       <label class="radio-inline">
	        <sf:radiobutton path="role" value="SATICI"/> Satici
	       </label>
	     </div>
	    </div>       

       <div class="form-group">
        <div class="col-md-offset-4 col-md-8">
				<!-- submit button inside the form -->
				<button type="submit" class="btn btn-primary" name="_eventId_fatura">
				
				
				Sonraki - Fatura <span class="glyphicon glyphicon-chevron-right"></span>
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