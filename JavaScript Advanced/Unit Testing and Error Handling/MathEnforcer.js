describe('Math Enforcer Test', () => {
    it('With wrong parameters', () => {
        expect(mathEnforcer.addFive('string')).to.undefined;
        expect(mathEnforcer.subtractTen('string')).to.undefined;
        expect(mathEnforcer.sum('string', 'string')).to.undefined;
        expect(mathEnforcer.sum('string', 1)).to.undefined;
        expect(mathEnforcer.sum(1, 'string')).to.undefined;
    });

    it('With correct parameters', () => {
        expect(mathEnforcer.addFive(5)).to.equal(10);
        expect(mathEnforcer.addFive(3.55)).to.equal(8.55);
        expect(mathEnforcer.addFive(-1)).to.equal(4);
        expect(mathEnforcer.addFive(0)).to.equal(5);
        expect(mathEnforcer.subtractTen(10)).to.equal(0);
        expect(mathEnforcer.subtractTen(0)).to.equal(-10);
        expect(mathEnforcer.subtractTen(11)).to.equal(1);
        expect(mathEnforcer.subtractTen(11.5)).to.equal(1.5);
        expect(mathEnforcer.sum(1, 2)).to.equal(3);
        expect(mathEnforcer.sum(-3, 2)).to.equal(-1);
        expect(mathEnforcer.sum(0, 2)).to.equal(2);
        expect(mathEnforcer.sum(-2, 2)).to.equal(0);
        expect(mathEnforcer.sum(1.5, 3.5)).to.equal(5);
    })
});