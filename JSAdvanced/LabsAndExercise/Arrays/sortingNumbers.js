function sortingNumbers(array) {
    array.sort((a, b) => a - b);
    let result = [];
    let lenght = array.length;
    for (let i = 0; i < lenght; i++) {
        let input;
        if (i % 2 == 0) {
            input = array.shift();
        } else {
            input = array.pop();
        }
        result.splice(i, 0, input)
    }
    return result;
} console.log(sortingNumbers([1, 65, 3, 52, 48, 63, 31, -3, 18, 56]));
