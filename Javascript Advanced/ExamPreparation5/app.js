function solution() {
    const giftField = document.querySelector('.card input');
    const addBut = document.querySelector('.card button');
    const allFields = document.querySelector('.container').children;
    const listField = allFields[1].querySelector('ul')
    const sentField = allFields[2].querySelector('ul')
    const discardedField = allFields[3].querySelector('ul')
    addBut.addEventListener('click', add);
    const gifts = [];

    function add(e) {
        e.preventDefault();
        const gift = giftField.value;

        gifts.push(gift);
        listField.innerHTML = '';
        gifts.sort((g1, g2) => g1.localeCompare(g2)).forEach(gift => {
            const liEl = document.createElement('li');
            liEl.classList.add('gift');
            const sendBut = document.createElement('button');
            liEl.textContent = gift;
            sendBut.setAttribute('id', 'sendButton');
            sendBut.textContent = 'Send'
            const discardBut = document.createElement('button');
            discardBut.setAttribute('id', 'discardButton');
            discardBut.textContent='Discard';
            liEl.appendChild(sendBut);
            liEl.appendChild(discardBut);


            listField.appendChild(liEl);

            sendBut.addEventListener('click', send)

            discardBut.addEventListener('click', discard)

        });


        giftField.value = '';

    }

    function discard(e) {
        // const liEl = e.target.parentElement;
        //
        // const newLiEl = document.createElement('li');
        // let currentGift = liEl.textContent;
        // currentGift = currentGift.replace('SendDiscard','');
        // const index = gifts.indexOf(currentGift);
        // gifts.splice(index, 1);
        // newLiEl.classList.add('gift');
        // newLiEl.textContent = currentGift;
        // discardedField.appendChild(newLiEl);
        // liEl.remove();
        const newLiEl = createEl(e)
        discardedField.appendChild(newLiEl)
    }

    function send(e) {
        // const liEl = e.target.parentElement;
        //
        // const newLiEl = document.createElement('li');
        // let currentGift = liEl.textContent;
        // currentGift = currentGift.replace('SendDiscard','');
        // const index = gifts.indexOf(currentGift);
        // gifts.splice(index, 1);
        // newLiEl.classList.add('gift');
        // newLiEl.textContent = currentGift;
        // sentField.appendChild(newLiEl);
        //
        // liEl.remove();
        const newLiEl = createEl(e)
        sentField.appendChild(newLiEl);
    }

    function createEl(e){
        const liEl = e.target.parentElement;

        const newLiEl = document.createElement('li');
        let currentGift = liEl.textContent;
        currentGift = currentGift.replace('SendDiscard','');
        const index = gifts.indexOf(currentGift);
        gifts.splice(index, 1);
        newLiEl.classList.add('gift');
        newLiEl.textContent = currentGift;
        liEl.remove();
        return newLiEl;


    }


}