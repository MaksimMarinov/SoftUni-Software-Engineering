function attachGradientEvents() {
    const result = document.getElementById('result');
    let gradient = document.getElementById('gradient');
    gradient.addEventListener("mousemove", onMove);
    gradient.addEventListener("mouseout", gradientOut);


    function onMove(ev) {

        let power = Math.floor((ev.offsetX / ev.target.clientWidth) * 100);
        result.textContent = power + '%';
    }

    function gradientOut() {
        result.textContent = '';
    }

}