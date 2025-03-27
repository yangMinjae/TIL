let sendData;

document.querySelectorAll('button').forEach(btn => {
	btn.addEventListener('click', ()=> {
		let type = btn.getAttribute("id");
		
		if(type === 'myPageBtn'){
			sendData = 'cmd=myPage';
		}else if(type === 'loginBtn'){
			sendData = 'cmd=loginPage';
		}else if(type ==='joinBtn'){
			sendData = 'cmd=joinPage';
		}else if(type='logoutBtn'){
			sendData = 'cmd=logoutPage';
		}
		location.href='MemberController?' + sendData;
	});
});




