function magicMatrices(matrix) {
    let result = true;
    let firstRowSum = sumRow(matrix[0]);

    for (let i = 0; i < matrix.length; i++) {
        let currentRow = matrix[i];
        let currentSum = sumRow(currentRow);
        const colSum = sumColumns(i, Math.min(matrix[i].length, matrix.length), matrix);
        if (currentSum !== firstRowSum || colSum !== currentSum) {
            result = false;
            break;
        }

    }

    return result;

    function sumColumns(row, length, matrix) {
        let columnSum = 0;
        for (let l = 0; l < length; l++) {
            columnSum += matrix[l][row];

        }
        return columnSum;
    }


    function sumRow(input) {
        return input.reduce((a, b) => a + b);
    }

}

console.log(magicMatrices([[4, 5, 6],
    [6, 5, 4],
    [5, 5, 5]]
));