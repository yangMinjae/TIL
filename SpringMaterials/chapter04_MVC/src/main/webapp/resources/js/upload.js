const regex = new RegExp("(.*?)\.(exe|sh|zip|alz)$");
const MAX_SIZE = 5242880; //5MB

let fileInput = document.querySelector('input[type="file"]');
let uploadDiv = document.querySelector('.uploadDiv');
let cloneObj = uploadDiv.firstElementChild.cloneNode(true);
let uploadResult = document.querySelector('.uploadResult ul');
giveListener(fileInput);


function checkExtension(fileName, fileSize){
	if(fileSize>=MAX_SIZE){
    alert("파일 사이즈 초과");
    return false;
  }
  if(regex.test(fileName)){
    alert("해당 종류의 파일은 업로드할 수 없습니다.");
    return false;
  }
  return true;
}

function giveListener(enitity){
	enitity.addEventListener('change',()=>{
    const inputFile = document.querySelector('input[type="file"]');
    const files = inputFile.files;
    let blindFlag = false;
    for(let i = 0; i<files.length;i++){
      if(!checkExtension(files[i].name,files[i].size)){
        blindFlag=true;
      }
    }
    showUploadFile(files);
    if(blindFlag){
      uploadDiv.replaceChild(cloneObj.cloneNode(true),uploadDiv.firstElementChild);
      uploadResult.innerHTML='';
      giveListener(document.querySelector('input[type="file"]'));
    }
  });
}

function showUploadFile(fileArr){
	fileArr=Array.from(fileArr);
  if(!fileArr||fileArr.size==0){
    return;
  }
  let str = '';
  fileArr.forEach(file=>{
    str+=`<li>${file.name}`;
    str+=`</li>`;
  })
  uploadResult.innerHTML=str;
}
// 사용하지 않음. 참고용
function showUploadedFile(uploadResultArr){
	  if(!uploadResultArr||uploadResultArr.length==0){
	    return;
	  }
	  let str = '';
	  uploadResultArr.forEach(file => {
	    let fileCallPath = encodeURIComponent(file.uploadPath+'/'+file.uuid+'_'+file.fileName);
	    str+=`<li path="${file.uploadPath}" uuid="${file.uuid}" fileName="${file.fileName}"`;
	    str+=`<a>${file.fileName}</a>`;
	    str+=`<span data-file=${fileCallPath}> X </span>`;
	    str+=`</li>`;
	  });
	  uploadResult.innerHTML=str;
	  uploadResult.addEventListener('click',function(e){
	    if(e.target.tagName==='SPAN'){
	      let targetFile = e.target.getAttribute('data-file');

	      fetch(`/deleteFile`,{
	        method:'post',
	        body:targetFile,
	        headers:{
	          'Content-Type':'text/plain'
	        }
	      })
	      .then(response=>response.text())
	      .then(result=>{
	        alert(result);
	        let targetLi = e.target.closest('li');
	        targetLi.remove();
	      })
	      .catch(err=>console.log());
	    }
	  });
	}