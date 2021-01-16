function solve(number) {
    let sum = 0;
    let check = true;
    let lastDigit = number % 10;
    while (number) {
        let digit = number % 10;
        if (digit != lastDigit) {
            check = false;
        }
        sum += digit;
        number = Math.floor(number / 10);
    }
    console.log(check);
    console.log(sum);
} solve(222)