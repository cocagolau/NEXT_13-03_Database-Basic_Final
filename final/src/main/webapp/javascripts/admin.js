/**
 * 
 */

window.addEventListener('load', initPage, false);
	function initPage() {
		
		var formContents =
			'<div class="inputForm">' +
				'<div class="test left">' +
					'<select name="type">' +
						'<option value="0">create, update, delete</option>' + 
						'<option value="1">read</option>' +
					'</select>' +
				'</div>' +
				'<div class="test right">' +
					'<textarea name="query" cols="90" rows="10" placeholder="query"></textarea>' + 
				'</div>' +
			'</div>';
		
		// addQuery
		var addQueryBtn = document.querySelector('#queryPlan button[class="addQuery"]');
		addQueryBtn.addEventListener('click', function(e) {
			var formsInQP = document.querySelector('#queryPlan div[class="forms"]');
			formsInQP.innerHTML += formContents;
//			alert(formsInQP.innerHTML);
		}, false);
		
	}