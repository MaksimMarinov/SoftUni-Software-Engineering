import { getSearch } from '../api/data.js'
import { html, render } from '../lib.js'
import { getUserData } from '../util.js'

const searchTemplate = ()=> html `<section id="searchPage">
<h1>Search by Name</h1>

<div class="search">
    <input id="search-input" type="text" name="search" placeholder="Enter desired albums's name">
    <button id="searchBtn" class="button-list">Search</button>
</div>

<h2>Results:</h2>

<!--Show after click Search button-->

</section>
`

const searchResults = (albums, userData)=> html`
<div class="search-result">
    <!--If have matches-->
    ${albums.length==0?html` <p class="no-result">No result.</p>` :
albums.map(album=>albumCard(album, userData))}

    <!--If there are no matches-->
   


    </div>`

    const albumCard = (album, userData)=> html`
    <div class="card-box">
        <img src=${album.imgUrl}>
        <div>
            <div class="text-center">
                <p class="name">Name: ${album.name}</p>
                <p class="artist">Artist: ${album.artist}</p>
                <p class="genre">Genre: ${album.genre}</p>
                <p class="price">Price: ${album.price}</p>
                <p class="date">Release Date: ${album.releaseDate}}</p>
            </div>
            ${userData ? html` <div class="btn-group">
        <a href="/details/${album._id}" id="details">Details</a>
    </div>` :null}
        </div>
    </div>`


export async function searchPage(ctx){
    const userData = getUserData();
ctx.render(searchTemplate());
document.getElementById('searchBtn').addEventListener('click', search);
async function search(t){

    const searchValue = document.getElementById('search-input').value
    if(searchValue){
        const albums = await getSearch(searchValue);
        const srhtml = searchResults(albums, userData)
        console.log(srhtml);
      render(searchResults(albums, userData), document.getElementById('searchPage'))
      ctx.render(searchTemplate());
    
    }
}


}