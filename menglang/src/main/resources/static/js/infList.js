/**
 *
 * @param infName 被检测滚动的部分
 * @param viewName
 * @param pageId
 * @param reqName
 * @param addFunc
 * @param preloaderName
 * @param params 额外传递的参数（一个）
 * @param exitPage 进入哪个页面就退出无限滚动
 * @param updateIdName 更新列表id的其请求名称
 */

function infList(infName,viewName,pageId,reqName,addFunc,preloaderName,params,exitPage,updateIdName){
    viewName.router.once("routeChanged",function () {
        if (this.currentRoute.route.id === pageId)
        {
            if (updateIdName !== undefined)
                updateListId(updateIdName);
            inf(infName,viewName,pageId,reqName,addFunc,preloaderName,params,exitPage);
        }
    });

}




function inf(infName,viewName,pageId,reqName,addFunc,preloaderName,params,exitPage) {
    var $$ = Dom7;
    /*****************************初始化*****************************/
    // Loading flag
    var allowInfinite = true;
    var pageNum = 1;
    var exit = false;


    $$(preloaderName).show();
    /*****************************发送第一次请求,并添加元素*****************************/
    app.request.post(reqName, { pageNum:pageNum,params:params}, function (data) {
        data = jQuery.parseJSON(data);
        //判断是否查询到数据
        if (data.length !== 0){
            addFunc(data,$$,infName);
        }
        else {
            var toastCenter = app.toast.create({
                text: '抱歉，没有查询到相关数据',
                position: 'center',
                closeTimeout: 2000
            });
            addNull($$,infName);
            toastCenter.open();
        }
        $$(preloaderName).hide();

        /*************************测试代码***********************/
        // console.log(preloaderName,"隐藏");
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
                //转换为js对象
                data = jQuery.parseJSON(data);



                //判断是否结束滚动
                if (data.length === 0)
                {
                    allowInfinite = false;
                    $$(preloaderName).hide();
                    var toastCenter = app.toast.create({
                        text: '没有更多数据',
                        position: 'center',
                        closeTimeout: 2000
                    });
                    toastCenter.open();
                    return
                }
                addFunc(data,$$,infName);
                $$(preloaderName).hide();

                /*************************测试代码***********************/
                // console.log(preloaderName,"隐藏");
            });


        }, 1000);

    });

}

/**
 * 更新列表id
 * @param reqName
 */
function updateListId(reqName) {
    app.request({
        url: reqName,
        method: 'GET',
        async:false,
        success: function (data) {
        }
    });
}

/**
 * 专门为搜索使用的无限滚动
 * @param infName
 * @param reqName
 * @param addFunc
 * @param preloaderName
 * @param params
 * @param exitPage
 * @param tabId
 * @param updateIdName
 */
function infSearchList(infName,reqName,addFunc,preloaderName,params,exitPage,tabId,updateIdName){
    mainView.router.once("tabInit",function (newTabEl, tabRoute) {
        console.log(tabId,"和",tabRoute.id);
        if (tabRoute.id === tabId)
        {
            if (updateIdName !== undefined)
                updateListId(updateIdName);
            // inf(infName,mainView,null,reqName,addFunc,preloaderName,params,exitPage);
        }
    });
}

function addNull($$,addEl) {
    var html = '<div class="no-result" th:if="${authors.size() eq 0}">\n' +
        '            <div class="no-inner">\n' +
        '                <i class="iconfont iconkong"></i>\n' +
        '                <span>空空如也</span>\n' +
        '            </div>\n' +
        '        </div>';
    $$(addEl).append(html);
}
