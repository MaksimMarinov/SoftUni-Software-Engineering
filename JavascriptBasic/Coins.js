function solve(a) {
    let sum = Number(a);
    let count = 0;
    while (sum > 0) {

        count++;
        if (sum >= 2) {
            sum -= 2;
        } else if (sum < 2 && sum >= 1) {
            sum -= 1;
        } else if (sum < 1 && sum >= 0.50) {
            sum -= 0.50;
        } else if (sum < 0.50 && sum >= 0.20) {
            sum -= 0.20;
        } else if (sum < 0.20 && sum >= 0.10) {
            sum -= 0.10;
        } else if (sum < 0.10 && sum >= 0.05) {
            sum -= 0.05;
        } else if (sum < 0.05 && sum >= 0.02) {
            sum -= 0.02;
        } else {
            sum -= 0.01;
        }
        sum = sum.toFixed(2);

    }
    console.log(count);
} solve(["1.51"])