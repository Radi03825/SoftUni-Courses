function attachEvents() {
    let loadBtn = document.getElementById('btnLoadPosts');
    loadBtn.addEventListener('click', getPosts);

    let select = document.getElementById('posts');
    let postTitle = document.getElementById('post-title');
    let postBody = document.getElementById('post-body');
    let postComments = document.getElementById('post-comments');

    async function getPosts(ev) {
        let res = await fetch('http://localhost:3030/jsonstore/blog/posts');
        let posts = await res.json();

        for (const post in posts) {
            let option = document.createElement('option');
            option.value = posts[post].id;
            option.textContent = posts[post].title;

            select.appendChild(option);
        }
    }

    let viewBtn = document.getElementById('btnViewPost');

    viewBtn.addEventListener('click', showPost);

    async function showPost(ev) {
        let id = select.value;
        let r = await fetch(`http://localhost:3030/jsonstore/blog/posts/${id}`);
        let post = await r.json();

        postTitle.textContent = post.title;
        postBody.textContent = post.body;

        postComments.innerHTML = '';

        let resCom = await fetch(`http://localhost:3030/jsonstore/blog/comments`);
        let comments = await resCom.json();

        for (const comment in comments) {
           if(comments[comment].postId == id) {
               let li = document.createElement('li');
               li.id = comments[comment].id;
               li.textContent = comments[comment].text;

               postComments.appendChild(li);
           }
        }
    }
}

attachEvents();