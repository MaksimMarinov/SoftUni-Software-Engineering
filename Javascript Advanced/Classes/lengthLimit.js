class Stringer{

    constructor(string, lenght) {
        this.innerString = string;
        this.innerLength=lenght;
    }
    decrease(length){
        if(length>this.innerLength){
            this.innerLength=0;
        }else{
            this.innerLength-=length;
        }


    };
    increase(length){
        this.innerLength+=length;
    }
    toString(){
        if(this.innerLength<=0){
            return `...`
        }else if(this.innerLength>=this.innerString.length){
                return this.innerString;

        }else{
            let index = this.innerLength-this.innerString.length;
            return this.innerString.slice(0, index) + '...'
        }

    }


}
let test = new Stringer("Test", 5);
console.log(test.toString()); // Test

test.decrease(3);
console.log(test.toString()); // Te...

test.decrease(5);
console.log(test.toString()); // ...

test.increase(4);
console.log(test.toString());
