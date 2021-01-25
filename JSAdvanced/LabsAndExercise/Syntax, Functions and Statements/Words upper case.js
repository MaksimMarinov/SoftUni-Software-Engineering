function solve2(input) {
    let matches = input.toUpperCase().match(/\w+/g).join(', ');
    console.log(matches);
} solve2('?Hi, !how are you!')