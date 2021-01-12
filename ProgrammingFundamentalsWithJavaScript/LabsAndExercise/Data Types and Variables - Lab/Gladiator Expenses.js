function solve(a1, a2, a3, a4, a5){
    let totalSum = 0;
    for(let i=1; i<=a1; i++){
        if(i%2==0){
            totalSum += a2;
        }
        if(i%3==0){
        totalSum+=a3;
        }
        if(i%6==0){
            totalSum+=a4;
        }
        if(i%12==0){
            totalSum+=a5;
        }
    }
    console.log(`Gladiator expenses: ${totalSum.toFixed(2)} aureus`);
}solve(23,
    12.50,
    21.50,
    40,
    200
    )