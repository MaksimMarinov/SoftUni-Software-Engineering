function store(input){
    let catalogue = {};
    while(input.length>0){
        let [name, price] = input.shift().split(" : ");
        const category = name[0];
       if(!catalogue[category]){
           catalogue[category] = [];
       }catalogue[category].push({name, price: Number(price)})
       catalogue[category].sort((a,b)=>(a.name).localeCompare(b.name));
       
    }
    let result =[];
    Object.entries(catalogue).sort((a,b)=>a[0].localeCompare(b[0])).forEach(element => {
        let values = element[1].sort((a,b)=>(a.name).localeCompare(b.name))
            .map(product=>`  ${product.name}: ${product.price}`).join(`\n`);
        let string = `${element[0]}\n${values}`;
        result.push(string)

    });
return result.join('\n')
}console.log(store(['Appricot : 20.4',
'Fridge : 1500',
'TV : 1499',
'Deodorant : 10',
'Boiler : 300',
'Apple : 1.25',
'Anti-Bug Spray : 15',
'T-Shirt : 10']
)); 