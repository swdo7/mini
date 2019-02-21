
function formCheck(){
	var id = document.getElementById('searchId');
	if (id.value.length < 3){
		alert('검색할 ID를 3자 이상 입력하세요.');
		return false;
	}
	return true;
}
