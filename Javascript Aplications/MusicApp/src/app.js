import { page, render } from './lib.js';
import { logout } from './api/data.js';
import { getUserData } from './util.js';
import { loginPage } from './views/login.js';
import { registerPage } from './views/register.js';
import { catalogPage} from './views/catalog.js';
import { homePage} from './views/home.js';
import {createPage} from './views/create.js'
import {detailsPage} from './views/details.js'
import {editPage} from './views/edit.js'
import {searchPage} from './views/search.js'

const root = document.getElementById('main-content');
document.getElementById('logoutBtn').addEventListener('click', onLogout);


updateUserNav();
page(decorateContext)
page('/login', loginPage)
page('/register', registerPage)
page('/catalog', catalogPage)
page('/create', createPage)
page('/details/:id', detailsPage)
page('/edit/:id', editPage)
page('/', homePage)
page('/search', searchPage)

page.start()

function decorateContext(ctx, next) {
    ctx.render = (content) => render(content, root);

    ctx.updateUserNav = updateUserNav;

    next();
}

async function onLogout() {
    await logout();
    updateUserNav();
    page.redirect('/catalog');
    
}

function updateUserNav() {
    const userData = getUserData();

    if (userData) {
       
            document.getElementById('create').style.display='inline-block';
            document.getElementById('logoutBtn').style.display='inline-block';
            document.getElementById('login').style.display='none';
        document.getElementById('register').style.display='none';

    } else {
        document.getElementById('login').style.display='inline-block';
        document.getElementById('register').style.display='inline-block';
        document.getElementById('create').style.display='none';
        document.getElementById('logoutBtn').style.display='none';
    }
}