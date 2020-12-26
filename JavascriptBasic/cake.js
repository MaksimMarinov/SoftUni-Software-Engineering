function solve(a) {
    let cake = parseInt(a[0]) * parseInt(a[1]);
    let index = 2;
    let command = a[index];
    while (command != "STOP") {
        let pieces = parseInt(command);
        index++;
        command = a[index];

        cake -= pieces;
        if (cake < 0) {
            console.log(`No more cake left! You need ${Math.abs(cake)} pieces more.`);
            return;
        }
    }
    console.log(`${cake} pieces are left.`);
} solve(["10",
    "2",
    "2",
    "4",
    "6",
    "STOP"]);

