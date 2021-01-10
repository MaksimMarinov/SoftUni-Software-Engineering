function solve(arr) {
    let k = arr.shift();
    arr1 = arr.slice(0, k);
    arr2 = arr.slice(arr.length - k);
    let print = e => {
        let output = '';
        for (let i = 0; i < e.length; i++) {
            output += e[i] + ' ';
        }
        return output;
    }
    console.log(print(arr1));
    console.log(print(arr2));

} solve([2,
    7, 8, 9])
solve([3,
    6, 7, 8, 9]
)