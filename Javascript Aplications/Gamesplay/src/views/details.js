import { html } from '../lib.js';
import { getUserData } from '../util.js';
import { getGameById, deleteGameById, getComments, postComment } from '../api/data.js';

const detailsTemplate = (game, isOwner, onDelete, userData, comments, onSubmit) =>html`
<section id="game-details">
            <h1>Game Details</h1>
            <div class="info-section">

                <div class="game-header">
                    <img class="game-img" src=${game.imageUrl} />
                    <h1>${game.title}</h1>
                    <span class="levels">MaxLevel: ${game.maxLevel}</span>
                    <p class="type">${game.category}</p>
                </div>

                <p class="text">
                    ${game.summary}
                </p>

               
                <div class="details-comments">
                     <h2>Comments:</h2>
                     ${comments.length==0 ? html`<p class="no-comment">No comments.</p>` :
                    
                        html`<ul>
                            ${comments.map(commentCard)}
                        </ul>`}
                   <!--  -->
                    <!-- Display paragraph: If there are no games in the database -->
                      <!---->
                </div>

                
               ${isOwner&&userData ? html`
               <div class="buttons">
                    <a href="/edit/${game._id}" class="button">Edit</a>
                    <a @click=${onDelete} href="" class="button">Delete</a>
                </div>`: null}
            </div> 

        ${userData && !isOwner ? html`
      <article class="create-comment">
                <label>Add new comment:</label>
                <form @submit = ${onSubmit}class="form">
                    <textarea name="comment" placeholder="Comment......"></textarea>
                    <input class="btn submit" type="submit" value="Add Comment">
                </form>
            </article>`:null}

        

        </section>`;

const commentCard = (comment) => html`<li class="comment">
<p>Content: ${comment.comment}.</p>
</li>`;


export async function detailPage(ctx){
    const game = await getGameById(ctx.params.id);

    const userData = getUserData();
    const isOwner = userData && game._ownerId==userData.id;

    const comments = await getComments(ctx.params.id)

    ctx.render(detailsTemplate(game, isOwner, onDelete, userData, comments, onSubmit));

    async function onDelete(){
        const choise = confirm('Are you sure?')
    
        if(choise){
           await deleteGameById(ctx.params.id);
           ctx.page.redirect('/');
        }
    }

    async function onSubmit(event){
        event.preventDefault();
        const formData = new FormData(event.target);
        const comment = formData.get('comment')
        if(comment.trim()==''){
            return alert('Cannot be empty')
        }
       
        await postComment({gameId: ctx.params.id, comment});
       event.target.reset()
        ctx.page.redirect('/details/'+ctx.params.id);
    }
}