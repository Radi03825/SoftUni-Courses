function result(tickets, criterion) {
    class Ticket {
        constructor(destination, price, status) {
            this.destination = destination;
            this.price = price;
            this.status = status;
        }
    }

    let res = [];

    function sortFunc(a, b) {
        const sort = {
            'destination': 0,
            'price': 1,
            'status': 2
        }
        const s = sort[criterion];
        if (s == 1) {
            return Number(a[s]) > Number(b[s]);
        }else {
            return a[s].localeCompare(b[s]);
        }
    }

    tickets = tickets.map(t => t.split('|')).sort((a, b) => sortFunc(a, b));
    for (let [t, p, s] of tickets) {
        res.push(new Ticket(t, Number(p), s));
    }
    return res;
}