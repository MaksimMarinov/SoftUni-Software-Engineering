function solve(input) {
    class Cat {
        constructor(name, age) {
            this.name = name;
            this.age = age;
        }
        meow() {
            console.log(`${this.name}, age ${this.age} says Meow`);
        }
    }

    input.map(e => {
        let [name, age] = e.split(' ');
        let cat = new Cat(name, Number(age));
        return cat;
    }).forEach(e => e.meow());

}
solve(['Mellow 2', 'Tom 5'])