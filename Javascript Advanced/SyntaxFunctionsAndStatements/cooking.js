function cooking(num, op1,  op2, op3, op4, op5){
    let arr = [op1, op2, op3, op4, op5];
    let out ='';
    let obj = {
        'chop': (number)=>number/2,
        'dice': (number)=>Math.sqrt(number),
        'spice': (number)=>number+1,
        'bake': (number)=>number*3,
        'fillet': (number)=>(number*0.8).toFixed(1),

    }
    num = Number(num);
    for(let i =0; i<5; i++){
        num = obj[arr[i]](num);
        out += `${num}\n`
    }
    return out;


}

console.log(cooking('9', 'dice', 'spice', 'chop', 'bake', 'fillet'));