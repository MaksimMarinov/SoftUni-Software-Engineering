function solve(input){
    const productsInfo = {};
    for (const townInfo of input) {
        let [town, product, price] = townInfo.split(' | ');
        if(!productsInfo[product]){
            productsInfo[product]={
                town, price:Number(price)
            }
        }else{
            productsInfo[product]=productsInfo[product].price<=Number(price)?productsInfo[product]:{town, price:Number(price)};
        }
    }

    const result = [];
    for (const product in productsInfo) {
        result.push(`${product} -> ${productsInfo[product].price} (${productsInfo[product].town})`)
    }
    return result.join('\n');
}

console.log(solve(['Sample Town | Sample Product | 1000',
    'Sample Town | Orange | 2',
    'Sample Town | Peach | 1',
    'Sofia | Orange | 3',
    'Sofia | Peach | 2',
    'New York | Sample Product | 1000.1',
    'New York | Burger | 10']
));