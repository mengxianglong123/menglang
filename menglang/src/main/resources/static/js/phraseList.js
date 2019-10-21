/**
 * 添加名句
 * @param data
 */
function addPhrase(data,$$) {
    var html = '';
    for (var i = 0; i < data.length; i++) {

        html += '<a class="phrase-card link">'+
            '<div class="phrase-content">'+
            data[i].content+
            '</div>'+
            '<div class="phrase-footer">'+'---'+data[i].poemAuthor+'《'+data[i].poemTitle+ '》</div>'+
            '</a>';
    }
    $$('.phrase-list').append(html);
}


function openPhraseList(){
    /*****************************启动名句无限滚动*****************************/
    infList(".phrase-inf",mainView,"phraseList","selAllPhrasePage",addPhrase,".phraseList-preloader",null,"index");
}

