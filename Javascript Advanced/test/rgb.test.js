const {rgbToHexColor} = require('../rgb-to-hex');
const {expect} = require('chai');

describe('RGB converter', () => {
    it('convert white', () => {
        expect(rgbToHexColor(255, 255, 255)).to.be.equal('#FFFFFF')
    });
    it('convert black', () => {
        expect(rgbToHexColor(0, 0, 0)).to.be.equal('#000000')
    });
    it('convert dark blue', () => {
        expect(rgbToHexColor(35, 68, 101)).to.be.equal('#234465')
    });
    it('returns undefined for missing parameters', () => {
        expect(rgbToHexColor()).to.be.undefined;
    });
    it('returns undefined for values out of range', () => {
        expect(rgbToHexColor(-1, -1,-1)).to.be.undefined;
        expect(rgbToHexColor(0, 0,-1)).to.be.undefined;
        expect(rgbToHexColor(0, -1,0)).to.be.undefined;
        expect(rgbToHexColor(-1, 0,0)).to.be.undefined;
    });
    it('returns undefined for values out of range', () => {
        expect(rgbToHexColor(256, 256,256)).to.be.undefined;
        expect(rgbToHexColor(0, 0,256)).to.be.undefined;
        expect(rgbToHexColor(0, 256,0)).to.be.undefined;
        expect(rgbToHexColor(0, 0,256)).to.be.undefined;
    });
    it('returns undefined for invalid type', () => {
        expect(rgbToHexColor('m', '256','256')).to.be.undefined;
        expect(rgbToHexColor(0, 0,'256')).to.be.undefined;
        expect(rgbToHexColor(0, '256',0)).to.be.undefined;
        expect(rgbToHexColor('m', 0,0)).to.be.undefined;
    });

});