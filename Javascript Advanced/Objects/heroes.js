function solve() {
    function cast(name){
        this.mana--;
        console.log(`${this.name} cast ${name}`)
    }
    function fight(){
        console.log(`${this.name} slashes at the foe!`);
        this.stamina--;
    }
    return {
        mage: (name) => {
            return {
                'name': name,
                health: 100,
                mana: 100,
                cast
            }
        },
        fighter: (name) => {
            return {
                'name': name,
                health: 100,
                stamina: 100,
                fight
            }
        }
    }
}


let create = solve();
const scorcher = create.mage("Scorcher");
scorcher.cast("fireball")
scorcher.cast("thunder")
scorcher.cast("light")

const scorcher2 = create.fighter("Scorcher 2");
scorcher2.fight()

console.log(scorcher2.stamina);
console.log(scorcher.mana);
