function solve(a){
    let array =a.shift().split(' ').map(x=>Number(x));
    let maxCapacity =a.shift();
    for(let i = 0; i<array.length; i++){
        array[i]=Number(array[i]);
    }

    while(a.length>0){
        let tokens = a.shift().split(' ');
        if(tokens[0]=='Add'){
            array.push(Number(tokens[1]));
        }else{
            let people = Number(tokens[0]);
            for(let i=0; i<array.length; i++){
                if(array[i]+people<=maxCapacity){
                    array.splice(i,1,(array[i]+people));
                    break;
                }
            }
        }
        
        
    }
    console.log(array.join(' '));
    
   
}solve(['0 0 0 10 2 4',
'10',
'Add 10',
'10',
'10',
'10',
'8',
'6']

)