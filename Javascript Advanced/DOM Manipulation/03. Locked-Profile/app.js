function lockedProfile() {
    Array.from(document.querySelectorAll('.profile button'))
        .forEach(b => b.addEventListener('click', onClick));

    function onClick(e) {
        const profile = e.target.parentElement;
        const isActive = profile.querySelector('input[type="radio"][value="unlock"]').checked;
        if (isActive) {
            const info = Array.from(profile.querySelectorAll('div'))
                .find(p => p.id.includes('HiddenFields'));
            if (e.target.textContent == 'Show more') {
                e.target.textContent = 'Hide it';
                info.style.display = 'block';
            } else {
                e.target.textContent = 'Show more';
                info.style.display = '';
            }
        }
    }
}