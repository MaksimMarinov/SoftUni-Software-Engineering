function solve(input){
    const result = [];
    for (const num of input) {
        if(num<0){
            result.unshift(num);
        }else{
            result.push(num);
        }
    }
    return result.join('\n');

}console.log(solve([7, -2, 8, 9]));
