async function attachEvents() {
    let messages = document.getElementById('messages');
    let author = document.getElementsByName('author')[0];
    let content = document.getElementsByName('content')[0];

    let sendBtn = document.getElementById('submit');
    sendBtn.addEventListener('click', sendMessage);

    let refreshBtn = document.getElementById('refresh');
    refreshBtn.addEventListener('click', refreshMessages);

    async function refreshMessages() {
        let res = await fetch('http://localhost:3030/jsonstore/messenger');

        let data = await res.json();

        messages.textContent = '';

        let text = [];

        for (const d in data) {
            text.push(data[d].author + ": " + data[d].content);
        }

        messages.textContent = text.join('\n');

    }

    async function sendMessage() {
        const data = {"author": author.value,
         "content": content.value};

        fetch('http://localhost:3030/jsonstore/messenger', {
        
        method: 'post',
        
        headers: { 'Content-type': 'application/json' },
        
        body: JSON.stringify(data)
        
        });

        author.value = '';
        content.value = '';
    }

    
}

attachEvents();