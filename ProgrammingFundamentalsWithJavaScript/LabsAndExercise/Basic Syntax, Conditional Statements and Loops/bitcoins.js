function solve(a) {
    let totalMoney = 0;
    let gold = 0;
    let bitcoins = 0;
    let days = 0;
    for (let i = 1; i <= a.length; i++) {
        gold = a[i - 1];
        if (i % 3 == 0) {
            gold *= 0.7;
        }
        totalMoney += (gold * 67.51);
        if (totalMoney >= 11949.16) {
            while (totalMoney >= 11949.16) {
                bitcoins++;
                totalMoney -= 11949.16;
            }
            if (days == 0) {
                days = i;
            }
        }
    }
    console.log(`Bought bitcoins: ${bitcoins}`);
    if (bitcoins > 0) {
        console.log(`Day of the first purchased bitcoin: ${days}`);
    }
    console.log(`Left money: ${totalMoney.toFixed(2)} lv.`);
} solve([50, 100])