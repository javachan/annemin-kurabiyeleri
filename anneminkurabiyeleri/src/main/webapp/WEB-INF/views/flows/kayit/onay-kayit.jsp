<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>


<%@include file="../shared/flows-header.jsp" %>
		 <div class="container">
		 
	 <div class="row">
 
  <!-- column to display the personal details -->
  <div class="col-sm-6">
 
   <div class="panel panel-primary">    
    <div class="panel-heading">
     <h4>Kisi Detayi</h4>
    </div>
    <div class="panel-body">
     <!-- code to display the personal details -->
    </div>
    <div class="panel-footer">
		  <a href="${flowExecutionUrl}&_eventId_kisi" class="btn btn-primary">Kisi</a>
		
    </div>              
   </div>
       
  </div>
  
  <!-- column to display the address  -->
  <div class="col-sm-6">  
   
   <div class="panel panel-primary">    
    <div class="panel-heading">
     <h4>Fatura Adresi</h4>
    </div>
    <div class="panel-body">
		<!-- code to display the communication address -->
    </div>
    <div class="panel-footer">
		  <a href="${flowExecutionUrl}&_eventId_fatura" class="btn btn-primary">Adres</a>

    </div>       
   </div>  
  
  </div>
 
 </div>
 
 <!-- to provide the confirm button after displaying the details -->
 <div class="row">  
  <div class="col-sm-4 col-sm-offset-4">   
   
   <div class="text-center">
    
   <a href="${flowExecutionUrl}&_eventId_basarili" class="btn btn-primary">Onay</a>
        
   </div>
   
  </div>  
 </div>
		 </div>



		<%@include file="../shared/flows-footer.jsp" %>