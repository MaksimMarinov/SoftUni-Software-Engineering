function solve(arr) {
    arr.sort((a, b) => a - b);
    let output = [];
    let lastIndex = arr.length - 1;
    let firstIndex = 0;
    for (let i = 0; i < arr.length; i++) {
        if (i % 2 == 0) {
            output.splice(i, 0, arr[lastIndex]);
            lastIndex--;
        } else {
            output.splice(i, 0, arr[firstIndex]);
            firstIndex++;
        }
    } console.log(output.join(' '));
} solve([1, 21, 3, 52, 69, 63, 31, 2, 18, 94])