function solve(arrayOfCommands){
    let sum = 0;
  for(let i = 0; i<arrayOfCommands.length; i++){
      let command = arrayOfCommands[i];
      switch(command){
          case"soap":
          sum+=10;
          break;
          case"water":
          sum=sum*1.2
          break;
          case"vacuum cleaner":
          sum=sum*1.25;
          break;
          case"mud":
          sum-=(sum*0.1);
          break;
        }

    

      
}   
console.log(`The car is ${sum.toFixed(2)}% clean.`); 
  
}solve(['soap', 'soap', 'vacuum cleaner', 'mud', 'soap', 'water'])