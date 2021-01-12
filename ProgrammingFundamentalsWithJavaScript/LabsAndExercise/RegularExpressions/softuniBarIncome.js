function solve(input) {
    let totalIncome = 0;


    for (const data of input) {
        if (data == 'end of shift') {
            break;
        }
        let match = /%(?<name>[A-Z][a-z]+)%[^|$%.]*<(?<product>[\w]+)>[^|$%.]*\|(?<count>[0-9]+)\|[^|$%.]*?(?<price>[0-9]+\.?[\d]*)\$/g.exec(data);
        if (match) {
            let name = match.groups.name;
            let product = match.groups.product;
            let count = Number(match.groups.count);
            let price = Number(match.groups.price);
            totalIncome += (count * price);
            console.log(`${name}: ${product} - ${(count * price).toFixed(2)}`)

        }

    }

    console.log('Total income: ' + totalIncome.toFixed(2));
} solve([

    '%InvalidName%<Croissant>|2|10.3$',
    '%Peter%<Gum>1.3$',
    '%Maria%<Cola>|1|2.4',
    '%Valid%<Valid>valid|10|valid20$',
    'end of shift'

]
)
solve([
    '%George%<Croissant>|2|10.3$',
    '%Peter%<Gum>|1|1.3$',
    '%Maria%<Cola>|1|2.4$',
    'end of shift'
]
)
