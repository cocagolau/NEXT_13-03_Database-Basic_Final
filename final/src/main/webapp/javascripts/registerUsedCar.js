$(document).on('click','#wrap', clickButton);

function clickButton(e) {
	
	var target = e.target;
	var linkedId = target.getAttribute('data-click');
	console.log(linkedId);
	
	if (linkedId !== null) {
		if (linkedId === 'register') {
			var form = document.querySelector('#' + linkedId + ' > form');
			console.log(form);
			var rDate = document.querySelector('#' + linkedId + ' input[name="registrationDate"]');
			
			var date = new Date();
			date.setUTCHours(11);
			
			rDate.setAttribute('value', date.getTime());
			form.submit();
		}
		else if (linkedId === 'photoUpload') {
			console.log('in photoUpload');
			var formContents = 
				'<div class="tableRow">' +
					'<div class="tableCell">' +
						'<input type="text" name="photoPart" placeholder="부분이름"></input>' +
					'</div>' +
					'<div class="tableCell">' +
						'<input type="file"></input>' + 
					'</div>' +
				'</div>';

			var table = document.querySelector('#'+ linkedId + " > .table");
			console.log(table);
			table.innerHTML += formContents;
			
			var childrenNum = table.children.length;
			
			var nextNum = childrenNum - 2;
			var nextName = "files[" + nextNum + "]";
			
			var lastOf = table.children[childrenNum-1];
			var fileForm = lastOf.childNodes[1].childNodes[0];
			fileForm.setAttribute("name", nextName);
			
			console.log(fileForm);
		}
		
		else if (linkedId === 'accidentInfo') {
			console.log('in accidentInfo');
			var formContents =
				'<div class="tableRow">' +
					'<div class="tableCell">' +
						'<input type="month" name="accidentDate"></input>' +
					'</div>' +
					'<div class="tableCell">' +
						'<input type="text" name="accidentDetail" placeholder="사고내용을 적어주세요"></input>' +
					'</div>' +
				'</div>';

			var table = document.querySelector('#'+ linkedId + " > .table");
//			console.log(table);
			table.innerHTML += formContents;
		}
		
		else if (linkedId === 'selectCar') {
			console.log('in selectCar');
			var selectCompany = document.getElementById('selectCompany');
			console.log();
			
			request = new XMLHttpRequest();
			var company = selectCompany.value;
			var companyName = escape(company);
			var url = "/register/ajax/" + companyName;
			request.onreadystatechange = showAjax;
			request.open("GET", url, true);
			request.send(null);
		}
	}
}


function showAjax() {
	if (request.readyState == 4) {
		if (request.status == 200) {
			var text = request.responseText;
			console.log(text);
			
			var tag = document.getElementById('carId');
			tag.innerHTML = text;
		}
	}
}