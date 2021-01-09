function solve(a1, a2) {
    let sum = 0;
    let isTrue = true;
    let index;
    for (let i = 0; i < a1.length; i++) {
        if (a1[i] == a2[i]) {
            sum += Number(a1[i]);
        } else {
            isTrue = false;
            index = i;
            break;
        }
    }
    if (isTrue) {
        console.log('Arrays are identical. Sum: ' + sum);
    } else {
        console.log(`Arrays are not identical. Found difference at ${index} index`);
    }
    
} solve(['1'], ['10']);
