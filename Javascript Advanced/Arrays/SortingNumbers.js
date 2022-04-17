function sortingNumbers(array) {
    const result = [];
    const length = array.length;
    array.sort((a, b) => a - b);
    for (let i = 0; i < length; i++) {
        let input;
        if(i%2===0){
            input = array.shift();

        }else{
            input=array.pop();

        }
        result.push(input)
    }
    return result;
}

console.log(sortingNumbers([1, 65, 3, 52, 48, 63, 31, -3, 18, 56]));