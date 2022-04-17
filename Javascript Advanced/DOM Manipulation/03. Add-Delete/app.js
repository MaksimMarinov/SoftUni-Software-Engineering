function addItem() {
   const ulElement = document.getElementById('items');
   const liElement = document.createElement('li');
   liElement.textContent=document.getElementById('newItemText').value;
   let remove= document.createElement('a');
   const linkText = document.createTextNode('[Delete]');
   remove.appendChild(linkText);
   remove.href='#';
   remove.addEventListener('click', deleteItem)
   ulElement.appendChild(liElement);
   liElement.appendChild(remove);
   ulElement.appendChild(liElement);
   document.getElementById('newItemText').value='';
   function deleteItem(){
      liElement.remove();
   }
}