function solve(a) {

    let output = '';
    
    for (let i = 0; i < a.length; i++) {
        let maxNumber = a[i];
        let isBigger = true;
        for (let j = i+1; j < a.length; j++) {
            if (a[j] >= maxNumber) {
                isBigger = false;
                break;
            }
        }
        if (isBigger) {
            output += maxNumber + ' ';
        }

    }

    console.log(output);
} solve([41, 41, 34, 20])