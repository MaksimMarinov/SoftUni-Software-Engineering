function solve(number) {
    let oddSum = 0;
    let evenSum = 0;
    let numberAsString = number.toString();
    for (let i = 0; i < numberAsString.length; i++) {
        let currentNumber = Number(numberAsString[i]);
        if (currentNumber % 2 == 0) {
            evenSum += currentNumber;
        } else {
            oddSum += currentNumber;
        }
    }

    console.log(`Odd sum = ${oddSum}, Even sum = ${evenSum}`);

}solve( 3495892137259234);