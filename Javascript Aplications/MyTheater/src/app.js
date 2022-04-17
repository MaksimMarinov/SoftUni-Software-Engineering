import { logout } from './api/data.js';
import {page, render} from './lib.js';
import { getUserData } from './util.js';
import { createPage } from './views/create.js';
import { detailsPage } from './views/details.js';
import { editPage } from './views/edit.js';
import { homePage } from './views/home.js';
import { loginPage } from './views/login.js';
import { profilePage } from './views/profile.js';
import { registerPage } from './views/register.js';


const root = document.getElementById('content');

document.getElementById('logoutBtn').addEventListener('click', onLogout);
updateUserNav();

page(decorateContext);
page('/login', loginPage);
page('/register', registerPage);
page('/', homePage);
page('/create', createPage);
page('/details/:id', detailsPage);
page('/edit/:id', editPage);
page('/profile', profilePage)
page.start();





function decorateContext(ctx, next){
    ctx.render =(content) => render(content, root);

    ctx.updateUserNav = updateUserNav;
    next();
}


function updateUserNav(){
    const userData = getUserData();

    if(userData){
        document.getElementById('login').style.display = 'none';
        document.getElementById('register').style.display = 'none';
        document.getElementById('profile').style.display = 'inline-block';
        document.getElementById('create').style.display = 'inline-block';
        document.getElementById('logoutBtn').style.display = 'inline-block';
    }else{
        document.getElementById('login').style.display = 'inline-block';
        document.getElementById('register').style.display = 'inline-block';
        document.getElementById('profile').style.display = 'none';
        document.getElementById('create').style.display = 'none';
        document.getElementById('logoutBtn').style.display = 'none';
    }
}

async function onLogout(){
    logout();
    updateUserNav();
    page.redirect('/');
}