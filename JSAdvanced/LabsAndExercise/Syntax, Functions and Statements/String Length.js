function solve(string1, string2, string3){
    const avarageLength = (string1.length+string2.length+string3.length)/3;
    const totalLength = string1.length+string2.length+string3.length;
    console.log(totalLength);
    console.log(avarageLength.toFixed(0));
}solve('chocolate', 'ice cream', 'cake')