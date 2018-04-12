$(function() {
	switch(menu){
	
		case 'Hakkimizda':
		$('#hakkimizda').addClass('active');
		break;
		case 'Iletisim':
			$('#iletisim').addClass('active');
			break;
		default:
			$('#anasayfa').addClass('active');
			break;
	}
});