describe('Even or Odd Test', () => {
    it('With different parameter', () => {
        expect(isOddOrEven(1)).to.undefined;
    });

    it('With even string', () => {
        expect(isOddOrEven('even')).to.equal('even');
    });

    it('With odd string', () => {
        expect(isOddOrEven('odd')).to.equal('odd');
    });
});