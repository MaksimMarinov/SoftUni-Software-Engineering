function solve(n1, n2) {
    let factoriel = e => {
        let sum = 1;
        for (let i = 1; i <= e; i++) {
            sum *= i;
        }return sum;
    }
    let dividedNumber = factoriel(n1) / n2;
    console.log(dividedNumber.toFixed(2));
}solve(6,2
    )