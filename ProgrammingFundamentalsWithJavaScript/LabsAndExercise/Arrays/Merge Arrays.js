function solve(a1, a2) {
    let newArr = [];
    for (let i = 0; i < a1.length; i++) {
        if (i % 2 == 0) {
            newArr[i] = Number(a1[i]) + Number(a2[i]);
            
        } else {
            newArr[i] = a1[i] + a2[i];
        }
    }
    let output = '';
    for (let i = 0; i < newArr.length; i++) {
        let del = ' - ';
        if (i == newArr.length - 1) {
            del = '';
        }
        output += newArr[i] + del;
    }
    console.log(output);

} solve(['5', '15', '23', '56', '35'],
    ['17', '22', '87', '36', '11']
)