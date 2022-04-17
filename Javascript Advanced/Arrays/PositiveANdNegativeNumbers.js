function positiveANdNegativeNumbers(input) {
    const result = [];
    input.forEach(number => {
        number >= 0 ? result.push(number) : result.unshift(number)
    });
    return result.join('\n');
}

console.log(positiveANdNegativeNumbers([7, -2, 8, 9]));