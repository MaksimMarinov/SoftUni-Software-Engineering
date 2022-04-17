function processOddPositions(array){

    return array.filter((v,i)=>i%2!==0).map(r=>r*2).reverse().join(' ');
}

console.log(processOddPositions([3, 0, 10, 4,7,3]));