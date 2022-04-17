const element = document.getElementById('errorBox');
const out = element.querySelector('span');

export function notify(msg){
    out.textContent = msg;
    element.style.display='block';

    setTimeout(()=> element.style.display = 'none', 3000 );
}