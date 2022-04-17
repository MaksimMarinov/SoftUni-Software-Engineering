function biggerHalf(array){
    return array.sort((a,b)=>a-b).splice(array.length/2)
}

console.log(biggerHalf([3, 19, 14, 7, 2, 19, 6]));