function solve(input) {

    const bottlesInfo = new Map();
    const juiceInfo = new Map();
    for (const element of input) {
        let currentQuantity = 0;
        let [name, quantity] = element.split(' => ');
        quantity = Number(quantity);
        if (juiceInfo.get(name)) {
            currentQuantity = quantity + Number(juiceInfo.get(name));

            juiceInfo.set(name, currentQuantity);
        } else {
            juiceInfo.set(name, quantity);
        }
        currentQuantity = Number(juiceInfo.get(name));
        if ( currentQuantity> 1000) {
            let bottles = (currentQuantity-(currentQuantity%1000))/1000;
            currentQuantity -= bottles * 1000;
            if(bottlesInfo.get(name)){
                let currentBottles = Number(bottlesInfo.get(name));
                bottles += currentBottles;

            }
            bottlesInfo.set(name,bottles);
            juiceInfo.set(name, currentQuantity);

        }

    }
    let result = '';

    for (const bottle of bottlesInfo) {
        result += `${bottle[0]} => ${bottle[1]}\n`
    }
    return result.trim();


}

console.log(solve(['Kiwi => 234','Kiwi => 4567',
    ]
));