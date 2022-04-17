
function tickets(array, string){
    class Ticket{
    constructor(destination, price, status) {
        this.destination = destination;
        this.price = price;
        this.status = status
    }
    static compareTo(a,b){
        if(string==='destination'){
            return a.destination.localeCompare(b.destination);
        }else if(string==='price'){
            return a.price-b.price;
        }else{
            return a.status.localeCompare(b.status);
        }
    }

    }

    let result = [];

    for (const arrayElement of array) {
        const [destination, price, status] = arrayElement.split('|');
        result.push(new Ticket(destination, Number(price), status));
    }
   result = result.sort(Ticket.compareTo);
    return result;
}

console.log(tickets(['Philadelphia|94.20|available',
        'New York City|95.99|available',
        'New York City|95.99|sold',
        'Boston|126.20|departed'],
    'status'
));