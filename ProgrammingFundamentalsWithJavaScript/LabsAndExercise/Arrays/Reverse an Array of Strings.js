function solve(a) {
    let output = '';
   for (i = 0; i < a.length; i++) {
        //output += a[a.length - 1 - i] + ' ';
    }
    a.reverse().forEach(element => {
        output+=element + ' ';
    });

console.log(output);
  
} solve(['a', 'b', 'c', 'd', 'e']);