function sumTable() {
    const elements = document.querySelectorAll('table tr');
    let sum = 0;
    for (let i = 1; i < elements.length-1; i++) {
        const cols = elements[i].children;
        sum += Number(cols[cols.length-1].textContent);
    }
    document.getElementById('sum').textContent=sum;
}

