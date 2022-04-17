function largestNumber(num1, num2, num3){
    let largeNum =  Math.max(num1, num2, num3);
    return  'The largest number is '+largeNum +  '.'
}

console.log(largestNumber(5, -3, 16));