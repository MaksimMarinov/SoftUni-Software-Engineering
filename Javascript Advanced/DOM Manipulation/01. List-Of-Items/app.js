function addItem() {


    const liElement = document.createElement('li');
    const addItem = document.getElementById('newItemText');
    liElement.textContent=addItem.value;

    const ul = document.querySelector('ul');

    ul.appendChild(liElement);

}