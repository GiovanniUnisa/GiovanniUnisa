function ricerca(str) {
	var dataList = document.getElementById('ricerca-datalist');
	if (str.length == 0) {
		dataList.innerHTML = '';
		return;
	}

	var xmlHttpReq = new XMLHttpRequest();
	xmlHttpReq.responseType = 'json';
	xmlHttpReq.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			dataList.innerHTML = '';

			for ( var i in this.response) {
				var option = document.createElement('option');
				option.value = this.response[i];
				dataList.appendChild(option);
			}
		}
	}
	xmlHttpReq.open("GET", "RicercaAjax?ric=" + encodeURIComponent(str), true);
	xmlHttpReq.send();
}