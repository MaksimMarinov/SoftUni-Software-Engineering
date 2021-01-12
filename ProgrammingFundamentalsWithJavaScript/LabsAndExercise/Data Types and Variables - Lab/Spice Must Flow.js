function solve(yeld) {
    let days = 0;
    let totalExtracted = 0;
    while (yeld >= 100) {
        days++;
        totalExtracted += (yeld - 26);
        yeld -= 10;
    }
    if (totalExtracted < 26) {
        totalExtracted == 0;
    } else {
        totalExtracted -= 26;
    }
    console.log(days);
    console.log(totalExtracted);
}solve(111);