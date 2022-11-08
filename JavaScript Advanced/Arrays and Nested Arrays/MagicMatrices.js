function solve(matrix) {
    let sum = 0;
    Boolean ;isEqual = true;
    for (let row = 0; row < matrix.length; row++) {
        let innerSum = 0;
        for (let col = 0; col < matrix[row].length; col++) {
            const element = matrix[row][col];
            innerSum += element;
        }
        if(row == 0) {
            sum = innerSum;
        }else if(sum != innerSum) {
            isEqual = false;
        }
    }

    for (let col = 0; col < matrix.length; col++) {
        let innerSum = 0;
        for (let row = 0; row < matrix.length; row++) {
            const element = matrix[row][col];
            innerSum += element;
        }
        if(col == 0) {
            sum = innerSum;
        }else if(sum != innerSum) {
            isEqual = false;
        }
    }

    console.log(isEqual)
}