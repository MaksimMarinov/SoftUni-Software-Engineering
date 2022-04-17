
import {html} from '../lib.js';
import { getUserData } from '../util.js';
import {getAllBooksByUser} from '../api/data.js'


const profileTemplate = (books)=> html`
<section id="my-books-page" class="my-books">
            <h1>My Books</h1>
            ${books.length == 0 ? html`<p class="no-books">No books in database!</p>`:
            html`<ul class="my-books-list">
            ${books.map(bookCard)}
            </ul>`
        }
            <!-- Display ul: with list-items for every user's books (if any) -->
            
                
        </section>`

        const bookCard = (book)=> html` <li class="otherBooks">
        <h3>${book.title}</h3>
        <p>Type: ${book.type}</p>
        <p class="img"><img src=${book.imageUrl}></p>
        <a class="button" href="/details/${book._id}">Details</a>
    </li>`

export async  function myBooks(ctx){

    const userData = getUserData();

const books = await getAllBooksByUser(userData.id);


ctx.render(profileTemplate(books ));

}