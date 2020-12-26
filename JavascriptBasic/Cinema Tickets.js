function solve(a) {
    let command = a[0];
    let index = 0;
    let total = 0;
    let student = 0;
    let standart = 0;
    let kid = 0;
    while (command !== "Finish") {
        let movie = command;
        index++;
        command = a[index];
        let freeSeats = Number(command);
        index++;
        command = a[index];
        let totalPerMovie = 0;
        while (command !== "End") {
            total++;
            totalPerMovie++;
            switch (command) {
                case "standard":
                    standart++;
                    break;
                case "student":
                    student++;
                    break;
                case "kid":
                    kid++;
                    break;


            }
            if (totalPerMovie == freeSeats) {

                break;
            }
            index++;
            command = a[index];


        }
        console.log(`${movie} - ${(totalPerMovie / freeSeats * 100).toFixed(2)}% full.`);
        index++;
        command = a[index];
    }
    console.log(`Total tickets: ${total}`);
    console.log(`${(student / total * 100).toFixed(2)}% student tickets.`);
    console.log(`${(standart / total * 100).toFixed(2)}% standard tickets.`);
    console.log(`${(kid / total * 100).toFixed(2)}% kids tickets.`);
} solve(["Taxi",
    "10",
    "standard",
    "kid",
    "student",
    "student",
    "standard",
    "standard",
    "End",
    "Scary Movie",
    "6",
    "student",
    "student",
    "student",
    "student",
    "student",
    "student",
    "Finish"])
