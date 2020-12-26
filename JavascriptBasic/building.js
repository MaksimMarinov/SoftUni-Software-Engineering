function solve(a1) {
    let floor = parseInt(a1[0]);
    let rooms = parseInt(a1[1]);
    for (let i = floor; i > 0; i--) {
        let numbers = '';
        for (let l = 0; l < rooms; l++) {
            if (i == floor) {
                numbers += `L${i}${l} `;

            } else {


                if (i % 2 == 0) {
                    numbers += `O${i}${l} `;

                } else {
                    numbers += `A${i}${l} `;
                }
            }

        }
        console.log(`${numbers}`)
    }
} solve(["6", "4"])