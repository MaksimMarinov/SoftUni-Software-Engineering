const {flowerShop} = require('./flowerShop');
const {expect} = require('chai');

describe("Tests …", function() {
    describe(" test calcPriceOfFlowers", function() {
        it("should throw error for first param not str", function() {
           expect(()=>flowerShop.calcPriceOfFlowers(1,10,111)).to.throw("Invalid input!")
        });
    });
    it("should throw error for sec param not number", function() {
        expect(()=>flowerShop.calcPriceOfFlowers('tulip',"1.0",1)).to.throw("Invalid input!")
    });
    it("should throw error for third param not number", function() {
        expect(()=>flowerShop.calcPriceOfFlowers('tulip',10,"10")).to.throw("Invalid input!")
    });
    it('should be ok ',function (){
        expect(flowerShop.calcPriceOfFlowers('tulip', 5,10)).to.equal(`You need $50.00 to buy tulip!`)
    });
    describe('checkFlowersAvailable test', function (){

        it('should be The tulip are available!', function (){
            expect(flowerShop.checkFlowersAvailable('tulip', ["Rose", "Lily", "Orchid", 'tulip']))
                .to.equal(`The tulip are available!`)
        });it('should be `The ${flower} are sold! You need to purchase more!`',function (){
            expect(flowerShop.checkFlowersAvailable('tulip', ["Rose", "Lily", "Orchid"]))
            .to.equal('The tulip are sold! You need to purchase more!')
    });
    });
    describe('sellFlower', function (){
        it('should be Rose / Orchid', function (){
            expect(flowerShop.sellFlowers(["Rose", "Lily", "Orchid"],1))
                .to.deep.equal("Rose / Orchid" )
        })
        it('should throw error Invalid input! for first param not arr', function (){
            expect(()=>flowerShop.sellFlowers('error', 1)).to.throw("Invalid input!");
        });
        it('should throw error Invalid input! for first param not number', function (){
            expect(()=>flowerShop.sellFlowers(['tulip'], '1')).to.throw("Invalid input!");
        });  it('should throw Invalid input! for sec param not negative number', function (){
            expect(()=>flowerShop.sellFlowers(['tulip'], -1)).to.throw("Invalid input!");
        });
        it('should throw Invalid input! for incorrect index', function (){
            expect(()=>flowerShop.sellFlowers(['flo'], 1)).to.throw("Invalid input!");
        });


    })
});
