function getArticleGenerator(articles) {
    let secTexts = articles;

    function showNext() {
        if (secTexts.length > 0) {
            const newArticle = document.createElement('article');
            newArticle.textContent = secTexts.shift();
            document.querySelector('#content').appendChild(newArticle);
        }
    }
    return showNext;
}