
function check(){
	var id = document.getElementById('id');
	var password = document.getElementById('password');
	
	if (id.value.length < 3){
		alert("ID를 3글자 이상 입력하세요.");
		id.focus();			//id입력란에 포커스 이동
		id.select();		//기존 입력된 문자열을 선택된 상태로 만들어 줌. (사용자의 편의를 위한 기능들.
		return false;
	}
	if (password.value.length < 3){
		alert('비밀번호를 3글자 이상입력하세요');
		password.focus();
		password.select();
		return false;
	}
	return true;
}