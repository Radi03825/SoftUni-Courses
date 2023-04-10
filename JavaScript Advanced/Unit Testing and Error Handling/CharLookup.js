describe('Char Lookup Test', () => {
    it('With different types of parameters', () => {
        expect(lookupChar(1, 1)).to.undefined;
        expect(lookupChar('string', 'string')).to.undefined;
        expect(lookupChar(1, 'string')).to.undefined;
    });

    it('With wrong index', () => {
        expect(lookupChar('string', -1)).to.equal('Incorrect index');
        expect(lookupChar('string', 6)).to.equal('Incorrect index');
        expect(lookupChar('string', 7)).to.equal('Incorrect index');
    });

    it('With valid input', () => {
        expect(lookupChar('string', 0)).to.equal('s');
    });
});