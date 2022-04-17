function createDeck(cards) {

    let result = [];
    for (let card of cards) {

        const face = card.slice(0, -1);
        const suit = card.slice(-1);
        try {
            result.push(createCard1(face, suit));
        }catch (e) {
            console.log('Invalid card: '+card);
            return;
        }


    }
    console.log(result.join(' '));



    function createCard1(face, suit) {
        const faces = ['2', '3', '4', '5', '6', '7', '8', '9', '10', 'J', 'Q', 'K', 'A'];
        if (faces.includes(face) == false) {
            throw new Error('Invalid face')
        }
        const suits = {
            'S': '\u2660',
            'H': '\u2665',
            'D': '\u2666',
            'C': '\u2663',
        }

        if (Object.keys(suits).includes(suit) === false) {
            throw new Error('Invalid suite')
        }

        return {
            face,
            suit: suits[suit],
            toString() {
                return this.face + this.suit;
            }
        }
    }
}

createDeck(['5S', '3D', 'QD', '1C']);

