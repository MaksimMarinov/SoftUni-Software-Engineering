function magicMatrices(matrix) {
    let sumToCheck = sumRows(matrix[0]);
    for (let i = 0; i < matrix.length; i++) {
        let columnSum = sumColumns(i, Math.min(matrix[i].length, matrix.length), matrix);


        let currentSum = (sumRows(matrix[i]))
        if (currentSum != sumToCheck || columnSum != sumToCheck) {
            return false;
        }
    }
    return true;
    function sumRows(line) {
        let sum = 0;
        line.forEach(element => {
            sum += element;
        });
        return sum;

    }
    function sumColumns(row, length, matrix) {
        let columnSum = 0;
        for (let l = 0; l < length; l++) {
            columnSum += matrix[l][row];

        }
        return columnSum;
    }

} console.log(magicMatrices([[4, 5, 6],
[6, 5, 4],
[5, 5, 5]]




));
