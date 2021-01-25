function findBiggestEl(inputMatrix) {
    let biggest = Number.MIN_SAFE_INTEGER;
    inputMatrix.forEach(array => {
        array.forEach(number => {
            if (number > biggest) {
                biggest = number;
            }
        })

    });
    return biggest
}

console.log(findBiggestEl([[20, 50, 10],
[8, 33, 145]]
));