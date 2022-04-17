function ticTacToe(moves) {

    const field = [['false', 'false', 'false'], ['false', 'false', 'false'], ['false', 'false', 'false']];
    const firstPlayerSign = 'X';
    const secondPlayerSign = 'O';
    let win = false;

    for (let i = 0; i < moves.length; i++) {

        let currentMove = moves[i];
        let rowMove = currentMove.substring(0, 1);
        let colMove = currentMove.substring(2, 3);

        if (field[rowMove][colMove] === 'false') {
            if (i % 2 === 0) {
                field[rowMove][colMove] = firstPlayerSign;
                let check = checkCol(colMove, secondPlayerSign);
                if (!checkRow(field[rowMove], secondPlayerSign) || !checkCol(colMove, secondPlayerSign) || !checkDiagonals(secondPlayerSign)) {
                    console.log('Player X wins!')
                    win = true;
                    break;
                }
            } else {
                field[rowMove][colMove] = secondPlayerSign;
                if (!checkRow(field[rowMove], firstPlayerSign) || !checkCol(colMove, firstPlayerSign) || !checkDiagonals(firstPlayerSign)) {
                    console.log('Player O wins!');
                    win = true;
                    break;
                }
            }
        } else {
            moves.splice(i, 1);
            i--;
            console.log('This place is already taken. Please choose another!')
        }
        if (checkIfieldIsFull()) {
            break;
        }


    }

    function checkRow(row, sign) {
        for (let i = 0; i < row.length; i++) {
            if (row[i] == 'false' || row[i] == sign) {
                return true;
            }

        }

        return false;
    }

    function checkCol(col, sign) {

        for (let i = 0; i < field.length; i++) {
            let current = field[col][i];
            if (field[i][col] == 'false' || field[i][col] == sign) {
                return true;
            }
        }
        return false;
    }

    function checkDiagonals(sign) {
        let checkUpLeft = false;
        let checkUpRight = false;
        let checkDownLeft = false;
        let checkDownRight = false;
        for (let i = 0; i < 3; i++) {
            if (field[i][i] == 'false' || field[i][i] == sign) {
                checkUpLeft = true;
                break;
            }
        }

        for (let i = 2; i >= 0; i--) {
            if (field[i][i] == 'false' || field[i][i] == sign) {
                checkDownRight = true;
                break;
            }
        }

        let colIndex = 0;
        for (let i = 2; i >= 0; i--) {
            if (field[i][colIndex] == 'false' || field[i][colIndex] == sign) {
                checkUpRight = true;
                break;
            }
            colIndex++;
        }
        colIndex = 2;
        for (let i = 0; i < 3; i++) {
            if (field[i][colIndex] == 'false' || field[i][colIndex] == sign) {
                checkDownLeft = true;
                break;
            }
            colIndex--;
        }


        if (checkUpLeft === true && checkUpRight === true && checkDownRight === true && checkDownLeft === true) {
            return true;
        }
        return false;
    }

    function checkIfieldIsFull() {
        for (let i = 0; i < field.length; i++) {
            for (let j = 0; j < field.length; j++) {
                if (field[i][j] === 'false') {
                    return false;
                }
            }

        }
        return true;
    }

    if (win == false) {
        console.log('The game ended! Nobody wins :(')
    }

    console.log(field.map(row => row.join('\t')).join('\n'))
}

ticTacToe(["2 0",
    "0 0",
    "0 2",
    "0 1",
    "1 1",
    "1 2",
    "1 1",
    "2 1",
    "2 2",
    "0 0"]
);

