$(function() {
	switch (menu) {

	case 'Hakkimizda':
		$('#hakkimizda').addClass('active');
		break;
	case 'Iletisim':
		$('#iletisim').addClass('active');
		break;

	case 'Tum Urunler':
		$('#urunleriListele').addClass('active');
		break;

	case 'Urunleri Yonet':
		$('#urunleriYonet').addClass('active');
		break;
	default:
		if (menu == "Anasayfa")
			break;
		$('#urunleriListele').addClass('active');

		break;
	}

	switch (numara) {
	case numara:
		$('#' + numara).addClass('active');
		break;

	default:
		break;
	}

	// csrf token

	var token = $('meta[name="_csrf"]').attr('content');
	var header = $('meta[name="_csrf_header"]').attr('content');

	if (token.length > 0 && header.length > 0) {

		$(document).ajaxSend(function(e, xhr, options) {

			xhr.setRequestHeader(header, token);
		});
	}
	// datatable jquery için kodlar

	var $table = $('#urunleriListeleTable');

	// bu ttabloya ait ürünleri getir

	if ($table.length) {
		// console.log('tablodakiler');

		var jsonUrl = '';
		if (window.kategoriId == '') {

			jsonUrl = window.contextRoot + '/json/data/hepsi/urunler';
		} else {

			jsonUrl = window.contextRoot + '/json/data/kategori/'
					+ window.kategoriId + '/urunler';
		}

		$table
				.DataTable({

					lengthMenu : [ [ 3, 5, 10, -1 ],
							[ '3 Kayit', '5 Kayit', '10 Kayit', 'Hepsi' ] ],
					pageLenght : 5,
					ajax : {

						url : jsonUrl,
						dataSrc : ''
					},
					columns : [
							{
								data : 'kod',
								bSortable : false,
								mRender : function(data, type, row) {

									return '<img src="' + window.contextRoot
											+ '/resources/images/' + data
											+ '.jpg" class="dataTableImg"/>';
								}

							},
							{
								data : 'ad'

							},
							{
								data : 'marka'

							},
							{
								data : 'fiyat',
								mRender : function(data, type, row) {

									return data + ' &#8378;'
								}

							},
							{
								data : 'miktar',
								mRender : function(data, type, row) {
									if (data < 1) {

										return '<span style="color:red">Tukendi</span>';
									}
									return data;
								}

							},
							{
								data : 'id',
								bSortable : false,
								mRender : function(data, type, row) {

									var str = '';
									str += '<a href="'
											+ window.contextRoot
											+ '/goster/'
											+ data
											+ '/urun" class="btn btn-primary"><span class="glyphicon glyphicon-eye-open"></span></a>&#160';
									if (kullaniciRole == 'ADMIN') {
										str += '<a href="'
											+ window.contextRoot
											+ '/yonetim/'
											+ data
											+ '/urun" class="btn btn-warning"><span class="glyphicon glyphicon-pencil"></span></a>';
									}else{
										
										
									

									if (row.miktar < 1) {
										str += '<a href="javascript::void(0)" class="btn btn-success disabled"><span class="glyphicon glyphicon-shopping-cart"></span></a>';
									} else {

										

										str += '<a href="'
												+ window.contextRoot
												+ '/sepet/ekle/'
												+ data
												+ '/urun" class="btn btn-success"><span class="glyphicon glyphicon-shopping-cart"></span></a>';

									}
									}
									return str;
								}

							} ]
				});
	}

	// uyari kaybol
	var $alert = $('.alert');
	if ($alert.length) {

		setTimeout(function() {
			$alert.fadeOut('slow');
		}, 3000)
	}

	// -----------
	$('.switch input[type="checkbox"]')
			.on(
					'change',
					function() {

						var checkbox = $(this);
						var checked = checkbox.prop('checked');
						var dMsg = (checked) ? 'Aktif etmek istediginizden emin misiniz ?'
								: 'Deaktif etmek istediginizden emin misiniz ?';
						var value = checkbox.prop('value');
						bootbox
								.confirm({

									size : 'medium',
									title : ' Urun Aktif & Deaktif',
									message : dMsg,
									callback : function(confirmed) {

										if (confirmed) {
											console.log(value);
											bootbox
													.alert({
														side : 'medium',
														title : 'Bilgilendirme',
														message : 'Urun uzerinde degisiklik yapacaksin '
																+ value
													});
										} else {
											checkbox.prop('checked', !checked);
										}
									}
								});
					});

	// **************

	// datatable jquery için kodlar

	var $adminUruntable = $('#adminUrunListele');

	// bu ttabloya ait ürünleri getir

	if ($adminUruntable.length) {

		var jsonUrl = window.contextRoot + '/json/data/admin/hepsi/urunler';
		// console.log(jsonUrl);
		$adminUruntable
				.DataTable({

					lengthMenu : [ [ 10, 30, 50, -1 ],
							[ '10 Kayit', '30 Kayit', '50 Kayit', 'Hepsi' ] ],
					pageLenght : 30,
					ajax : {

						url : jsonUrl,
						dataSrc : ''
					},
					columns : [
							{

								data : 'id'
							},
							{
								data : 'kod',
								bSortable : false,
								mRender : function(data, type, row) {

									return '<img src="'
											+ window.contextRoot
											+ '/resources/images/'
											+ data
											+ '.jpg" class="adminDataTableImg"/>';
								}

							},
							{
								data : 'ad'

							},
							{
								data : 'marka'

							},
							{
								data : 'miktar',
								mRender : function(data, type, row) {
									if (data < 1) {

										return '<span style="color:red">Tukendi</span>';
									}
									return data;
								}

							},
							{
								data : 'fiyat',
								mRender : function(data, type, row) {

									return data + ' &#8378;'
								}

							},

							{
								data : 'aktifMi',
								bSortable : false,
								mRender : function(data, type, row) {

									var str = '';
									str += '<label class="switch">';

									if (data) {

										str += '<input type="checkbox" checked="checked" value="'
												+ row.id + '" />';

									} else {

										str += '<input type="checkbox" value="'
												+ row.id + '" />';

									}
									str += '<div class="slider"></div></label>';

									return str;
								}

							},

							{
								data : 'id',
								bSortable : false,
								mRender : function(data, type, row) {

									var str = '';
									str += '<a href="'
											+ window.contextRoot
											+ '/yonetim/'
											+ data
											+ '/urun" class="btn btn-primary"><span class="glyphicon glyphicon-pencil"></span></a> &#160;';

									return str;

								}

							}

					],

					initComplete : function() {

						var api = this.api();
						api
								.$('.switch input[type="checkbox"]')
								.on(
										'change',
										function() {

											var checkbox = $(this);
											var checked = checkbox
													.prop('checked');
											var dMsg = (checked) ? 'Aktif etmek istediginizden emin misiniz ?'
													: 'Deaktif etmek istediginizden emin misiniz ?';
											var value = checkbox.prop('value');
											bootbox
													.confirm({

														size : 'medium',
														title : ' Urun Aktif & Deaktif',
														message : dMsg,
														callback : function(
																confirmed) {

															if (confirmed) {
																console
																		.log(value);
																var aktifUrl = window.contextRoot
																		+ '/yonetim/urun/'
																		+ value
																		+ '/aktifEtme';

																$
																		.post(
																				aktifUrl,
																				function(
																						data) {

																					bootbox
																							.alert({
																								side : 'medium',
																								title : 'Bilgilendirme',
																								message : data
																							});

																				})

															} else {
																checkbox
																		.prop(
																				'checked',
																				!checked);
															}
														}
													});
										});
					}

				});
	}
	// *********************************

	// validasyon kodlari

	var $kategoriForm = $('#kategoriForm');
	if ($kategoriForm.length) {
		$kategoriForm.validate({

			rules : {

				ad : {
					required : true,
					minlength : 2
				},
				aciklama : {

					required : true,
					minlength : 2
				}
			},

			messages : {

				ad : {
					required : 'Lutfen kategori adi ekle',
					minlength : 'Minumum 2 karekter girmelisiniz'
				},
				aciklama : {

					required : 'Lutfen kategori aciklamasi ekle',
					minlength : 'Minumum 2 karekter girmelisiniz'
				}

			},
			errorElement : 'em',
			errorPlacement : function(error, element) {

				error.addClass('help-block');
				error.insertAfter(element);
			}

		});

	}
	// ----------------------------------

	// login kontrol form

	var $loginForm = $('#loginForm');
	if ($loginForm.length) {
		$loginForm.validate({

			rules : {

				username : {
					required : true,
					email : true
				},
				password : {

					required : true,

				}
			},

			messages : {

				username : {
					required : 'Lutfen kullanici adini giriniz .',
					email : 'Lutfen gecerli bir email giriniz'
				},
				password : {

					required : 'Lutfen sifreyi giriniz ',

				}

			},
			errorElement : 'em',
			errorPlacement : function(error, element) {

				error.addClass('help-block');
				error.insertAfter(element);
			}

		});

	}

});