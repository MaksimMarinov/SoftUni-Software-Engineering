function solve(a){
    let n = Number(a[a.length-1]);
    let output= '';
    for(let i=0; i<a.length-1; i+=n){
        output+=(a[i]+' ');
    }
        console.log(output);
        
    
}solve(["dsa", "asd", "test", "test", "2"])