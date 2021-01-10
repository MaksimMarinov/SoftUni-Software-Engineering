function solve(arr) {
    let newArray = [];

    arr.forEach(e => {
        if (e < 0) {
            newArray.unshift(e);
        } else (newArray.push(e));
    });

    newArray.forEach(e => console.log(e));
} solve([7, -2, 8, 9])
solve([3, -2, 0, -1])