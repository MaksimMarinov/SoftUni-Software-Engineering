function biggestElement(input){
    let biggest = input[0][0];
    const reducer = (a,b) => Math.max(a,b);

    for (let i = 0; i < input.length; i++) {

       const current = input[i].reduce(reducer);
       if(current>biggest){
           biggest=current;
       }
    }
    return biggest;
}

console.log(biggestElement([[20, 50, 10],
    [8, 33, 145]]
));