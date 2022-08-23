
//validate age using dob
$(document).ready(function(){
	var ageLimit = 18;
	var date = new Date();
	date.setFullYear( date.getFullYear() - ageLimit);
	
	var year = date.getFullYear();
	var month = (date.getMonth() < 10 ? '0' : '') + date.getMonth();
	var day = date.getDate();
	
	$('#dob').attr('max' , year + '-' + month + '-' + day);
}); 
