const {expect, assert} = require('chai');
const {PaymentPackage} = require('../PaymentPackage');

describe("Test forPayment package", function () {
    let instance = null;
    beforeEach(() => {
        instance = new PaymentPackage('name', 100)
    })
    describe('Test for the name', () => {
        it('constructor', () => {

            assert.equal(instance.name, 'name');
            assert.equal(instance.value, 100);
            assert.equal(instance.VAT, 20);
            assert.equal(instance.active, true);
        });
        it('should throw error if the name is not string', () => {
            expect(() => new PaymentPackage(1, 2)).to.throw('Name must be a non-empty string')
        })
        it('should throw error if the name is empty string', () => {
            expect(() => new PaymentPackage('', 2)).to.throw('Name must be a non-empty string')
        })
        it('Should return the new Name if the input is good', () => {
            expect(() => new PaymentPackage('abc', 123)).not.to.throw('Name must be a non-empty string');
        });


    })
    describe('test for value', () => {
        it('should throw error if value is not number', () => {
            expect(() => instance.value = '').to.throw('Value must be a non-negative number');
        })
        it('should throw error if value is not number', () => {
            expect(() => instance.value = -1).to.throw('Value must be a non-negative number');
        })

        it('Should return the new Active if the input is good', () => {
            let flagClass = new PaymentPackage('abc', 123);
            expect(() => flagClass.active = true).not.to.throw('Active status must be a boolean');
        });
        it('Set value to null', () => {
            let instance = new PaymentPackage('Name', 100);
            assert.doesNotThrow(() => { instance.value = 0 })
        });
    });
    describe('test for VAT', () => {
        it('should throw error if VAT is not number', () => {
            expect(() => instance.VAT = '').to.throw("VAT must be a non-negative number");
        });
        it('should throw error if VAT is negative number', () => {
            expect(() => instance.VAT = -1).to.throw("VAT must be a non-negative number");
        });

    })

    describe('test for active', ()=>{
        it('should throw error if active is not boolean',()=>{
            expect(() => instance.active = -1).to.throw("Active status must be a boolean");
            expect(() => instance.active = '').to.throw("Active status must be a boolean");
            expect(() => instance.active = []).to.throw("Active status must be a boolean");
        })
    });
    describe('Tests for toString Method', () => {
        it('Should return a string as all the input is correct - 1', () => {
            let flagClass = new PaymentPackage('abc', 123);
            let output = [
                `Package: abc`,
                `- Value (excl. VAT): 123`,
                `- Value (VAT 20%): 147.6`
            ]
            expect(flagClass.toString()).to.equal(output.join('\n'));
        });
        it('Should return a string as all the input is correct - 2', () => {
            let output = [
                `Package: name (inactive)`,
                `- Value (excl. VAT): 100`,
                `- Value (VAT 20%): 120`
            ]
            instance.active=false;
            expect(instance.toString()).to.equal(output.join('\n'));
        });
    });
});
