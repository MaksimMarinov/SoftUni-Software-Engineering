function solve(n,k){;
    let array = [1];
    let sumLast = (arr, number)=>{
        if(arr.length<number){
            number=arr.length;
        }
        let sum = 0;
        for(let i=1; i<=number; i++){
            sum += arr[arr.length - i];
        }
        return sum;
    }
    for(let i=1; i<n; i++){
        array.push(sumLast(array, k))
    }
    console.log(array.join(' '));
}solve(8, 2)