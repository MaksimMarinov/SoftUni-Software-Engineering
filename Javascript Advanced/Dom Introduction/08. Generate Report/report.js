function generateReport() {
 const output = document.getElementById('output');
 const colNames = document.querySelectorAll('thead tr th input');
 const colContent = document.querySelectorAll('tbody tr');
    const result = [];
    for (let i = 0; i < colContent.length; i++) {
        const object = {};
        for (let j = 0; j < colNames.length; j++) {
            if(colNames[j].checked){
                object[colNames[j].name]= colContent[i].children[j].textContent
            }

        }
        result.push(object)
    }

    output.textContent=JSON.stringify(result)
}