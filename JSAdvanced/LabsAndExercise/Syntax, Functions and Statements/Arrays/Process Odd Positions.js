function returnOddPosition(array){
    let result = []
for(let i =1; i<array.length; i+=2){
result[result.length]=array[i]
}
return result.map(x=>x*2).reverse()
}console.log(returnOddPosition([3, 0, 10, 4, 7, 3]));
