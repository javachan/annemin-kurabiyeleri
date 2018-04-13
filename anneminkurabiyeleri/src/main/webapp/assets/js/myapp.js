$(function() {
	switch(menu){
	
		case 'Hakkimizda':
		$('#hakkimizda').addClass('active');
		break;
		case 'Iletisim':
			$('#iletisim').addClass('active');
			break;
			
		case 'Tum Urunler':
			$('#urunleriListele').addClass('active');
			break;
		default:
			$('#urunleriListele').addClass('active');
			
			break;
	}
	
	switch (numara) {
	case numara:
		$('#'+numara).addClass('active');
		break;

	default:
		break;
	}
});