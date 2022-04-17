let { Repository } = require("./solution.js");
const {expect} = require('chai');

describe("Tests …", function () {
    let properties = {
        name: "string",
        age: "number",
        birthday: "object"
    };
    let instance= null;
    let entity = {
        name: "Pesho",
        age: 22,
        birthday: new Date(1998, 0, 7)
    };

    beforeEach(()=>{


        instance = new Repository(properties);
        instance.add(entity);
    })
    describe("test constructor", function () {
        it("it should be add props", function () {


            expect(instance).to.have.property('props');
            expect(instance.props)
                .deep.equal(properties)

        });
    });
    describe('test add', ()=>{
        it('should be 0', ()=>{
            // expect(instance.add(entity)).to.equal(0);
            expect(instance.add({ name: "P",
                age: 22,
                birthday: new Date(1998, 0, 7)})).to.equal(1);

        });
        it('should be throw if name is not exist', ()=>{
           expect(()=>instance.add({age: 22,
               birthday: new Date(1998, 0, 7)})).to.throw(`Property name is missing from the entity!`)
        })
        it('should be throw if age is not exist', ()=>{
            expect(()=>instance.add({name: "P",
                birthday: new Date(1998, 0, 7)})).to.throw(`Property age is missing from the entity!`)
        })
        it('should be throw if birthday is not exist', ()=>{
            expect(()=>instance.add({name: "P",
                age:11})).to.throw(`Property birthday is missing from the entity!`)
        });
        it('should be throw if name is not correctType', ()=>{
            expect(()=>instance.add({name: 1, age: 22,
                birthday: new Date(1998, 0, 7)})).to.throw(`Property name is not of correct type!`)
        })
        it('should be throw if age is not correctType', ()=>{
            expect(()=>instance.add({name: '1', age:" 22",
                birthday: new Date(1998, 0, 7)})).to.throw(`Property age is not of correct type!`)
        });
        it('should be throw if birthday is not correctType', ()=>{
            expect(()=>instance.add({name: '1', age: 22,
                birthday: '2'})).to.throw(`Property birthday is not of correct type!`)
        });


    })
    describe('test getId', ()=>{
        it('should be throw', ()=>{
            instance = new Repository(properties);
            expect(()=>instance.getId(1)).to.throw('Entity with id: 1 does not exist!');

        })

        it('should be ok', ()=>{

            expect(instance.getId(0)).to.deep.equal({
                name: "Pesho",
                age: 22,
                birthday: new Date(1998, 0, 7)
            });

        })


    })

    describe('update', ()=>{
        it('should be throw', ()=>{
            expect(()=>instance.update(1,{})).to.throw('Entity with id: 1 does not exist!');

        })

        it('should be ok', ()=>{
            const update = { name: "New",
                age: 22,
                birthday: new Date(1998, 0, 7)};
            instance.update(0, update);
            expect(instance.getId(0)).to.deep.equal({
                name: "New",
                age: 22,
                birthday: new Date(1998, 0, 7)
            });
            it('should be throw if name is not exist', ()=>{
                expect(()=>instance.update({age: 22,
                    birthday: new Date(1998, 0, 7)})).to.throw(`Property name is missing from the entity!`)
            })
            it('should be throw if age is not exist', ()=>{
                expect(()=>instance.update({name: "P",
                    birthday: new Date(1998, 0, 7)})).to.throw(`Property age is missing from the entity!`)
            })
            it('should be throw if birthday is not exist', ()=>{
                expect(()=>instance.update({name: "P",
                    age:11})).to.throw(`Property birthday is missing from the entity!`)
            });
            it('should be throw if name is not correctType', ()=>{
                expect(()=>instance.update({name: 1, age: 22,
                    birthday: new Date(1998, 0, 7)})).to.throw(`Property name is not of correct type!`)
            })
            it('should be throw if age is not correctType', ()=>{
                expect(()=>instance.update({name: '1', age:" 22",
                    birthday: new Date(1998, 0, 7)})).to.throw(`Property age is not of correct type!`)
            });
            it('should be throw if birthday is not correctType', ()=>{
                expect(()=>instance.update({name: '1', age: 22,
                    birthday: '2'})).to.throw(`Property birthday is not of correct type!`)
            });
            it(`typeof input[name] !== string -> throw TypeError`, () => {
                instance.add({ name: '', age: 0, birthday: {}, })
                expect(() => instance.update(
                    0,
                    { name: 0, age: 1, birthday: { date: 0 } }
                )).to.throw(TypeError)
            })

        })


    });
    describe('test del', ()=>{
        it('should be throw', ()=>{
            expect(()=>instance.del(1)).to.throw('Entity with id: 1 does not exist!');

        })
        it(`deletes index properly`, () => {
            instance.add({ name: '', age: 1, birthday: {} })
            instance.add({ name: '', age: 1, birthday: {} })
            instance.del(1)
            expect(instance.data.has(1)).to.eq(false)
        })

        it('should be ok', ()=>{
          instance.del(0);
            expect(()=>instance.getId(0)).to.throw('Entity with id: 0 does not exist!');

        })
        it(`deletes index properly`, () => {
            instance.add({ name: '', age: 1, birthday: {} })
            instance.add({ name: '', age: 1, birthday: {} })
            instance.del(1)
            expect(instance.data.has(1)).to.eq(false)
        })
    })

    describe('testing count prop', () => {
        it(`instance.count -> 1`, () => {
            expect(instance.count).to.eq(1)
        });



    })

});
