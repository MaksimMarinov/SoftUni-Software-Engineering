function validate() {
    document.getElementById('email').addEventListener('change', onChange);
    const regex = /^[a-z]+@[a-z]+\.[a-z]+$/;
    function onChange(ev){
        if(regex.test(ev.target.value)){
            ev.target.classList.remove('error')
        }else{
            ev.target.classList.add('error')
        }
    }

}