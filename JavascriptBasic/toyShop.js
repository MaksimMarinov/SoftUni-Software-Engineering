function shop(a1, a2,a3,a4,a5,a6){
    let exc = Number(a1);
    let puzzels = Number(a2);
    let dolls = Number(a3);
    let bears = Number(a4);
    let minnons = Number(a5);
    let trucks = Number(a6);
    let sum = puzzels*2.6+dolls*3+bears*4.1+minnons*8.2+trucks*2;
    if((puzzels+dolls+bears+minnons+trucks)>=50){
        sum=sum*0.75;
    }
    sum=(sum*0.9);
    let diff = (Math.abs(sum-exc)).toFixed(2);
    if(sum>=exc){
        console.log(`Yes! ${diff} lv left.`)
    }else{
        console.log(`Not enough money! ${diff} lv needed.`)
    }
}shop("320", "8", "2", "5", "5", "1");