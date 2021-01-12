function personInfo(firstName, lastName, age){
    let object = {
       firstName: firstName,
       lastName: lastName,
       age: age
    };
    for (const key in object) {
        console.log(`${key}: ${object[key]}`);
    }
}

personInfo("Peter", 
"Pan",
"20"
);