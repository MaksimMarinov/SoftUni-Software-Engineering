function solve(a1, a2) {
    let n1 = a1;
    let n2 = a2;
    if (n2 > 15) {
        n2 = 15;
    }
    n1 = n1.toFixed(n2);
    n1 = parseFloat(n1);
    console.log(n1);
} solve(10.5, 3)