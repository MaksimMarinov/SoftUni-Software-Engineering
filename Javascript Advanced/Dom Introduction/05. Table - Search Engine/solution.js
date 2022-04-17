function solve() {
    document.querySelector('#searchBtn').addEventListener('click', onClick);

   function onClick() {
      const students= Array.from(document.querySelectorAll('tbody tr'));
      const search = document.getElementById('searchField');
      for (const student of students) {
         let text = student.textContent.toLowerCase();
         if(text.includes(search.value.toLowerCase())){

            student.classList.add('select');
         }else{
            student.classList.remove('select')
         }
      }


      search.value=null;
   }
}