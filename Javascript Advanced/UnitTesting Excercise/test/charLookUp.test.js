const {expect} = require('chai');
const {lookupChar} = require('../charLookUp');

describe('char lookUp', ()=>{
    it('must be 1 for ("test", 1)', ()=>{
        expect(lookupChar('test', 1)).to.be.equal('e');
    });
    it('must be Incorrect index for ("test", -1)', ()=>{
        expect(lookupChar('test', -1)).to.be.equal('Incorrect index');
    });
    it('must be Incorrect index for ("test", 4)', ()=>{
        expect(lookupChar('test', 4)).to.be.equal('Incorrect index');
    });
    it('must be undefined for (100, 0)', ()=>{
        expect(lookupChar(100, 0)).to.be.undefined;
    });
    it('must be undefined for ("test", "t")', ()=>{
        expect(lookupChar("test", "t")).to.be.undefined;
    });
    it('Test for undefined index', ()=>{
        expect(lookupChar('str', 1.1)).to.be.undefined;
    });

})