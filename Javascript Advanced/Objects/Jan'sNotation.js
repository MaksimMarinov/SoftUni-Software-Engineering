function solve(input) {
    const numbers = [];
    const operations = {
        '+': (n1, n2) => n1 + n2,
        '-': (n1, n2) => n1 - n2,
        '*': (n1, n2) => n1 * n2,
        '/': (n1, n2) => n1 / n2,

    }
    for (const inputElement of input) {
        if (typeof inputElement == "number") {
            numbers.push(inputElement);
        } else if (typeof inputElement==='string'&&numbers.length < 2) {
            return 'Error: not enough operands!'
        }else{
            const firstNumber = numbers.pop();
            const secondNumber = numbers.pop();
            const newNumber = operations[inputElement](firstNumber, secondNumber);
            numbers.push(newNumber);
        }


    }

    if (numbers.length > 1) {
        return 'Error: too many operands!'
    }
    return numbers[0];
}

console.log(solve([31,
    2,
    '+',
    11,
    '/']
));