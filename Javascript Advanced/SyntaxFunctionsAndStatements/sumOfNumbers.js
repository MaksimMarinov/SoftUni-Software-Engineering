function sum(n1, n2){
        let num1 = Number(n1);
        let num2 = Number(n2);
        let sum =0;
        for(let i = num1; i<=num2; i++){
            sum+=i;
        }
        return sum;

}sum(1,3)