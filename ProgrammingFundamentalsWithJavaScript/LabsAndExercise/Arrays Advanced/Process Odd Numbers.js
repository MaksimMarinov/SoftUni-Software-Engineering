function sumNumsAtOddsPositions(array){
    let forPrint =[];
    for(let i =0; i<array.length; i++){
        if(i%2==1){
            forPrint.push(array[i]);
        }
    }
    forPrint = forPrint.map(e=>e*2).reverse();
    console.log(forPrint.join(' '));
    

}sumNumsAtOddsPositions([3, 0, 10, 4, 7, 3])