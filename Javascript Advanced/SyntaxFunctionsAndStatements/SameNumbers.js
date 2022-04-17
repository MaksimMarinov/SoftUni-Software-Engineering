function sameNumbers(number){
    let currentDigit;
    const numberAsString = number.toString();
    let lastDigit= Math.floor(number%10);
    number /= 10;
    let sum=lastDigit;
    let result = true;

    for (let i = 1; i < numberAsString.length; i++) {
       currentDigit = Math.floor(number%10);
        if(currentDigit!=lastDigit&&result==true){

            result=false;
        }
        sum += currentDigit;
        lastDigit=currentDigit;
        number /= 10;
    }
    return `${result}\n${sum}`;
}sameNumbers(2222222);
//sameNumbers(1234)