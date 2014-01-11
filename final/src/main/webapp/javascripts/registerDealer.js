$(document).on('click','#wrap', clickButton);

function clickButton(e) {
	
	var target = e.target;
	var linkedId = target.getAttribute("data-click");
	
	if (linkedId !== null) {
		var form = document.getElementById(linkedId);
		
		
		var date = new Date();
		date.setUTCHours(11);
		
		form[4].setAttribute('value', date.getTime());
		form.submit();
	}
}