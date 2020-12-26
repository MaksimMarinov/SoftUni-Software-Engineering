function solve(a) {
    let command = a[0];
    let index = 0;
    let sum = 0.0;
    while (command !== "NoMoreMoney") {
        let number = Number(command);
        if (number < 0) {
            console.log("Invalid operation!");
            break;
        } else {
            sum += number;
            console.log(`Increase: ${number.toFixed(2)}`);
        }

        index++;

        command = a[index];
    }
    console.log(`Total: ${sum.toFixed(2)}`);
} solve(["120",
    "45.55",
    "-150"])
    ;