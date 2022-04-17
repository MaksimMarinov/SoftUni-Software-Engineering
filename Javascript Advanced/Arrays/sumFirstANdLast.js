function sumFirstLast(input){
    return Number(input.shift())+Number(input.pop());

}

console.log(sumFirstLast([5,10]));