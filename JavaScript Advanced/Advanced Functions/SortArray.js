function sortArray(array, str) {
    array.sort((a, b) => {
        if(str == 'asc') {
            return a - b;
        }else if(str == 'desc') {
            return b - a;
        }
    })

    return array;
}