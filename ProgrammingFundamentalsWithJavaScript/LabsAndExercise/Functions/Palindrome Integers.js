function solve(array){
    let isItPalindrom=(number)=>{
        let numberAsString = number.toString();
        let lastIndex = numberAsString.length-1;
        for(let i=0; i<lastIndex/2; i++){
            if(numberAsString[i]!=numberAsString[lastIndex]){
                return false;
            }
            lastIndex--;
            
        }
        return true;
    }

    for(let i =0; i<array.length; i++){
        console.log(isItPalindrom(array[i]));
    }
    
}solve([123,323,421,121]);