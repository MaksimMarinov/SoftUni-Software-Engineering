function solve(a){
   
   while(a.length>1){
    let condensed=[a.length-1];
    for (let index = 0; index < a.length-1; index++) {
        condensed[index]=a[index]+a[index+1];
     }
    a=condensed;
   }
   console.log(a[0])
}solve([2,10,3])