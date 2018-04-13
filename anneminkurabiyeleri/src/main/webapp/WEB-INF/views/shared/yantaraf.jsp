 <p class="lead">Kategoriler</p>
<div class="list-group">

	<c:forEach items="${kategoriler }" var="kategori">
	
	<a href="${contextRoot}/goster/kategori/${kategori.id}/urunler" class="list-group-item" id="${kategori.id}">${kategori.ad }</a>
	
	
	</c:forEach>
       
      
</div>