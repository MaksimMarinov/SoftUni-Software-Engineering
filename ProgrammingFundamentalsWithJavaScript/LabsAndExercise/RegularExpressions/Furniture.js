function solve(input){
    
    let boughtFurnitures = [];
    let totalMoneySpend = 0;
   
    for (const data of input) {
        let match = new RegExp('>>(?<item>[A-Za-z]+)<<(?<price>[\\d]+[.\\d{1,2}]*)!(?<quantity>\\d+)','g').exec(data);
        if(match){
            boughtFurnitures.push(match.groups.item);
            totalMoneySpend+=Number(match.groups.price)*Number(match.groups.quantity)
        }
    }
    if(boughtFurnitures.length>0){
        console.log('Bought furniture:');
        console.log(boughtFurnitures.join('\n'));
        console.log('Total money spend: '+totalMoneySpend.toFixed(2));
    }else{
        console.log('Bought furniture:');
        console.log('Total money spend: '+totalMoneySpend.toFixed(2));
    }
    
   


}solve([ '>>Sofa<<312.23!3','>>TV<<300!5', '>Invalid<<!5', 'Purchase' ])