function solve(input){
    let result = [];
    array = input.sort((a, b) => b - a);
    while(array.length !== 0){
        result.push(array[array.length-1]) && array.pop();
        result.push(array[0]) && array.shift();
    }
    return result;
}