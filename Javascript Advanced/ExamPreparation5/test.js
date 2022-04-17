const {expect} = require('chai');
const {dealership} = require('./dealership');

describe("Tests …", function() {
    describe("newCarCost", function() {

        it("The car is not in the list so it should be return the price", ()=>{
            expect(dealership.newCarCost('error', 200)).to.equal(200);
        });
        it("The car is Audi A4 B8 so the discount is 15000", ()=>{
            expect(dealership.newCarCost('Audi A4 B8', 20000)).to.equal(5000);
        });
        it("The car is Audi A6 4K so the discount is 20000", ()=>{
            expect(dealership.newCarCost('Audi A6 4K', 35000)).to.equal(15000);
        });
        it("The car is Audi A8 D5 so the discount is 15000", ()=>{
            expect(dealership.newCarCost('Audi A8 D5', 25000)).to.equal(0);
        });
        it("The car is Audi Audi TT 8J so the discount is 14000", ()=>{
            expect(dealership.newCarCost('Audi TT 8J', 25000)).to.equal(11000);
        });
    });
    describe("newCarCost", ()=> {
        it('should return heated seats for ([‘heated seats’, ‘sliding roof’, ‘sport rims’, ‘navigation’, etc.], [0])', ()=>{
            expect(dealership.carEquipment(['heated seats', 'sliding roof', 'sport rims', 'navigation'],[0]))
                .to.deep.equal(['heated seats']);
        });
        it('should return heated seats for ([‘heated seats’, ‘sliding roof’, ‘sport rims’, ‘navigation’, etc.], [0])', ()=>{
            expect(dealership.carEquipment(['heated seats', 'sliding roof', 'sport rims', 'navigation'],[0,2]))
                .to.deep.equal(['heated seats', 'sport rims']);
        });
    });

    describe('Test euro category', ()=>{
        it('should return Your euro category is low, so there is no discount from the final price! for 0',()=>{
            expect(dealership.euroCategory(0)).to.equal('Your euro category is low, so there is no discount from the final price!');
        });
        it('should return Your euro category is low, so there is no discount from the final price! for 3',()=>{
            expect(dealership.euroCategory(3)).to.equal('Your euro category is low, so there is no discount from the final price!');
        });

        it('should return Your euro category is low, so there is no discount from the final price! for 3',()=>{
            expect(dealership.euroCategory(4)).to.equal('We have added 5% discount to the final price: 14250.');
        });
    });

});
