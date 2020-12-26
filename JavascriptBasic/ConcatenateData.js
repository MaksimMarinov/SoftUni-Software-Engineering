function concatenate(a1, a2, a3, a4) {
    let firstName = a1;
    let secondName = a2;
    let age = Number(a3);
    let town = a4;
    console.log(`You are ${firstName} ${secondName}, a ${age}-years old person from ${town}.`)
} concatenate('Maria', 'Ivanova', 20, 'Sofia')