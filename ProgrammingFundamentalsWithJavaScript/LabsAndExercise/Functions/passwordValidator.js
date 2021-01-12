function solve(a){
    let isValid=true;
    if(a.length<6||a.length>10){
        console.log('Password must be between 6 and 10 characters');
        isValid==false;
        
    }
    let countDigits=0;
    for(let i = 0; i<a.length; i++){
        let currentASCIIndex= a[i].codePointAt();
        if((currentASCIIndex<65||currentASCIIndex>90)&&
            (currentASCIIndex<48||currentASCIIndex>57)&&
            (currentASCIIndex<97||currentASCIIndex>122)){
                console.log('Password must consist only of letters and digits');
                isValid=false;
                break;
        }else if(currentASCIIndex >= 48 && currentASCIIndex <= 57){
            countDigits++;
        }
              
    }
    if(countDigits<2){
        isValid=false;
        console.log('Password must have at least 2 digits');
    return;
    }
    if(isValid){
        console.log('Password is valid');
    }
}solve('Pa$s$s')