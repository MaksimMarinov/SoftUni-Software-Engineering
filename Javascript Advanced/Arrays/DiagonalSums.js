function diagonalSums(input) {
    let leftSum = 0;
    let rightSum = 0;
    for (let i = 0; i < input.length; i++) {
        leftSum += input[i][i];
        rightSum += input[i][input.length - 1 - i];
    }

    console.log(leftSum, rightSum)
}

diagonalSums([[20, 40],
    [10, 60]]);
diagonalSums(
    [[3, 5, 17],
        [-1, 7, 14],
        [1, -8, 89]]
)