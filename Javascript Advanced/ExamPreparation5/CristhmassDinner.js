class ChristmasDinner {

    constructor(budget) {


        this.budget = this.validateBudget(budget);
        this.dishes = [];
        this.products = [];
        this.guests = {};

    }

    validateBudget(budget) {
        if (budget < 0) {
            throw new Error("The budget cannot be a negative number");
        }
        return budget;
    }

    recipes(recipe) {

        for (const product of recipe.productsList) {
            if (!this.products.includes(product)) {
                throw new Error('We do not have this product');
            }
        }

        this.dishes.push(recipe);
        return `${recipe.recipeName} has been successfully cooked!`
    }

    shopping(product) {
        const productName = product[0];
        const price = Number(product[1]);
        if (price > this.budget) {
            throw new Error("Not enough money to buy this product");
        }
        this.products.push(productName);
        this.budget -= price;
        return `You have successfully bought ${productName}!`
    }

    inviteGuests(name, dish) {
        const meal = this.dishes.find(d=>d.recipeName===dish);
        if(meal===undefined){
            throw new Error("We do not have this dish")
        }
        if(this.guests.hasOwnProperty(name)){
            throw new Error("This guest has already been invited");
        }

        this.guests[name]=dish;
        return `You have successfully invited ${name}!`
    }

    showAttendance() {
        let output = '';
        for (const guest in this.guests) {
            const dishName = this.guests[guest];
            const currentDish = this.dishes.find(d=>d.recipeName=dishName);
            const products = currentDish.productsList.join(', ')
            output += `${guest} will eat ${dishName}, which consists of ${products}\n`
        }

        return output.trim();
    }

}

// let dinner = new ChristmasDinner(300);
//
// dinner.shopping(['Salt', 1]);
// dinner.shopping(['Beans', 3]);
// dinner.shopping(['Cabbage', 4]);
// dinner.shopping(['Rice', 2]);
// dinner.shopping(['Savory', 1]);
// dinner.shopping(['Peppers', 1]);
// dinner.shopping(['Fruits', 40]);
// dinner.shopping(['Honey', 10]);
//
// dinner.recipes({
//     recipeName: 'Oshav',
//     productsList: ['Fruits', 'Honey']
// });
// dinner.recipes({
//     recipeName: 'Folded cabbage leaves filled with rice',
//     productsList: ['Cabbage', 'Rice', 'Salt', 'Savory']
// });
// dinner.recipes({
//     recipeName: 'Peppers filled with beans',
//     productsList: ['Beans', 'Peppers', 'Salt']
// });
//
// console.log(dinner.inviteGuests('Ivan', 'Oshav'));;
// dinner.inviteGuests('Petar', 'Folded cabbage leaves filled with rice');
// dinner.inviteGuests('Georgi', 'Peppers filled with beans');
//
// console.log(dinner.showAttendance());
