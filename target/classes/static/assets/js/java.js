function search() {
	var number = document.getElementById("keyword").value;
	window.location.assign("/4MEN/account/history/search?keyword" + "=" + number);
}