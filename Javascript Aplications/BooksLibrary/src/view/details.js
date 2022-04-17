import { html } from '../lib.js';
import { getUserData } from '../util.js';
import { getBookById, deleteBookById, likeBook, isBookLiked, getLikesByBookID } from '../api/data.js';


const detailsTemplate = (book, isOwner, onDelete,  likes, like,isLiked, userData)=>html`
<section id="details-page" class="details">
            <div class="book-information">
                <h3>${book.title}</h3>
                <p class="type">Type: ${book.type}</p>
                <p class="img"><img src=${book.imageUrl}></p>
                <div class="actions">
                    <!-- Edit/Delete buttons ( Only for creator of this book )  -->
                    ${isOwner ? html` <a class="button" href="/edit/${book._id}">Edit</a>
                    <a @click=${onDelete} class="button" href="">Delete</a>`: null}
                   

                    <!-- Bonus -->
                    <!-- Like button ( Only for logged-in users, which is not creators of the current book ) -->
                    ${!isOwner && !isLiked && userData? html`<a @click=${like} class="button" href="#">Like</a>`:null}
                    

                    <!-- ( for Guests and Users )  -->
                    <div class="likes">
                        <img class="hearts" src="/images/heart.png">
                        <span id="total-likes">Likes: ${likes}</span>
                    </div>
                    <!-- Bonus -->
                </div>
            </div>
            <div class="book-description">
                <h3>Description:</h3>
                <p>${book.description}</p>
            </div>
        </section>
`

export async function detailsPage(ctx){

    const userData =  getUserData();

    // const [book, likes, hasLike] = await Promise.All([await getBookById(ctx.params.id),
    //     await getLikesByBookID(book._id), 
    //     userData? await isBookLiked(book._id, userData.id) : 0
    // ])


const book = await getBookById(ctx.params.id);
const likes = await getLikesByBookID(book._id);
const hasLike = userData ? await isBookLiked(book._id, userData.id) : 0

const isOwner = userData && book._ownerId==userData.id;

ctx.render(detailsTemplate(book, isOwner, onDelete, likes, like, hasLike, userData));

async function onDelete(){
    const choise = confirm('Are you sure?')

    if(choise){
       await deleteBookById(ctx.params.id);
       ctx.page.redirect('/catalog');
    }
}


async function like(){
    await likeBook(book._id);
    ctx.page.redirect('/details/'+book._id);

}





   




   
}
