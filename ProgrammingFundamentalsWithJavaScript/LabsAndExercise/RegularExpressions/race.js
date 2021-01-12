function solve(input){
let names = input.shift().split(', ');
let regexNames = /[^A-Za-z]/g;
let regexNumber = /[^0-9]/g;
let racers = {};
input.pop();

for (let data of input) {
    //let distanse =0;
    let name = data.split(regexNames).join('');
    
    if(names.includes(name)){
        let numbers = data.split(regexNumber).join('');
        let distance = Array.from(numbers).reduce((a,b)=>{
            return Number(a)+Number(b);
            
        })
        if(racers[name]){
            racers[name] += distance;
        }else{
            racers[name] = distance;
        }
        }
       
    
    
}
let sorted = Object.keys(racers).sort((a,b)=>racers[b]-racers[a]).slice(0,3);
for(let index in sorted){
if(index==0){
        console.log(`1st place: ${sorted[index]}`);
}else if(index==1){
        console.log(`2nd place: ${sorted[index]}`);
}else if(index==2){
        console.log(`3rd place: ${sorted[index]}`);

    }
}




}solve( ['George, Peter, Bill, Tom',
'G4e@55or%6g6!68e!!@',
'R1@!3a$y4456@',
'B5@i@#123ll',
'G@e54o$r6ge#',
'7P%et^#e5346r',
'T$o553m&6',
'end of race'
])