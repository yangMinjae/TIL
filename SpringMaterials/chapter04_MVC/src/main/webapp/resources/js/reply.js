const replyService = function(){
  // 댓글 삽입 함수
  function add(vo, callback){
      fetch('/reply/new',{
        method:'post',
        body:JSON.stringify(vo),
        headers:{
          'Content-type' : 'application/json; charset=UTF-8'
        }
      })
      .then(response => response.text())
      .then(data =>{
        callback(data);
    })
    .catch(err => console.log(err));
  }
  // 댓글 목록 함수
  function getList(bno,callback) {
	  fetch('/reply/pages/'+bno)
	  .then(response => response.json())
	  .then(data =>{
		  callback(data);
	  })
	  .catch(err=>console.log(err))
  }
  
  // 댓글 삭제 함수
  function remove(bno, rno, callback) {
    fetch('/reply/'+rno+'/'+bno,{method:'delete'})
    .then(response=>response.text())
    .then(data =>{
      callback(data);
    })
    .catch(err=>console.log(err))
  }
  
  // 댓글 수정 함수
  function update(rno,vo,callback) {
    fetch('/reply/'+rno,{
      method:'put',
      body:JSON.stringify(vo),
      headers:{
        'Content-type':'application/json; charset=UTF-8'
      }
    })
    .then(response=>response.text())
    .then(text=>{
      callback(text);
    })
    .catch(err=>console.log(err));
  }	

  // 댓글 조회 함수
  function get(rno,callback){
	  fetch('/reply/'+rno+'.json')
	  .then(response=>response.json())
	  .then(json=>{
		  callback(json)
	  })
	  .catch(err=>console.log(err));
  }
  
  return{
    add : add,
    getList:getList,
    remove:remove,
    update:update,
    get:get
  };
}();
