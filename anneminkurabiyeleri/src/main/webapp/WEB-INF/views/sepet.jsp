
<div class="container">

 <c:if test="${not empty mesaj}">
 
 <div class="alert alert-info">
 <h3 class="text-center">
 
 ${mesaj}
 
 </h3>
 
 </div>
 </c:if>


<c:choose>

<c:when test="${not empty sepetAlani}">
<table id="cart" class="table table-hover table-condensed">
    				<thead>
						<tr>
							<th style="width:50%">Urun</th>
							<th style="width:10%">Fiyat</th>
							<th style="width:8%">Adet</th>
							<th style="width:22%" class="text-center">Ara Toplam</th>
							<th style="width:10%"></th>
						</tr>
					</thead>
					<tbody>
					
					<c:forEach items="${sepetAlani}" var="sepetAlan">
					
					
					<tr>
							<td data-th="Product">
								<div class="row">
									<div class="col-sm-2 hidden-xs"><img src="${images}/${sepetAlan.urun.kod}.jpg" alt="${sepetAlan.urun.ad}" class="img-responsive cartImg"/></div>
									<div class="col-sm-10">
										<h4 class="nomargin">${sepetAlan.urun.ad}
										
										<c:if test="${sepetAlan.mevcutMu==false}">
										
										<strong class="unavailable">Mevcut Degil</strong>
										
										</c:if>
										
										</h4>
										<p>Marka - ${sepetAlan.urun.marka}</p>
											<p>Aciklama - ${sepetAlan.urun.aciklama}</p>
									</div>
								</div>
							</td>
							<td data-th="Price">${sepetAlan.satisFiyati} &#8378;</td>
							<td data-th="Quantity">
								<input type="number" id="count_${sepetAlan.id}" min="1" max="3" class="form-control text-center" value="${sepetAlan.urunSayisi}">
							</td>
							<td data-th="Subtotal" class="text-center">${sepetAlan.toplam} &#8378;</td>
							<td class="actions" data-th="">
								<button type="button" name="sepetYenile" value="${sepetAlan.id}"class="btn btn-info btn-sm"><span class="glyphicon glyphicon-refresh"></span></button>
								<a href="${contextRoot}/sepet/${sepetAlan.id}/sil" class="btn btn-danger btn-sm"><span class="glyphicon glyphicon-trash"></span></a>								
							</td>
						</tr>
						
						
						</c:forEach>
					</tbody>
					<tfoot>
						<tr class="visible-xs">
							<td class="text-center"><strong>Toplam :${kullaniciModel.sepet.toplamTutar} &#8378;</strong></td>
						</tr>
						<tr>
							<td><a href="${contextRoot}/anasayfa" class="btn btn-warning"><span class="glyphicon glyphicon-chevron-left"></span> Alisverise Devam Et</a></td>
							<td colspan="2" class="hidden-xs"></td>
							<td class="hidden-xs text-center"><strong>Toplam :${kullaniciModel.sepet.toplamTutar} &#8378;</strong></td>
							<td><a href="#" class="btn btn-success btn-block">Odemeye Gec <span class="glyphicon glyphicon-chevron-right"></span></a></td>
						</tr>
					
					
					
					
					
					
					
						
					</tfoot>
				</table>

</c:when>

<c:otherwise>

<div class="jumbotron">

<div class="text-center">

<h1>Sepetiniz Bos</h1>

</div>

</div>
</c:otherwise>

</c:choose>
	
</div>