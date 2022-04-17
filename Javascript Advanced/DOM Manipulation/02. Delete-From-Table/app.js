function deleteByEmail() {
    const inputEmail = document.getElementsByName('email')[0].value;
    const result = document.getElementById('result');
    const info = document.querySelectorAll("tbody tr");
    for (const infoElement of info) {
        if(infoElement.children[1].textContent===inputEmail){
            const row = infoElement.parentNode;
            result.textContent='Deleted.';
            row.parentNode.removeChild(row);
            return;
        }
    }

        result.textContent='Not found.'

}