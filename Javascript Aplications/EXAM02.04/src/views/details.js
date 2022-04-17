import { html } from '../lib.js';
import { getUserData } from '../util.js';
import { getPetById, deletePetById, getDonations, donatePet, isPetDonated} from '../api/data.js';

const detailsTemplate = (pet, isOwner, onDelete, userData, donations, donate, isPetNotDonated) => html`

        

<section id="detailsPage">
    <div class="details">
        <div class="animalPic">
            <img src=${pet.image}>
        </div>
        <div>
            <div class="animalInfo">
                <h1>Name: ${pet.name}</h1>
                <h3>Breed: ${pet.breed}</h3>
                <h4>Age: ${pet.age}</h4>
                <h4>Weight: ${pet.weight}</h4>
                <h4 class="donation">Donation: ${donations}$</h4>
            </div>
            <!-- if there is no registered user, do not display div-->
            ${userData ? html`<div class="actionBtn">
                ${isOwner ? html`<a href="/edit/${pet._id}" class="edit">Edit</a>
                <a @click= ${onDelete} href="" class="remove">Delete</a>` : 
                null}
                ${!isOwner && isPetNotDonated ? html`<a @click=${donate} href="" class="donate">Donate</a>` : null}
                <!-- Only for registered user and creator of the pets-->
               
                <!--(Bonus Part) Only for no creator and user-->
                
            </div>` : null}
            
        </div>
    </div>
</section>`;



export async function detailPage(ctx) {

    const pet = await getPetById(ctx.params.id);
   

    const userData = getUserData();
    
    const isOwner = userData && pet._ownerId == userData.id;
   
    const donations = await getDonations(ctx.params.id)*100;
    const isNotDonated = await isPetDonated(pet._id, userData.id) ==0 ;
    
    

    ctx.render(detailsTemplate(pet, isOwner, onDelete, userData, donations, donate, isNotDonated));

    async function onDelete() {
        const choise = confirm('Are you sure?')

        if (choise) {
            await deletePetById(ctx.params.id);
            ctx.page.redirect('/');
        }
    }

    async function donate(){

        await donatePet({petId: pet._id})


    }




}