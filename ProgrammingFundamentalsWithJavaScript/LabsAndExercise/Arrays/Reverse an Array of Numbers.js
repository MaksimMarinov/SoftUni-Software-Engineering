function solve(n, array){
    
let output='';
    for(let i=0; i<n; i++){
        output += array[n-1-i]+' ';
    }
    console.log(output);
}solve(4, [-1, 20, 99, 5]);