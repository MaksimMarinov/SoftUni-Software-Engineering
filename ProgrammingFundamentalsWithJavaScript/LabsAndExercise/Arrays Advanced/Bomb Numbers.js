function solve(arr, numbers){
    let number = Number(numbers[0]);
    let power=Number(numbers[1]);
    let index = arr.indexOf(number);
    while(index>-1){
        
        arr.splice(Math.max((index-power), 0),Math.min(power, index));
        index = arr.indexOf(number);
        arr.splice(index, power+1);
        index = arr.indexOf(number);
     
        
    }
    let sum = 0;
    arr.forEach(element => {
        sum+=element;
    });
    console.log(sum);

}solve([1, 2, 2, 4, 2, 2, 2, 9],
    [4, 2]
    

    )