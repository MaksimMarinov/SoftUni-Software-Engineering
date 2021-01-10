function solve(input){
let output=[];
while(input.length>0){
    let tokens = input.shift().split(' ');
    if(output.includes(tokens[0])&& tokens[2]=='going!'){
        console.log(`${tokens[0]} is already in the list!`);
    }else if(!output.includes(tokens[0])&& tokens[2]=='going!'){
        output.push(tokens[0]);
        
    }else if(output.includes(tokens[0])&& tokens[2]=='not'){
        let index = output.indexOf(tokens[0])
        output.splice(index,1);
    }else{
        console.log(`${tokens[0]} is not in the list!`);
    }
}output.forEach(e=>console.log(e));
}solve(['Allie is going!',
'George is going!',
'John is not going!',
'George is not going!']
)