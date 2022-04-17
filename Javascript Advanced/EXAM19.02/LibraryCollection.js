class LibraryCollection {
    constructor(capacity) {
        this.capacity = capacity;
        this.books = []

    }

    addBook(bookName, bookAuthor) {
        if (this.books.length >= this.capacity) {
            throw new Error("Not enough space in the collection.")
        }
        this.books.push({bookName, bookAuthor, payed: false});
        return `The ${bookName}, with an author ${bookAuthor}, collect.`
    }

    payBook(bookName) {
        const book = this.books.find(book => book.bookName === bookName);
        if (book === undefined) {
            throw new Error(`${bookName} is not in the collection.`)
        }
        if (book.payed === true) {
            throw new Error(`${bookName} has already been paid.`)
        }

        book.payed = true;
        return `${bookName} has been successfully paid.`
    }

    removeBook(bookName) {
        let index = -1;
        for (let i = 0; i < this.books.length; i++) {
            if (this.books[i].bookName === bookName) {
                index = i;
                break;
            }
        }
        if (index === -1) {
            throw new Error("The book, you're looking for, is not found.")
        }
        if (this.books[index].payed === false) {
            throw new Error(`${bookName} need to be paid before removing from the collection.`)
        }
        this.books.splice(index, 1);
        return `${bookName} remove from the collection.`
    }

    getStatistics(bookAuthor) {
        let result = '';
        if (bookAuthor === undefined) {
            result += `The book collection has ${this.capacity - this.books.length} empty spots left.\n`;
            this.books.sort((b1, b2) => b1.bookName.localeCompare(b2.bookName))
                .forEach(book => {
                    let hasPaid = '';
                    if (book.payed === true) {
                        hasPaid = 'Has Paid'
                    } else {
                        hasPaid = 'Not Paid'
                    }
                    result += `${book.bookName} == ${book.bookAuthor} - ${hasPaid}.\n`
                });
        } else {
            const resArray = this.books.filter(book => book.bookAuthor === bookAuthor);
            if (resArray.length === 0) {
                throw new Error(`${bookAuthor} is not in the collection.`)
            }
            resArray
                .forEach(book => {
                    let hasPaid = '';
                    if (book.payed === true) {
                        hasPaid = 'Has Paid'
                    } else {
                        hasPaid = 'Not Paid'
                    }
                    result += `${book.bookName} == ${book.bookAuthor} - ${hasPaid}.\n`
                });
        }

        return result.trim();


    }
}

const library = new LibraryCollection(5)
library.addBook('Don Quixote', 'Miguel de Cervantes');
library.payBook('Don Quixote');
library.addBook('In Search of Lost Time', 'Marcel Proust');
library.addBook('Ulysses', 'James Joyce');
console.log(library.getStatistics());




