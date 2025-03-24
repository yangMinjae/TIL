let aDown= document.querySelector("#download");
if(aDown){
aDown.addEventListener('click',function(event){
	event.preventDefault();
	
	let filename = this.getAttribute('href');
	let sendData = `cmd=download&filename=${filename}`;
	location.href=`BBSController?${sendData}`;
})
}