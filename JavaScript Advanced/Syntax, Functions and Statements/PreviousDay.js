function findYesterdayDate(year, month, day) {
    let today = new Date(year, month - 1, day);
    let yesterday = new Date(today);
    yesterday.setDate(yesterday.getDate() - 1);

    year = yesterday.getFullYear();
    month = yesterday.getMonth() + 1;
    day = yesterday.getDate();

    return `${year}-${month}-${day}`;
}

findYesterdayDate(2018, 5, 17);