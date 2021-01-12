function solve(input){
    let inputAsString = JSON.parse(input);
    
    let object = Object.entries(inputAsString);


    
    for (let [key, value] of object) {
        console.log(`${key}: ${value}`);
    }
}solve('{"name": "George", "age": 40, "town": "Sofia"}')