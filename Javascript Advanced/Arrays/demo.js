const array = [15, 16, 17, 18, 19];

// function reducer(previous, current) {
//     return Math.max(previous, current);
// }
const reducer = (a,b)=> Math.max(a,b)

const number = array.reduce(reducer);
console.log(number)