function solve(input){
    input.sort((a,b)=>{
        if(a.length!=b.length){
            return a.length-b.length;
        }else{
            return a.localeCompare(b);
        }
    }).forEach(e => console.log(e));
   
}solve(["Isacc", "Theodor", "Jack", "Harrison", "George"])