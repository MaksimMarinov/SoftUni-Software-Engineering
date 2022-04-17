import { page, render } from './lib.js'
import { getUserData } from './util.js';
import {  logout } from './api/data.js';
import {homePage} from './views/home.js'
import { loginPage } from './views/login.js';
import { registerPage } from './views/register.js';
import { catalogPage } from './views/catalog.js';
import { detailPage } from './views/details.js';
import { createPage } from './views/create.js';
import { editPage } from './views/edit.js';

const root = document.getElementById('main-content');

document.getElementById('logoutBtn').addEventListener('click', onLogout);


updateUserNav();
page(decorateContext);
page('/', homePage)
page('/login', loginPage);
page('/register', registerPage);
page('/catalog', catalogPage);
page('/details/:id', detailPage);
page('/create', createPage);
page('/edit/:id', editPage);
page.start();

function decorateContext(ctx, next) {
    ctx.render = (content) => render(content, root);
    ctx.updateUserNav = updateUserNav;
    next();
}


function updateUserNav() {

    const userData = getUserData()
    if (userData) {
    
        document.getElementById('user').style.display = 'inline-block';
        document.getElementById('guest').style.display = 'none';

    } else {
        document.getElementById('user').style.display = 'none';
        document.getElementById('guest').style.display = 'inline-block';
    }
}







async function onLogout() {
    await logout();
    updateUserNav();
    page.redirect('/')
}