const {expect, assert} = require('chai');
const {mathEnforcer} = require('../mathEnforcer');

describe('mathEnforcer', ()=>{
    describe('addFive',  ()=> {
        it('instance,addFive is not number', ()=>{
            expect(mathEnforcer.addFive('e')).to.equal(undefined);
        });
        it('add five(1) to be 6',()=>{
            expect(mathEnforcer.addFive(1)).to.equal(6);
        });
        it('add five(1.1) to be 6.1',()=>{
            expect(mathEnforcer.addFive(1.1)).to.equal(6.1);
        });
        it('Number is negative', function () {
            expect(mathEnforcer.addFive(-10)).to.equal(-5);
        });
        it('Number is equal to 0', function () {
            expect(mathEnforcer.addFive(0)).to.equal(5);
        });
    });

    describe('subtractTen',  ()=> {
        it('mathEnforcer,subtractTen is not number', ()=>{
            expect(mathEnforcer.subtractTen('e')).to.equal(undefined);
        });
        it('subtract(1) to be 6',()=>{
            expect(mathEnforcer.subtractTen(1)).to.equal(-9);
        });
        it('subtract(1) to be 6',()=>{
            expect(mathEnforcer.subtractTen(1.1)).to.equal(-8.9);
        });
        it('subtract(11) to be 1',()=>{
            expect(mathEnforcer.subtractTen(11)).to.equal(1);
        });
        it('Number is decimal and bigger',  ()=> {
            expect(mathEnforcer.subtractTen(10.5)).to.equal(0.5);
        });
        it('Number is equal to 10',  () =>{
            expect(mathEnforcer.subtractTen(10)).to.equal(0);
        });
        it('Number is equal to 10', function () {
            expect(mathEnforcer.subtractTen(10)).to.equal(0);
        });
        it('Number is negative', function () {
            expect(mathEnforcer.subtractTen(-10)).to.equal(-20);
        });
    });

    describe('sum',  ()=> {

        it('mathEnforcer,sum is not number', ()=>{
            expect(mathEnforcer.sum('e',1)).to.equal(undefined);
            expect(mathEnforcer.sum(1,'1')).to.equal(undefined);
        });
        it('sum(1,2) to be 3',()=>{
            expect(mathEnforcer.sum(1,2)).to.equal(3);
        });
        it('sum(-1,2) to be 1',()=>{
            expect(mathEnforcer.sum(-1,2)).to.equal(1);
        });

        it('First decimal',  ()=> {
            expect(mathEnforcer.sum(1.1, 2)).to.equal(3.1);
        });
        it('Second decimal', ()=> {
            expect(mathEnforcer.sum(1, 2.1)).to.equal(3.1);
        });
        it('Two negative numbers', function () {
            expect(mathEnforcer.sum(-1, -2)).to.equal(-3);
        });
    });




})