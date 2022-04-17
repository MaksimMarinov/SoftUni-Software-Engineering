function createPerson(firstName, lastName) {
    const result = {
        firstName, lastName,
        fullName: ''
    };
    Object.defineProperty(result, 'fullName', {
        get() {
            return `${this.firstName} ${this.lastName}`
        },
        set(value) {
            const [fN, lN] = value.split(' ');
            if (fN === undefined && lN !== undefined) {
                this.firstName = fN;
                this.lastName = lN;
            }
        },
        configurable: true,
        enumerable: true
    });

    return result;
}

// let person = createPerson("Peter", "Ivanov");
// console.log(person.fullName); //Peter Ivanov
// person.firstName = "George";
// console.log(person.fullName); //George Ivanov
// person.lastName = "Peterson";
// console.log(person.fullName); //George Peterson
// person.fullName = "Nikola Tesla";
// console.log(person.firstName); //Nikola
// console.log(person.lastName);

// class Person {
//     constructor(firstName, lastName) {
//         this.firstName = firstName;
//         this.lastName = lastName;
//
//     }
//
//     get fullName() {
//         return `${this.firstName} ${this.lastName}`;
//     }
//
//     set fullName(value) {
//
//         const [fN, lN] = value.split(' ');
//         if (fN === undefined && lN !== undefined) {
//             this.firstName = fN;
//             this.lastName = lN;
//         }
//
//     }
//
// }


function Person(fn, ln){
    this.firstName = fn;
    this.lastName = ln;

    Object.defineProperty(this, 'fullName',{
        set: function(value){
            const [fN, lN] = value.split(' ');
            if (fN !== undefined && lN !== undefined) {
            this.firstName = fN;
            this.lastName = lN;
        }
        },
        get: function(){
            return `${this.firstName} ${this.lastName}`
        }
    })
}
let person = new Person("Albert", "Simpson");
console.log(person.fullName); //Albert Simpson
person.firstName = "Simon";
console.log(person.fullName); //Simon Simpson
person.fullName = "Peter";
console.log(person.firstName);  // Simon
console.log(person.lastName);
