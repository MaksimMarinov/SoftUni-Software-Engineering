function solve(number){
    for(let i = 0; i<number;i++){
        let output='';
        for(let l =0; l<number; l++){
            let separator = ' ';
            if(l==number-1){
                separator='';
            }
            output+='*'+separator;
        }
        console.log(output);
    }
}solve(5)