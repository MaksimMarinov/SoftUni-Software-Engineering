function equalNeighbors(matrix) {
    let countEquals = 0;

    for (let i = 0; i < matrix.length - 1; i++) {
        for (let j = 0; j < matrix[i].length; j++) {

            if (matrix[i][j] == matrix[i + 1][j]) {
                countEquals++;
            }
    }




    }
    for (let i = 0; i < matrix.length; i++) {
        for (let j = 0; j < matrix[i].length - 1; j++) {

            if (matrix[i][j] == matrix[i][j + 1]) {
                countEquals++;
            }



        }
    }
    return countEquals;
} console.log(equalNeighbors([['test', 'yes', 'yo', 'ho'],
['well', 'done', 'yo', '6'],
['not', 'done', 'yet', '5']]


));
