function checker(x1, y1, x2, y2){
    let out = `{${x1}, ${y1}} to {0, 0}`;
    if(isValid(x1,y1, 0, 0)){
        out+=" is valid\n";
    }else {
        out+=" is invalid\n"
    }
    out+= `{${x2}, ${y2}} to {0, 0}`;
    if(isValid(x2,y2, 0, 0)){
        out+=" is valid\n";
    }else {
        out+=" is invalid\n"
    }
    out+= `{${x1}, ${y1}} to {${x2}, ${y2}}`;
    if(isValid(x1,y1, x2, y2)){
        out+=" is valid";
    }else {
        out+=" is invalid"
    }
    return out;

    function isValid(x1,y1, x2, y2){
        return Number.isInteger( Math.sqrt(Math.pow(Math.abs((x2-x1)), 2)+Math.pow(Math.abs((y2-y1)),2)));
    }
}