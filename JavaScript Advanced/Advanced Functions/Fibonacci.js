function getFibonator() {
    let n1=0;
    let n2=1;

    function getNum() {
        let nexNum = n1+n2;
        n1 = n2;
        n2 = nexNum;
        return n1;
    }

    return getNum;
}