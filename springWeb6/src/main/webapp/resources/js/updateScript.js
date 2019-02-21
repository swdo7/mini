function formCheck(){
	var custid = document.getElementById('custid');
	var pw1 = document.getElementById('pw1');
	var pw2 = document.getElementById('pw2');
	var name = document.getElemetById('name');
	
	if (custid.value.length < 3){
		alert("ID를 3글자 이상 입력하세요.");
		custid.focus();			//id입력란에 포커스 이동
		custid.select();		//기존 입력된 문자열을 선택된 상태로 만들어 줌. (사용자의 편의를 위한 기능들.
		return false;
	}
	else if (pw1.value.length < 3){
		alert('비밀번호를 3글자 이상입력하세요');
		pw1.focus();
		pw1.select();
		return false;
	}
	else if (pw1.value != pw2.value){
		alert('비밀번호가 같지 않습니다. 다시 입력해주세요.');
		pw2.focus();
		pw2.select();
		return false;
	}
	else if (name.value.length < 0){
		alert('이름이 필수 입력항목입니다.')
		naem.focus();
		return false;
	}
	alert("회원가입을 완료합니다. 홈화면으로 돌아갑니다.")
	return true;
}
function idCheckOpen() {
	   //window는 미리 만들어진 자바객체 (web browser)
	   //"idCheck" 경로 .. "idwin" 새 창의 이름 (이름이 같은 창을 또 열면 새로고침 같이됨)..세번째 = 창의 
	   window.open("idCheck", "idwin", "top=200,left=550,width=400,height=300,menubar=no");
}

