function checkForSameNumbers(number) {
    let firstElement;
    Boolean ;isSame = true;
    let sum = 0;
    let numberToString = number.toString();
    for (let index = 0; index < numberToString.length; index++) {
        const element = numberToString[index];
        if(index == 0) {
            firstElement = element;
        }else {
            if(element != firstElement) {
                isSame = false;
            }
        }
        sum += Number(element);
    }

    console.log(isSame);
    console.log(sum);
}

checkForSameNumbers(4321);