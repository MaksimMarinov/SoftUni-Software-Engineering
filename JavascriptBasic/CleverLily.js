function solve(a1, a2, a3) {
    let money = 0;
    let toys = 0;
    let moneyToTake = 10;
    for (let i = 1; i <= Number(a1); i++) {
        if (i % 2 == 0) {
            money += (moneyToTake - 1);
            moneyToTake += 10;
        } else {
            toys++;
        }
    }
    let sum = money + (toys * Number(a3));
    let diff = (Math.abs(sum - Number(a2))).toFixed(2);
    if (sum >= Number(a2)) {
        console.log(`Yes! ${diff}`)
    } else {
        console.log(`No! ${diff}`)
    }
} solve("21", "1570.98", "3");