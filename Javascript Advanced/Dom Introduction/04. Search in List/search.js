function search() {
    const list = Array.from(document.querySelectorAll('ul li'));
    let matches = 0;
    const searchWord = document.getElementById('searchText').value;
    for (const element of list) {
        if (element.textContent.includes(searchWord)) {
            matches++;
            element.style.fontWeight = 'bold';
            element.style.textDecoration = 'underline';
        } else {
            element.style.fontWeight = 'normal';
            element.style.textDecoration = '';
        }
    }

    document.getElementById('result').textContent = `${matches} matches found`;
}
