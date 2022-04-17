function circle(input){
    let type = typeof input;
    let result;
      type === 'number' ? result= (Math.PI*Math.pow(input,2)).toFixed(2)
          : result= `We can not calculate the circle area, because we receive a ${type}.`;

    return result;

}

console.log(circle(5))
console.log(circle('name'))