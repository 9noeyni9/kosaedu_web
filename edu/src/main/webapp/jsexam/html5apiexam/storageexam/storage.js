function initiate(){
  var button=document.getElementById('save');
  button.addEventListener('click', newitem, false);
}
function newitem(){
  var keyword=document.getElementById('keyword').value;
  var value=document.getElementById('text').value;
  sessionStorage.setItem(keyword,value);

  show(keyword);
}
function show(keyword){
  var databox=document.getElementById('databox');
  var value=sessionStorage.getItem(keyword);
  databox.innerHTML='<div>'+keyword+' - '+value+'</div>';
}
window.addEventListener('load', initiate, false);