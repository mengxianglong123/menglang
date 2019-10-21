function addFindPhrase($$,html) {
    $$('.find-phrase ul').append(html);
}


function infForFind(infName,viewName,pageId,reqName,addFunc,preloaderName,params,exitPage) {
    var $$ = Dom7;
    /*****************************初始化*****************************/
        // Loading flag
    var allowInfinite = true;
    var pageNum = 1;
    var exit = false;


    $$(preloaderName).show();
    /*****************************发送第一次请求,并添加元素*****************************/
    app.request.post(reqName, { pageNum:pageNum,params:params}, function (data) {
            addFindPhrase($$,data)
            $$(preloaderName).hide();
    });
    /*****************************检测是否到达指定结束滚动的页面*****************************/
    viewName.router.on("routeChanged",function () {
        if (this.currentRoute.route.id === exitPage)
        {
            exit = true;
            viewName.router.off("routeChanged");
            return null;
        }

    });


    /*****************************进入无限滚动模式*****************************/
    // Attach 'infinite' event handler
    $$(infName).on('infinite', function () {
        // Exit, if loading in progress
        if (!allowInfinite) return;
        if (exit) return;
        /*****************************页数自增*****************************/
        pageNum++;


        $$(preloaderName).show();


        /*************************测试代码***********************/
        // console.log(preloaderName,"显示");


        // Set loading flag
        allowInfinite = false;

        // Emulate 1s loading
        setTimeout(function () {
            // Reset loading flag
            allowInfinite = true;

            /*****************************发送请求*****************************/
            app.request.post(reqName, { pageNum:pageNum,params:params}, function (data) {
                addFindPhrase($$,data);
            });


        }, 1000);

    });

}
$$("#app").on("tab:mounted","#find",function () {
    app.infiniteScroll.create('.find-phrase');
    infForFind(".find-phrase",mainView,null,"selPhraseRand",addFindPhrase,".find-phrase-preloader",null)
})
