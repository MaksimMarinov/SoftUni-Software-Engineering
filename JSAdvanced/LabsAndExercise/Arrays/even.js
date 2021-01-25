function even(array){
    let result = []
    for(let i =0; i<array.length; i+=2 ){
       result[result.length]=array[i]
    }
    return result.join(" ");
}console.log(even(['20', '30', '40', '50', '60']));