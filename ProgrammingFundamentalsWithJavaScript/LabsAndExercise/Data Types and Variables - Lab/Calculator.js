function solve(a1, a2, a3) {
    let result;
    switch (a2) {

        case "+":
            result = (a1 + a3).toFixed(2);
            break;
        case "-":
            result = (a1 - a3).toFixed(2);
            break;
        case "/":
            result = (a1 / a3).toFixed(2);
            break;
        case "*":
            result = (a1 * a3).toFixed(2);
            break;

    }
    console.log(result);
} solve(5,
    '+',
    10
)