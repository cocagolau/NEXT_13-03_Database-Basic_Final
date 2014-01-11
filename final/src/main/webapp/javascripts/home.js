$(document).ready(initPage);

function initPage() {
	$(document).on('click','.itemList > .item ', clickItemList);
	

}


function clickItemList(e) {
	var target = e.target;
	
	
	
	while (target.getAttribute('data-id') === null) {
		target = target.parentNode;
	}
	console.log(target);
	var id = target.getAttribute('data-id');
	if (id !== null ) {
		document.location.href = '/list/view/' + id;
	}
}