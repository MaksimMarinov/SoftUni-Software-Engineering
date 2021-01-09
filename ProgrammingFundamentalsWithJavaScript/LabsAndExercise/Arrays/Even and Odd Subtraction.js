function solve(a){
    let sum = 0;
    for(let i = 0; i<a.length; i++){
        if(a[i]%2==0){
            sum+=a[i];
        }else{
            sum-=a[i];
        }
    }
    console.log(sum)
}solve([1,2,3,4,5,6])