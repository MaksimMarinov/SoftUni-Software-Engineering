function solve() {
    const taskField = document.getElementById('task');
    const descriptionField = document.getElementById('description');
    const dateField = document.getElementById('date');
    const addBut = document.getElementById('add');

    addBut.addEventListener('click', add);
    const orangeField = document.querySelector('.orange').parentElement.nextElementSibling;
    const inProgressField = document.getElementById('in-progress');
    const green = document.querySelector('.green').parentElement.nextElementSibling;


    function add(e) {
        e.preventDefault();
        if (taskField.value.trim() != '' && descriptionField.value.trim() != '' && dateField.value != '') {
            const article = document.createElement('article');
            article.innerHTML = `<h3>${taskField.value}</h3>
                            <p>Description: ${descriptionField.value}</p>
                            <p>Due Date: ${dateField.value}</p>`;
            const div = document.createElement('div');
            const startBut = document.createElement('button');
            const delBut = document.createElement('button');
            div.classList.add('flex');
            startBut.classList.add('green');
            startBut.textContent = 'Start';
            delBut.classList.add('red');
            delBut.textContent = 'Delete';
            div.appendChild(startBut);
            div.appendChild(delBut);
            article.appendChild(div);
            delBut.addEventListener('click', del);
            startBut.addEventListener('click', start);
            orangeField.appendChild(article);
        }
        taskField.value = '';
        descriptionField.value = '';
        dateField.value = ''
    }

    function del(e) {
    e.target.parentElement.parentElement.remove();

    }

    function finish(e){
        const curEl = e.target;
        const divEl = curEl.parentElement;
        const artEl = divEl.parentElement;
        divEl.remove();
        green.appendChild(artEl);
    }

    function start(e) {
        const curEl = e.target;
        const divEl = curEl.parentElement;
        const artEl = divEl.parentElement;

        divEl.removeChild(curEl);
        const finishBut = document.createElement('button');
        finishBut.classList.add('orange');
        finishBut.textContent='Finish';
        divEl.appendChild(finishBut);
        finishBut.addEventListener('click', finish)
        inProgressField.appendChild(artEl);
        curEl.parentElement.parentElement.remove();
    }
}