function charity(a1, a2, a3, a4, a5) {
    let baker = Number(a2);
    let pancake = Number(a5);
    let days = Number(a1);
    let cakes = Number(a3);
    let gofrets = Number(a4);
    let sum1 = ((cakes * 45 + gofrets * 5.80 + pancake * 3.2) * baker);
    let sum = (sum1 * days) * (7 / 8);
    let result = 10 % 3;
    console.log(sum);

} charity("131",
    "5",
    "9",
    "33",
    "46");

