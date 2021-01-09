function solve(a){
    let countMax = 1;
    let curCount =1;
    let winSymbol='';
    let currentSymbol = a[0];
    for(let i = 1; i<a.length; i++){
        if(currentSymbol==a[i]){
            curCount++;
        }else{
            currentSymbol=a[i];
            curCount=1;
        }
        if(curCount>countMax){
            countMax=curCount;
            winSymbol=currentSymbol;
        }

    }
    let output='';
    for(let i=0; i<countMax; i++){
        output+=winSymbol+' ';
    }
    console.log(output);
}solve([1, 1, 1, 2, 3, 1, 3, 3])