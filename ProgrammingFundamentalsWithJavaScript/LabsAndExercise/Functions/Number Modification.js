function solve(number){
    let average = e=>{
        let numberAsString = e.toString();
        let sum =0;
        for(let i =0; i<numberAsString.length; i++){
            let current = Number(numberAsString[i])
            sum+= current;
        }
        return sum/numberAsString.length;
    }
    let currentNumber = number;
    while(average(currentNumber)<5){
        let currentNumberAsString = currentNumber.toString();
        currentNumberAsString+='9';
        currentNumber=Number(currentNumberAsString);
    }
    console.log(currentNumber);
}solve(101)