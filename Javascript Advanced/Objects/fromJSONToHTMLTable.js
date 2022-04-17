function fromJSONToHTMLTable(input){
        let html = '<table>\n'


    for (const parsedKey of input) {
        let object = JSON.parse(parsedKey);
        html += '  <tr>\n'
        html += '     <td>' + object.name + '</td>\n'
        html += '     <td>' + object.price + '</td>\n'
        html += '  <tr>\n'
    }


        html += '</table>'
        return html

}

fromJSONToHTMLTable([{"Name":"Stamat","Price":5.5},{"Name":"Rumen","Price":6}]);