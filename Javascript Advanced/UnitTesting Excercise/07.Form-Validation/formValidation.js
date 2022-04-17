function validate() {
    const userNameRegex = /(^[A-Za-z0-9]{3,20}$)/;
    const passRegex = /(^[\w]{5,15}$)/;
    const emailRegex = /(^[\w]+@[\w]+\.[\w]+$)/;


    let isValidInput = true;
    let isChecked = false;

    const submitBut = document.getElementById('submit');
    submitBut.addEventListener('click', (e) => {
        e.preventDefault();
        const usernameField = document.getElementById('username');
        if (!userNameRegex.test(usernameField.value)) {
            isValidInput = false;
            usernameField.style.borderColor = 'red';
        } else {
            usernameField.style.border = 'none';
        }
        const passwordField = document.getElementById('password');
        const confirmPassword = document.getElementById('confirm-password');

        if(confirmPassword.value !== passwordField.value){
            isValidInput = false;
            passwordField.style.borderColor = 'red';
            confirmPassword.style.borderColor = 'red';
        }else{
            passwordField.style.border = 'none';
            confirmPassword.style.border = 'none';
        }
        if (!passRegex.test(passwordField.value)) {

            isValidInput = false;
            passwordField.style.borderColor = 'red';
            confirmPassword.style.borderColor = 'red';
        } else {
            passwordField.style.borderColor = 'none';
            confirmPassword.style.border = 'none';
        }

        if (!passRegex.test(confirmPassword.value) ) {

            isValidInput = false;
            confirmPassword.style.borderColor = 'red';
        } else {
            confirmPassword.style.border = 'none';
        }
        const email = document.getElementById('email');
        if (!emailRegex.test(email.value)) {
            isValidInput = false;
            email.style.borderColor = 'red';
        } else {
            email.style.border = 'none';
        }

        const validDiv = document.getElementById('valid');
        if (isValidInput) {
            validDiv.style.display = 'block';
        } else {
            validDiv.style.display = 'none';
        }

    });



    document.getElementById('company').addEventListener('change', (e) => {
        const companyField = document.getElementById('companyInfo');
        if (e.target.checked) {
            isChecked = true;
            companyField.style.display = 'block';

        } else {
            isChecked=false;
            companyField.style.display = 'none';
        }
        if(isChecked){
            const companyNumber = document.getElementById('companyNumber');
            if (Number(companyNumber.value) < 1000 || Number(companyNumber.value) > 9999) {
                companyNumber.style.borderColor = 'red';
            } else {

                companyNumber.style.borderColor = 'none';
            }
        }

    })
}
