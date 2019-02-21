function goInsert(){
	if (confirm("글 작성을 시작하시겠습니까.")){
	}
}
function checkDelete(){
	if (confirm("정말 삭제해?")){
		
	}
}
//검색결과 표시 스크립트
function formSubmit(page){
	var f = document.getElementById('pagingForm');	//검색폼	
	var p = document.getElementById('page');		//히든 항목
	p.value = page;									//전달된 페이지 번호
	f.submit();
}