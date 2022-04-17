function addItem() {
    const text = document.getElementById('newItemText');
    const value = document.getElementById('newItemValue');
    const newElement = document.createElement('option');
    newElement.textContent = text.value;
    newElement.value = value.value;
    const menu = document.getElementById('menu');
    menu.appendChild(newElement);
    text.value = '';
    value.value = '';

}