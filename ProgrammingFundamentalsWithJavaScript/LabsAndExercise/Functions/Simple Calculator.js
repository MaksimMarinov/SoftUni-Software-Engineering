function calculator(numOne, numTwo, operator) {
    let result;
    switch (operator) {
        case 'multiply':
            result = (a, b) => a * b;
            break;
        case 'divide':
            result = (a, b) => a / b;
            break;
        case 'add':
            result = (a, b) => a + b;
            break;
        case 'subtract':
            result = (a, b) => a - b;
            break;
    }
    console.log(result(numOne, numTwo))
}