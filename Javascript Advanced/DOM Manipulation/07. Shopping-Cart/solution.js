function solve() {
    document.getElementsByClassName('shopping-cart')[0].addEventListener('click', add);
    document.getElementsByClassName('checkout')[0].addEventListener('click', check);
    const output = document.getElementsByTagName('textarea')[0];
    output.value = '';
    const cart = []

    function add(ev) {
        if (ev.target.tagName == 'BUTTON' && ev.target.classList.contains('add-product')) {
            const product = ev.target.parentNode.parentNode;
            const name = product.querySelector('.product-title').textContent;
            const price = Number(product.querySelector('.product-line-price').textContent);
            output.value += `Added ${name} for ${price.toFixed(2)} to the cart.\n`;
            cart.push({name, price});
        }
    }

    function check() {
        const products = new Set();
        cart.forEach(p => products.add(p.name));
        const totalPrice = cart.reduce((t, c) => t + c.price, 0);
        output.value += `You bought ${[...products.keys()].join(', ')} for ${totalPrice.toFixed(2)}.`
        disableButtons();
    }

    function disableButtons() {
        const buttons = Array.from(document.querySelectorAll('button'));
        buttons.forEach(b => b.disabled);
    }
}