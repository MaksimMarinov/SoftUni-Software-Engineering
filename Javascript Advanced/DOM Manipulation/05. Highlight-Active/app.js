function focused() {
   Array.from(document.getElementsByTagName('input'))
       .forEach(d=>{
           d.addEventListener('focus', (ev)=>ev.target.parentNode.className='focused');
           d.addEventListener('blur', (ev)=>ev.target.parentNode.className='');
       });

}