function toggle() {
   const button = document.querySelector('.button');
    button.textContent=button.textContent==='More'?'Less':'More';
    const extra = document.getElementById('extra');
    extra.style.display=extra.style.display==='none'?'block':'none';
}