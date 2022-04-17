function solve(n1, n2, s){
    let result = {
        '+': (a,b)=>a+b,
        '-': (a,b)=>a-b,
        '*': (a,b)=>a*b,
        '/': (a,b)=>a/b,
        '%': (a,b)=>a%b,
        '**': (a,b)=>a**b,

    }

    return result[s](n1,n2);
}

console.log(solve(5, 6, '+'))
console.log(solve(3, 5.5, '*'))