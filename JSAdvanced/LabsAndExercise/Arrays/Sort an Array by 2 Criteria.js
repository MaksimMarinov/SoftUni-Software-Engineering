function sortByTwoCriteria(array){
    return array.sort((a,b)=>{
        if(a.length!=b.length){
            return a.length-b.length;
        }
            return a.localeCompare(b);
        
    }).forEach(word => console.log(word));
}sortByTwoCriteria(['test', 
'Deny', 
'omen', 
'Default']


)