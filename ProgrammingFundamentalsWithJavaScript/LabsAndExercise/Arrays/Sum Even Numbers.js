function solve(a){
    let sum=0;
    for(i=0; i<a.length; i++){
        if(Number(a[i])%2==0){
            sum += Number(a[i]);
        }
    }
    console.log(sum);
}solve(['1','2','3','4','5','6'])