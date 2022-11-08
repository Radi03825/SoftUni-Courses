function solve(array) {
    array.sort((a, b) => {
        let result = a.length - b.length;
        if(result == 0) {
            return a.localeCompare(b);
        }
        return result;
    } );

    console.log(array.join('\n'));
}