function solve(num1, num2, num3) {
    let countNegative = 0;
    let arrayOfNumbers = [num1, num2, num3];
    for (let i = 0; i < 3; i++) {

        if (arrayOfNumbers[i] < 0) {
            countNegative++;
        }
        if(arrayOfNumbers[i]==0){
            countNegative=0;
        }
    }

    if (countNegative == 0 || countNegative == 2) {
        console.log('Positive');
    } else {
        console.log('Negative');
    }
} solve(-1, 0, 1)