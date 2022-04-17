// function solve() {
//     const fNameField = document.getElementById('fname');
//     const lNameField = document.getElementById('lname');
//     const emailField = document.getElementById('email');
//     const birthField = document.getElementById('birth');
//     const positionField = document.getElementById('position');
//     const salaryField = document.getElementById('salary');
//     const addWorkerBut = document.getElementById('add-worker');
//     addWorkerBut.addEventListener('click', addWorker);
//
//     const tBody = document.getElementById('tbody');
//     const sumField = document.getElementById('sum');
//     let curSum = 0;
//
//
//     function addWorker(e) {
//         e.preventDefault();
//         if (fNameField.value.trim() !== '' && lNameField.value.trim() !== ''
//             && emailField.value.trim() !== '' && birthField.value.trim() !== ''
//             && positionField.value.trim() !== '' && salaryField.value.trim() !== '') {
//
//             const trEl = document.createElement('tr');
//             trEl.innerHTML = `<td>${fNameField.value}</td><td>${lNameField.value}</td><td>${emailField.value}</td>
// <td>${birthField.value}</td><td>${positionField.value}</td><td>${salaryField.value}</td>`;
//             const firedBut = document.createElement('button');
//             firedBut.classList.add('fired');
//             firedBut.textContent='Fired';
//             const tdEl = document.createElement('td');
//             const editBut = document.createElement('button');
//             editBut.classList.add('edit');
//             editBut.textContent='Edit';
//             tdEl.appendChild(firedBut);
//             tdEl.appendChild(editBut);
//             trEl.appendChild(tdEl);
//             tBody.appendChild(trEl);
//             curSum+=Number(salaryField.value);
//             sumField.textContent=`${curSum.toFixed(2)}`;
//             editBut.addEventListener('click', edit);
//             firedBut.addEventListener('click', fire);
//         }
//
//         fNameField.value = '';
//         lNameField.value = '';
//         emailField.value = '';
//         birthField.value = '';
//         positionField.value = '';
//         salaryField.value = '';
//     }
//
//     function edit(e){
//
//         const values = Array.from(e.target.parentElement.parentElement.querySelectorAll('td'));
//         fNameField.value = values[0].textContent;
//         lNameField.value = values[1].textContent;
//         emailField.value = values[2].textContent;
//         birthField.value = values[3].textContent;
//         positionField.value = values[4].textContent;
//         salaryField.value = values[5].textContent;
//         curSum-=Number(salaryField.value);
//         sumField.textContent=`${curSum.toFixed(2)}`;
//         e.target.parentElement.parentElement.remove();
//     }
//
//     function fire(e){
//         const values = Array.from(e.target.parentElement.parentElement.querySelectorAll('td'));
//         salaryField.value = values[5].textContent;
//         curSum-=Number(salaryField.value);
//         sumField.textContent=`${curSum.toFixed(2)}`;
//         e.target.parentElement.parentElement.remove();
//     }
//
// }

// solve()

function solve() {
    let firstName = document.getElementById('fname');
    let lastName = document.getElementById('lname');
    let email = document.getElementById('email');
    let birthday = document.getElementById('birth');
    let positionField = document.getElementById('position');
    let salary = document.getElementById('salary');
    const addButton = document.getElementById('add-worker');
    addButton.addEventListener('click', addWorker);

    const body = document.getElementById('tbody');
    const sum = document.getElementById('sum');
    let totalSum = 0;


    function addWorker(e) {
        e.preventDefault();
        if (firstName.value!== '' && lastName.value!== ''
            && email.value !== '' && birthday.value !== ''
            && positionField.value !== '' && salary.value !== '') {

            const newElement = document.createElement('tr');
            newElement.innerHTML = `<td>${firstName.value}</td><td>${lastName.value}</td><td>${email.value}</td>
<td>${birthday.value}</td><td>${positionField.value}</td><td>${salary.value}</td>
<td><button class="fired">Fired</button><button class="edit">Edit</button></td>`;
            const firedBut = newElement.querySelector('.fired');

            const editBut =  newElement.querySelector('.edit');
            body.appendChild(newElement);
            totalSum+=Number(salary.value);
            sum.textContent=`${totalSum.toFixed(2)}`;
            editBut.addEventListener('click', editWorker);
            firedBut.addEventListener('click', fireWorker);
            function editWorker(){

                const tokens = Array.from(newElement.querySelectorAll('td'));
                firstName.value = tokens[0].textContent;
                lastName.value = tokens[1].textContent;
                email.value = tokens[2].textContent;
                birthday.value = tokens[3].textContent;
                positionField.value = tokens[4].textContent;
                salary.value = tokens[5].textContent;
                totalSum-=Number(salary.value);
                sum.textContent=`${totalSum.toFixed(2)}`;
                newElement.remove();
            }

            function fireWorker(){
                const values = Array.from(newElement.querySelectorAll('td'));
                let currentSalary = values[5].textContent;
                totalSum-=Number(currentSalary);
                sum.textContent=`${totalSum.toFixed(2)}`;
                newElement.remove();
            }
        }

        firstName.value = '';
        lastName.value = '';
        email.value = '';
        birthday.value = '';
        positionField.value = '';
        salary.value = '';
    }



}

solve()