function create(words) {
    const content = document.getElementById('content');
    for (const word of words) {
        const div = document.createElement('div');
        const p = document.createElement('p');
        p.textContent = word;
        p.style.display = 'none';
        div.appendChild(p);
        div.addEventListener('click', onClick)
        content.appendChild(div);
    }

    function onClick(ev) {
        ev.target.children[0].style.display='block';
    }
}