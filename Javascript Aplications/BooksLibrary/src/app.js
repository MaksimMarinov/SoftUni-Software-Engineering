import { page, render } from './lib.js';
import { logout } from './api/data.js';
import { getUserData } from './util.js';
import { loginPage } from './view/login.js';
import { catalogPage } from './view/catalog.js';
import { registerPage } from './view/register.js';
import { createPage } from './view/create.js';
import { detailsPage } from './view/details.js';
import { editPage } from './view/edit.js';
import { myBooks } from './view/mybooks.js';



const root = document.getElementById('site-content');
document.getElementById('logoutBtn').addEventListener('click', onLogout);

page(decorateContext);
page('/login', loginPage);
page('/catalog', catalogPage);
page('/register', registerPage);
page('/add', createPage);
page('/details/:id', detailsPage);
page('/edit/:id', editPage);
page('/mybooks', myBooks);
updateUserNav();
page.start()

function decorateContext(ctx, next) {
    ctx.render = (content) => render(content, root);

    ctx.updateUserNav = updateUserNav;

    next();
}

function updateUserNav() {
    const userData = getUserData();

    if (userData) {
        document.getElementById('user').querySelector('span').textContent=`Welcome, ${userData.email}`
            document.getElementById('user').style.display='inline-block';
            document.getElementById('guest').style.display='none';

    } else {
        document.getElementById('user').style.display='none';
        document.getElementById('guest').style.display='inline-block';
    }
}

async function onLogout() {
    await logout();
    updateUserNav();
    page.redirect('/catalog');
    
}
