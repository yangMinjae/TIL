//-----CSS 파일 추가
// 1. 파일 경로 설정
const CSS_FILE_PATH = '/resources/css/get.css';
// 2. link 태그 생성
let linkEle = document.createElement('link');
linkEle.rel = 'stylesheet';
linkEle.href = CSS_FILE_PATH;
// 3. head 태그에 link 엘리먼트 추가
document.head.appendChild(linkEle);
let f = document.forms[0]
let pageDiv = document.querySelector("#page-data");
let amount = pageDiv.getAttribute("amount");
let pageNum = pageDiv.getAttribute("pageNum");
document.querySelectorAll('.panel-body-btns button').forEach(btn=>{
	  btn.addEventListener('click',(e)=>{
			let bno = f.bno.value;
	    if(e.currentTarget.getAttribute("id")=="modifyBtn"){
	    	location.href=`/board/modify?bno=${bno}&pageNum=${pageNum}&amount=${amount}`;
	    }else if(e.currentTarget.getAttribute("id")=="indexBtn"){
	    	location.href=`/board/list?pageNum=${pageNum}&amount=${amount}`;
	    }
	  })
	})

	