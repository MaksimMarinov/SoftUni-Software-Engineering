function extract(array) {
    /*let result = [array[0]];
    for (let i = 1; i < array.length; i++) {
        if (array[i] >= result[i - 1]) {
            result.push(array[i]);
        }
    }
    return result;*/
    return array.reduce(function (result, currentValue, index, initialArray) {
        if (currentValue >= result[result.length - 1]||result.length===0) {
            result.push(currentValue);
        }
        return result;
    }, [])
   
    
    

} console.log(extract([1, 
    3, 
    8, 
    4, 
    10, 
    12, 
    3, 
    2, 
    24]
    

));