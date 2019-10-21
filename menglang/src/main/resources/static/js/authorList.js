/**
 * 添加作者
 * @param data
 */
function addAuthor(data,$$,addEl) {
    var html = '';
    for (var i = 0; i < data.length; i++){
        //判断是否有照片
        if (data[i].img === null) data[i].img = "default.jpg";

        html += '<li>'+
            '<a href='+'"/authorDetail/?id='+data[i].id + '"' + 'class="item-link item-content link">'+
            '<div class="item-media"><img src='  +  '"../static/images/authorImgs/'+data[i].img+  '" width="85"/></div>' +
            '<div class="item-inner">'+
            '<div class="item-title-row">'+
            '<div class="item-title" style="margin-bottom: 4px;">'+data[i].name+'</div>'+
            '</div>'+
            '<div class="item-subtitle">'+data[i].time+'</div>'+
            '<div class="item-text">'+data[i].introduction +'</div>'+
            '</div> </a> </li>'
    }
    $$(addEl + ' ul').append(html);
}



function openAuthorList(pageName){
    var authorListId = null;
    var preloader = null;
    var infName = "";
    app.request({
        url: 'getAuthorListId',
        method: 'GET',
        data:{pageName:pageName},
        async:false,
        success: function (data) {
            authorListId = data;
        }
    });
    infName = '#authorList-' + authorListId;
    preloader = '#authorList-preloader-'+authorListId;
    /*****************************启动诗人无限滚动*****************************/
    infList(infName,mainView,"authorList","selAllAuthorPage",addAuthor,preloader,null,"index");
}