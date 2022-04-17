function juice(input) {
    let result = "";
    let juiceQuantityInfo = {};
    let juiceBottlesInfo = {};
    input.forEach(i => {
        let juiceInfoInput = i.split(' => ');
        let juiceName = juiceInfoInput[0];
        let juiceQuantity = Number(juiceInfoInput[1]);

        juiceQuantityInfo.hasOwnProperty(juiceName) ? juiceQuantityInfo[juiceName]
            += juiceQuantity : juiceQuantityInfo[juiceName] = juiceQuantity;


        if (juiceQuantityInfo[juiceName] >= 1000) {
            let currentJuiceBottles = 0;
            while (juiceQuantityInfo[juiceName] >= 1000) {
                juiceQuantityInfo[juiceName] -= 1000;
                currentJuiceBottles += 1;
            }
            juiceBottlesInfo[juiceName] > 0 ? juiceBottlesInfo[juiceName]
                += currentJuiceBottles : juiceBottlesInfo[juiceName] = currentJuiceBottles;
        }

    })

    Object.entries(juiceBottlesInfo).forEach(juice => {

        let name = juice[0];
        let currentJuiceBottles = juice[1];

        result += `${name} => ${currentJuiceBottles}\n`;

    })

    return result.trim();
}

console.log(juice(['Orange => 2000',
    'Peach => 1432',
    'Banana => 450',
    'Peach => 600',
    'Strawberry => 549']
))

console.log(juice(['Kiwi => 234',
    'Pear => 2345',
    'Watermelon => 3456',
    'Kiwi => 4567',
    'Pear => 5678',
    'Watermelon => 6789']
))