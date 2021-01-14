function solve(num1, num2){
    for(let i=Math.min(num1, num2); i>0; i--){
        if(num1%i==0&&num2%i==0){
            console.log(i);
            break;
        }
    }
}solve(2154, 458)