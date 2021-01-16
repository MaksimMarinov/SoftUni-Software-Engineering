function solve(array){
let sum =0;
let inverse=0;
let string='';
for(let i = 0; i<array.length; i++){
    sum += array[i];
    string+=array[i];
    inverse+=(1/array[i]);
}
console.log(sum+'\n'+inverse+'\n'+string);

}solve([1, 2, 3])