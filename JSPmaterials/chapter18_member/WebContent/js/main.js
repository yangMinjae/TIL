let sendData;

document.querySelectorAll('button').forEach(btn => {
	btn.addEventListener('click', ()=> {
		let type = btn.getAttribute("id");
		
		if(type === 'myPageBtn'){
			sendData = 'cmd=myPage';
		}else if(type === 'loginBtn'){
			sendData = 'cmd=loginPage';
		}else{
			sendData = 'cmd=joinPage';
		}
		location.href='MemberController?' + sendData;
	});
});




