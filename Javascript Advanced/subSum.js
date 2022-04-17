function subSum(array, startIndex, endIndex){
    if(endIndex>array.length-1){
        endIndex=array.length-1;
    }
    if(startIndex<0){
        startIndex=0;
    }
    if(Array.isArray(array)===false){
        return NaN;
    }

    return array.slice(startIndex, endIndex+1)
        .map(Number)
        .reduce((acc,x)=>acc+x,0);
}

console.log(subSum([10, 20, 30, 40, 50, 60], 3, 300))
console.log(subSum([1.1, 2.2, 3.3, 4.4, 5.5], -3, 1))
console.log(subSum([10, 'twenty', 30, 40], 0, 2))
console.log(subSum([], 1, 2))
console.log(subSum('text', 0, 2))