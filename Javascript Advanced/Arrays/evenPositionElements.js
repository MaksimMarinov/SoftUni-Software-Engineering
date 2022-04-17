function echo(array){
    let result = '';
    for (let i = 0; i < array.length; i+=2) {
        result+=array[i]+' ';
    }
    return result.trim();
}

console.log(echo(['20', '30', '40', '50', '60']));