import { logout } from './api/api.js';
import {page, render} from './lib.js';
import { getUserData } from './util.js';
import { catalogPage } from './views/catalog.js';
import { createPage } from './views/create.js';
import { detailPage } from './views/details.js';
import { editPage } from './views/edit.js';
import { homePage } from './views/home.js';
import { loginPage } from './views/login.js';
import { registerPage } from './views/register.js';
import { myListPage } from './views/myCatalog.js';
import { byYear } from './views/search.js';


const root = document.getElementById('site-content');

document.getElementById('logoutBtn').addEventListener('click', onLogout);

updateUserNav();
page(decorateContext);
page('/login', loginPage);
page('/register', registerPage);
page('/catalog', catalogPage);
page('/details/:id', detailPage);
page('/create', createPage)
page('/edit/:id', editPage);
page('/mycars',myListPage );
page('/byyear',byYear );
page('/', homePage)
page.start()

function decorateContext(ctx, next){
    ctx.render =(content) => render(content, root);

    ctx.updateUserNav = updateUserNav;
    next();
}

function updateUserNav(){
    const userData = getUserData();

    if(userData){
        document.getElementById('profile').querySelector('a').textContent=`Welcome ${userData.username}`
        document.getElementById('guest').style.display = 'none';
        document.getElementById('profile').style.display = 'inline-block';
    }else{
        document.getElementById('profile').style.display = 'none';
        document.getElementById('guest').style.display = 'inline-block';
    }
}

async function onLogout(){
    logout();
    updateUserNav();
    page.redirect('/');
}