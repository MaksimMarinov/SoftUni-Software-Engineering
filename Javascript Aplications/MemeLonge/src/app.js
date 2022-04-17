import { getUserData } from "./util.js";
import { logout } from './api/data.js';
import { page, render } from './lib.js';

import { loginPage } from "./views/login.js";
import { registerPage } from "./views/register.js";
import { createPage } from "./views/create.js";
import { catalogPage } from "./views/catalog.js";
import { homePage } from "./views/home.js";
import { detailsPage } from "./views/details.js";
import { editPage } from "./views/edit.js";
import { profilePage } from "./views/profile.js";

const root = document.querySelector('main');

document.getElementById('logoutBtn').addEventListener('click', onLogout)

updateUserNav();

page(decorateContext);

page('/login', loginPage)
page('/register', registerPage)
page('/create', createPage)
page('/catalog', catalogPage)
page('/', homePage)
page('/details/:id', detailsPage)
page('/edit/:id', editPage)
page('/profile', profilePage)

page.start();


function decorateContext(ctx, next) {
    ctx.render = (content) => render(content, root);
    ctx.updateUserNav = updateUserNav;
    next();
}





function updateUserNav() {
    const userData = getUserData();
    const user = document.querySelector('.user');
    if (userData) {

        user.querySelector('span').textContent = `Welcome, ${userData.email}`;
        user.style.display = 'block';
        document.querySelector('.guest').style.display = 'none';
    } else {
        user.style.display = 'none';
        document.querySelector('.guest').style.display = 'block';
    }
}

async function onLogout() {
    logout();
    updateUserNav();
    page.redirect('/');
}