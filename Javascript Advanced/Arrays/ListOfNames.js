function listOfNames(input){
    return input.sort((a,b)=>a.localeCompare(b)).map((name, index)=>{

        return  `${index+1}.${name}`;
    })
        .join('\n')
}

console.log(listOfNames(["John", "Bob", "Christina", "Ema"]));