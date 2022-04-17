function editElement(reference, match, replacer) {
    const content = reference.textContent;
    const edited = content.split(match).join(replacer);
    reference.textContent=edited;
}