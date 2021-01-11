function solve(a) {
    let index = 0;
    let userName = a[index];

    let password = userName.split("").reverse().join("");

    for (let i = 1; i < 5; i++) {
        index++;
        let check = a[index];
        if (check === password) {
            console.log(`User ${userName} logged in.`);
            break;
        } else {
            if (i == 4) {
                console.log(`User ${userName} blocked!`)
                break;
            }
            console.log("Incorrect password. Try again.");

        }

    }

} solve(['sunny', 'rainy', 'cloudy', 'sunny', 'not sunny'])