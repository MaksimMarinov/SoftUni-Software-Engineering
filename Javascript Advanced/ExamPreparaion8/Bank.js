class Bank {
    constructor(bankName) {
        this._bankName = bankName;
        this.allCustomers = [];
    }

    newCustomer(customer) {
        for (const customerElement of this.allCustomers) {
            if (customer.firstName === customerElement.firstName &&
                customer.lastName === customerElement.lastName &&
                customer.personalId === customerElement.personalId
            ) {
                throw new Error(`${customer.firstName} ${customer.lastName} is already our customer!`)
            }


        }
        this.allCustomers.push(customer);
        return customer;
    }

    depositMoney(personalId, amount) {

        const customer = this.checkById(personalId);
        if(customer.totalMoney){
            customer.totalMoney += amount;
        }else{
            customer['totalMoney']=amount;
        }


        if(customer.transactions === undefined){
            customer['transactions'] = [{id: 1,type1: 'deposit', amount: amount}]
        }else{

            let currentId = customer.transactions[customer.transactions.length-1].id +1;
            customer.transactions.push({id: currentId, type1: 'deposit', amount: amount});
        }
        return `${customer.totalMoney}$`

    }

    withdrawMoney(personalId, amount) {
        const customer = this.checkById(personalId);
        if (customer.totalMoney < amount) {
            throw new Error(`${customer.firstName} ${customer.lastName} does not have enough money to withdraw that amount!`)
        }
        if(customer.totalMoney){
            customer.totalMoney -= amount;
        }else{
            customer['totalMoney']=amount;
        }
        if(customer.transactions === undefined){
            customer['transactions'] = [{id: 1,type1: 'withdraw', amount: amount}]
        }else{
            let currentId = customer.transactions[customer.transactions.length-1].id+1;
            customer.transactions.push({id: currentId, type1: 'withdraw', amount: amount});
        }


        return `${customer.totalMoney}$`
    }

    checkById(id) {
        const customer = this.allCustomers.find(c => c.personalId === id);
        if (!customer) {
            throw new Error('We have no customer with this ID!');
        }
        return customer;
    }

    customerInfo(personalId) {
        const customer = this.checkById(personalId);
        let result = '';
        result += `Bank name: ${this._bankName}\nCustomer name: ${customer.firstName} ${customer.lastName}\n`;
        result += `Customer ID: ${customer.personalId}\nTotal Money: ${customer.totalMoney}$\nTransactions:\n`;
        for (let i = customer.transactions.length-1; i >=0 ; i--) {
            const currentTransaction = customer.transactions[i];
            if(currentTransaction.type1==='deposit'){
                result += `${currentTransaction.id}. ${customer.firstName} ${customer.lastName} made deposit of ${currentTransaction.amount}$!\n`
            }else{
                result += `${currentTransaction.id}. ${customer.firstName} ${customer.lastName} withdrew ${currentTransaction.amount}$!\n`
            }

        }
        return result.trim();
    }
}

let bank = new Bank('SoftUni Bank');

console.log(bank.newCustomer({firstName: 'Svetlin', lastName: "Nakov", personalId: 6233267}));
console.log(bank.newCustomer({firstName: "Mihaela", lastName: 'Mileva', personalId: 4151596}));

bank.depositMoney(6233267, 250);
console.log(bank.depositMoney(6233267, 250));
bank.depositMoney(4151596, 555);

console.log(bank.withdrawMoney(6233267, 125));

console.log(bank.customerInfo(6233267));
