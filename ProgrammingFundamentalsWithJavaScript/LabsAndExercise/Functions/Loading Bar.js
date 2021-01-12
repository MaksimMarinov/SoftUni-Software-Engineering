function solve(number){
    let digit=number/10;
    let output=''
    for(let i=0; i<10; i++){
        if(i<digit){
            output+='%';
        }else{
            output+='.';
        }
         
    }
    
    if(digit<10){
        console.log(`${number}% [${output}]`);
        console.log('Still loading...');
    }else{
        console.log('100% Complete!');
        console.log(`[${output}]`);
    }
    

}solve(100)