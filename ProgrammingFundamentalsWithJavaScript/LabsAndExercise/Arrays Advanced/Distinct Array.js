function solve(arr){
    let output=[];
    for(let i = 0; i<arr.length; i++){
       if (!output.includes(arr[i])){
           output.push(arr[i]);
       }
        
    }
    console.log(output.join(' '));

}solve([20, 8, 12, 13, 4, 4, 8, 5])