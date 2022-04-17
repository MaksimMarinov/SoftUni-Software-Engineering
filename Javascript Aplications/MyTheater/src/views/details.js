import { html } from '../lib.js';
import { getUserData } from '../util.js';
import { getTheaterById, getLikesByTheaterID, isTheaterLiked, deleteTheaterById, likeTheater } from '../api/data.js';


const detailsTemplate = (theater, isOwner, onDelete,  likes, like,isLiked, userData)=>html`
<section id="detailsPage">
            <div id="detailsBox">
                <div class="detailsInfo">
                    <h1>Title: ${theater.title}</h1>
                    <div>
                        <img src=${theater.imageUrl} />
                    </div>
                </div>

                <div class="details">
                    <h3>Theater Description</h3>
                    <p>${theater.description}</p>
                    <h4>Date: ${theater.date}</h4>
                    <h4>Author: ${theater.author}</h4>
                    <div class="buttons"></div>
                    ${isOwner ? html`<a @click=${onDelete} class="btn-delete" href="">Delete</a>
                        <a  class="btn-edit" href="/edit/${theater._id}">Edit</a>` : null}

                        ${!isOwner && !isLiked && userData? html`<a @click=${like} class="btn-like" href="#">Like</a>`:null}
                    </div>
                    <p class="likes">Likes: ${likes}</p>
                </div>
            </div>
        </section>
`

export async function detailsPage(ctx){

    const userData =  getUserData();



const theater = await getTheaterById(ctx.params.id);
const likes = await getLikesByTheaterID(theater._id);
const hasLike = userData ? await isTheaterLiked(theater._id, userData.id) : 0

const isOwner = userData && theater._ownerId==userData.id;

ctx.render(detailsTemplate(theater, isOwner, onDelete, likes, like, hasLike, userData));

async function onDelete(){
    const choise = confirm('Are you sure?')

    if(choise){
       await deleteTheaterById(ctx.params.id);
       ctx.page.redirect('/profile');
    }
}


async function like(){
    await likeTheater(theater._id);
    ctx.page.redirect('/details/'+theater._id);

}





   




   
}
