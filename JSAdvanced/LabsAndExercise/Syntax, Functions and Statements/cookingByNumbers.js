function solve(num, s1, s2, s3, s4,s5){
    num = parseInt(num);
    let array=[s1, s2, s3, s4,s5]
    for(let i = 0; i<5; i++){
        let command = array[i];
        switch(command){
            case'chop':
            num/=2;
            
            break;
            case'dice':
            num=Math.sqrt(num);
            break;
            case'spice':
            num+=1;
            break;
            case'bake':
            num*=3;
            break;
            case'fillet':
            num-=(0.2*num);
            break;
        }
        console.log(num);
    }
    
}solve('9', 'dice', 'spice', 'chop', 'bake', 'fillet')