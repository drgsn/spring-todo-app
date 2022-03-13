document.addEventListener("DOMContentLoaded", () => {
    document.getElementById("create").addEventListener('click', () => {
        const title = document.getElementById("title").value;
        const description = document.getElementById("description").value;

        console.log(`${title} and ${description}`);
        postData("http://localhost:8081/v1/todo", {'name': title, 'description': description});
        console.log(getData("http://localhost:8081/v1/todo"));
    })

    async function postData(url = '', data = {}) {
        // Default options are marked with *
        const response = await fetch(url, {
            method: 'POST', // *GET, POST, PUT, DELETE, etc.
            // mode: 'cors', // no-cors, *cors, same-origin
            // cache: 'no-cache', // *default, no-cache, reload, force-cache, only-if-cached
            // credentials: 'same-origin', // include, *same-origin, omit
            headers: {
                'Content-Type': 'application/json'
                // 'Content-Type': 'application/x-www-form-urlencoded',
            },
            redirect: 'follow', // manual, *follow, error
            referrerPolicy: 'no-referrer', // no-referrer, *no-referrer-when-downgrade, origin, origin-when-cross-origin, same-origin, strict-origin, strict-origin-when-cross-origin, unsafe-url
            body: JSON.stringify(data) // body data type must match "Content-Type" header
        });
        return response.json(); // parses JSON response into native JavaScript objects
    }


    async function getData(url = '', data = {}) {
        // Default options are marked with *
        const response = await fetch(url);
        return response.json(); // parses JSON response into native JavaScript objects
    }
})