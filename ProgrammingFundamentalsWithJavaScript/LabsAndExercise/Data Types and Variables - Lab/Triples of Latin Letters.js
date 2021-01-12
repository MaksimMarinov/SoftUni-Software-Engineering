function solve(a) {
    for (let i = 0; i < a; i++) {
        for (let j = 0; j < a; j++) {
            for (let k = 0; k < a; k++) {
            console.log(String.fromCharCode(97 + i)+String.fromCharCode(97 + j)+String.fromCharCode(97 + k))

            }
        }
    }
}solve(3)