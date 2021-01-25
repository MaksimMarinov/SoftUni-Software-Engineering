function solve(){
    let string = "this is an example";
    string = string.toLowerCase().split(' ')
    let result=[];
    result.push(string[0])
   
    for(let i=1; i<string.length; i++){{
        let currString = string[i];
     let stringToPush = currString.charAt(0).toUpperCase()+currString.substring(1);
     result.push(stringToPush)
    }}
    console.log(result);
}solve()