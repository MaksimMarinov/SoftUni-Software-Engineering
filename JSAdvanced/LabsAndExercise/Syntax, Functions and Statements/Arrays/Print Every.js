function printNthElement(input, n) {
    let result = [];
    for (let i = 0; i < input.length; i += n) {
        result[result.length]=input[i];
    }return result;

}console.log(printNthElement(
['dsa',
'asd', 
'test', 
'tset'], 
2));

const solve=(input,n)=>input.filter((_,i)=>{
    return i%n==0;
});
console.log(solve(['5', 
'20', 
'31', 
'4', 
'20'], 
2
));