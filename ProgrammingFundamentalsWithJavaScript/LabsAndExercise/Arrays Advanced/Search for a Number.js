function solve(array, number){
let numberToAdd = number.shift();
let numberToRemove=number.shift();
let numberToCheck=number.shift();
let output=[];
output=array.slice(0, numberToAdd);
output.splice(0,numberToRemove);
let count=0;
output.forEach(e => {
    if(e==numberToCheck){
        count++;
    }
});
console.log(`Number ${numberToCheck} occurs ${count} times.`);
}solve([5, 2, 3, 4, 1, 6],
    [5, 2, 3]
    )