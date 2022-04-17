const {isSymmetric}= require('../checkForSymmetry');
const {expect} = require("chai");

describe('isSymmetric(arr)', ()=> {
    it('should return true for [1,2,3,3,2,1]',  ()=>{
        expect(isSymmetric([1,2,3,3,2,1])).to.be.true;
    });
    it('should return false for [1,2,3]', ()=>{
        expect(isSymmetric([1,2,3])).to.be.false;
    });
    it('should return true for [-1,2,-1]',  ()=> {
        expect(isSymmetric([-1,2,-1])).to.be.true;
    });
    it('returns false for not array', ()=>{
        expect(isSymmetric(5)).to.be.false;
    });
    it('returns true for ["m", 1, 1,"m"]', ()=>{
        expect(isSymmetric(["m", 1, 1, "m"])).to.be.true;
    });
    it("should return false for 1,2,2,1",  ()=> {
        expect (isSymmetric(1,2,2,1)).to.be.false;
    });
    it('should return false for [1,2,"1"]', ()=>{
        expect (isSymmetric([1,2,"1"])).to.be.false;
    })

});