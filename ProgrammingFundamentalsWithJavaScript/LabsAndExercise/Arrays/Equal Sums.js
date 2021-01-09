function solve(array) {
    for (let i = 0; i < array.length; i++) {
        let rightSum = 0;
        let leftSum = 0;
        for (let j = 0; j < array.length; j++) {
            leftSum = 0;
            for (let k = 0; k < j; k++) {
                leftSum += array[k];
            }
            rightSum = 0;
            for (let k = array.length - 1; k > j; k--) {
                rightSum += array[k];
            }

            if (leftSum === rightSum) {
                console.log(j);
                return;
            }
        }

    }
    if (array.length == 1) {
        console.log(0);
    } else {
        console.log('no')
    }
} solve([1, 2, 3])

