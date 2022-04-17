function smallestTwoNumbers(input){

    return input.sort((a,b)=>a-b).splice(0,2).join(' ');

}
console.log(smallestTwoNumbers([3, 0, 10, 4, 7, 3]));