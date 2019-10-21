/**
 * 添加诗词
 * @param data
 */
function addPoem(data,$$,addEl) {
    var html = '';
    for (var i = 0; i < data.length; i++) {

        html += '<li>' +
            '<a href="/poemDetail/?id='+data[i].id+ '" class="item-link item-content">' +
            '<div class="item-inner">' +
            '<div class="item-title-row">' +
            '<div class="item-title">' + '《' + data[i].title + '》' + '</div>' +
            '<div class="item-after">' + '[' + data[i].time + '] ' + data[i].author + '</div>' +
            '</div>' +
            '<div class="item-text">' + data[i].content + '</div>' +
            '</div> </a> </li>';
    }
    $$(addEl+' ul').append(html);
}


function openPoemList(reqName,params,pageName){
    var poemListId = null;
    var preloder = null;
    var infName = "";
    app.request({
        url: 'getPoemListId',
        method: 'GET',
        async:false,
        data:{pageName:pageName},
        success: function (data) {
          poemListId = data;
        }
    });
    infName = '#poemList-' + poemListId;
    preloder = "#poemList-preloader-" + poemListId;

    /*****************************启动诗词无限滚动*****************************/
    infList(infName,mainView,"poemList",reqName,addPoem,preloder,params,"index");
}

// function openSearchPoemList(reqName,params,tabId) {
//     var poemListId = null;
//     var preloader = null;
//     var infName  = null;
//     app.request({
//         url: 'getPoemListId',
//         method: 'GET',
//         async:false,
//         cache: false,
//         success: function (data) {
//             poemListId = data;
//         }
//     });
//     infName = '#poemList-' + poemListId;
//     preloader = "#poemList-preloader-" + poemListId;
//     infSearchList(infName,reqName,addPoem,preloader,params,"search",tabId,"updateSearchPoemListId");
// }