function solve(input){
    return input.reduce( (result, currentValue)=>{
        if(currentValue>=result[result.length-1]||result.length===0){
            result.push(currentValue);
        }
        return result;
    },[])


}

console.log(solve([20,
    3,
    2,
    15,
    6,
    1]

));