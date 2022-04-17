function extractText() {
    document.getElementById('result')
        .value = [...document.getElementsByTagName('li')]
        .map(e=>e.textContent).join('\n');
}
