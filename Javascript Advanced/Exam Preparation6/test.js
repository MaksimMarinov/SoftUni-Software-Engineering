const {expect, assert} = require('chai');
const {numberOperations} = require ('./03. Number Operations_Resources');

describe("Tests …", ()=> {
    describe("Power Number", ()=>{
        it("expect 4 if numbers are 2", ()=> {
            expect(numberOperations.powNumber(2)).to.equal(4)
        });
        it("Test negative numbers expect 4 if numbers are -2", ()=> {
            expect(numberOperations.powNumber(-2)).to.equal(4)
        });

        it("Test one number is 0 expect 0", ()=> {
            expect(numberOperations.powNumber(0)).to.equal(0);
        });
    });
  describe('number Checker', ()=>{
      it('throw an error for input String', ()=>{
          expect(()=>numberOperations.numberChecker('error')).to.throw('The input is not a number!');
      });
      it('should be The number is lower than 100! for 99', ()=>{
          expect(numberOperations.numberChecker(99)).to.equal('The number is lower than 100!');
      });
      it('should be The number is lower than 100! for 0', ()=>{
          expect(numberOperations.numberChecker(0)).to.equal('The number is lower than 100!');
      });
      it('Should be The number is greater or equal to 100! for 100', ()=>{
          expect(numberOperations.numberChecker(100)).to.equal('The number is greater or equal to 100!');
      });
      describe('sum Arrays', ()=>{
          it('should be of for array with equal numbers', ()=>{
              // expect(numberOperations.sumArrays([1,2,3],[1,2,3])).to.be.equal([ 2,4,6 ]);
              assert.deepEqual(numberOperations.sumArrays([1,2,3],[1,2,3]), [ 2,4,6 ]);
          })
          it('should be of for array with not equal numbers', ()=>{
              // expect(numberOperations.sumArrays([1,2,3],[1,2,3])).to.be.equal([ 2,4,6 ]);
              assert.deepEqual(numberOperations.sumArrays([1,2,3],[1,2]), [ 2,4, 3]);
              assert.deepEqual(numberOperations.sumArrays([1,2,],[1,2,3]), [ 2,4, 3]);

          });

      });

  })
});
