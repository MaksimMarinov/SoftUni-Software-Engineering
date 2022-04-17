function solve() {
    const creatorField = document.getElementById('creator');
    const titleField = document.getElementById('title');
    const categoryField = document.getElementById('category');
    const contentField = document.getElementById('content');
    const createBtn = document.querySelector('form button');
    createBtn.addEventListener('click', create);
    const posts = document.querySelector('main section');
    const archiveArticles = [];
    const archiveSection = document.querySelector('.archive-section ol');


    function create(e) {
        e.preventDefault();

            const article = document.createElement('article');
            article.innerHTML = `<h1>${titleField.value}</h1>
                                <p>Category:<strong>${categoryField.value}</strong></p>
                                 <p>Creator:<strong>${creatorField.value}</strong></p>
                                <p>${contentField.value}</p>`

            // const h1El = document.createElement('h1');
            // h1El.textContent = `${titleField.value}`
            // const pEl1 = document.createElement('p');
            // pEl1.innerHTML = `Category:<strong>${categoryField.value}</strong>`
            // const pEl2 = document.createElement('p');
            // pEl2.innerHTML = `Creator:<strong>${creatorField.value}</strong>`;
            // const pEl3 = document.createElement('p');
            // pEl3.textContent = `${contentField.value}`;
            const divEl = document.createElement('div');
            divEl.classList.add('buttons');
            const delBtn = document.createElement('button');
            delBtn.classList.add('btn', 'delete');
            delBtn.textContent = 'Delete';
            const arcBtn = document.createElement('button');
            arcBtn.classList.add('btn', 'archive');
            arcBtn.textContent = 'Archive';

            // const delBtn = .querySelector(".buttons").children[0];
            delBtn.addEventListener('click', deletePost)
            // const arcBtn = document.querySelector('.buttons').children[1]
            arcBtn.addEventListener('click', archive);
            divEl.appendChild(delBtn);
            divEl.appendChild(arcBtn);
            article.appendChild(divEl)
            posts.appendChild(article);

            // divEl.appendChild(delBtn)
            // divEl.appendChild(arcBtn);




        titleField.value = '';
        contentField.value = '';
        categoryField.value = '';
        creatorField.value = '';

    }

    function deletePost(e) {
        e.target.parentElement.parentElement.remove();
    }

    function archive(e) {
        const nameOfTheArticle = e.target.parentElement.parentElement.querySelector('h1').textContent;
        archiveArticles.push(nameOfTheArticle);
        e.target.parentElement.parentElement.remove();
        archiveSection.innerHTML = '';
        archiveArticles.sort((a, b) => a.localeCompare(b)).forEach(article => {
            const liEl = document.createElement('li');
            liEl.textContent = article;
            archiveSection.appendChild(liEl);
        })


    }

}
