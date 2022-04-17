const { createCalculator } = require('../addSubtract');
const {expect} = require('chai');
describe('add subtract', ()=>{

    let instance = null;
    beforeEach(()=>{
        instance =  createCalculator();
    });
    it('has all methods', ()=>{
        expect(instance).to.haveOwnProperty('add');
        expect(instance).to.haveOwnProperty('subtract');
        expect(instance).to.haveOwnProperty('get');
    });
    it('adds number', ()=>{
        instance.add(1);

        expect(instance.get()).to.equal(1);
    });
    it('adds multiple number', ()=>{
        instance.add(1);
        instance.add(2);

        expect(instance.get()).to.equal(3);
    });

    it('subtract number', ()=>{
        instance.subtract(1);

        expect(instance.get()).to.equal(-1);
    });

    it('subtract numbers', ()=>{
        instance.subtract(1);
        instance.subtract(2);

        expect(instance.get()).to.equal(-3);
    });

    it(' adds and subtract numbers', ()=>{
        instance.add(2);
        instance.add(2);
        instance.subtract(1);


        expect(instance.get()).to.equal(3);
    });


    it('works with numbers as strings', ()=>{
        instance.subtract("1");
        instance.add('2');

        expect(instance.get()).to.equal(1);
    });
    it('first value = 0', ()=>{;

        expect(instance.get()).to.equal(0);
    });



})