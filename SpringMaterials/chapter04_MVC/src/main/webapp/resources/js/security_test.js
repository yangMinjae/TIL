document.querySelectorAll('button').forEach(a => {
  a.addEventListener('click',function(e){
    let targ=e.target.getAttribute('id');
    if(targ=='all'){
      location.href='/sample/all';
    }
    else if(targ=='member'){
      location.href='/sample/member';
    }
    else if(targ=='admin'){
      location.href='/sample/admin';
    }
  })
});
