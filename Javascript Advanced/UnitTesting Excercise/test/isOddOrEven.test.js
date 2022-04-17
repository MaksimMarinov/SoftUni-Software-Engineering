const {expect} = require('chai');
const {isOddOrEven} = require('../isOddOrEven');

describe('isOddOrEven', () => {
    it('must be true for "test" even', () => {
        expect(isOddOrEven('test')).to.be.equal('even');
    });
    it('must be true for "max" odd', () => {
        expect(isOddOrEven('max')).to.be.equal('odd');
    });
    it('must be undefined 1', ()=>{
        expect(isOddOrEven(1)).to.be.undefined;
    });
    it('must be true for "max" odd', () => {
        expect(isOddOrEven('max')==='even').to.be.false
    });
})