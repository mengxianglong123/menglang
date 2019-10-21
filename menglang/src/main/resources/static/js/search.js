 /******************在search页面发生搜索******************/
$("#app").on("submit","#search-form",function () {
    var keyword = $("#search-input").val();
    if (keyword !== "") {
        mainView.router.navigate('/searchResult/?keyword='+keyword,{
            reloadCurrent:true
        });
    }

    return false
});
 /******************在searchResult页面发生提交搜索******************/
$("#app").on("submit","#searchResult-form",function () {
    var keyword = $("#result-input").val();
    if (keyword !== "") {
        mainView.router.navigate('/searchResult/?keyword='+keyword,{
            reloadCurrent:true
        });
    }
    return false;
});

 /******************在searchResult页面切换选项卡******************/
 //诗词
var $$ = Dom7;
 $$("#app").on("tab:mounted",".result-tab",function () {
     var reqName = $(this).attr("data-req");
     var poemListId = null;
     var preloader = null;
     var infName  = null;
     var keyword = $(this).attr("data-key");
     app.request({
         url: 'getSearchPoemListId',
         method: 'GET',
         async:false,
         cache: false,
         success: function (data) {
             poemListId = data;
         }
     });
     infName = '#poemList-' + poemListId;
     preloader = "#poemList-preloader-" + poemListId;
     updateListId("updateSearchPoemListId");
     inf(infName,mainView,null,reqName,addPoem,preloader,keyword,"index");
 });
 //作者
 var $$ = Dom7;
 $$("#app").on("tab:mounted",".author-tab",function () {
     var reqName = $(this).attr("data-req");
     var authorListId = null;
     var preloader = null;
     var infName  = null;
     var keyword = $(this).attr("data-key");
     app.request({
         url: 'getSearchAuthorListId',
         method: 'GET',
         async:false,
         cache: false,
         success: function (data) {
             authorListId = data;
         }
     });
     infName = '#authorList-' + authorListId;
     preloader = "#authorList-preloader-" + authorListId;
     updateListId("updateSearchAuthorListId");
     inf(infName,mainView,null,reqName,addAuthor,preloader,keyword,"index");
 });


 /******************点击热门标签进行搜索******************/
 $("#app").on("click",".search-chip",function () {
    var keyword = this.innerText;
     mainView.router.navigate('/searchResult/?keyword='+keyword,{
         reloadCurrent:true
     });
 });
 /******************AutoComplete******************/
 function createAutoComplete(page) {
     var inputEl = "";
     if (page === "search") inputEl = "#search-input";
     if (page === "searchResult") inputEl = "#result-input";
     app.autocomplete.destroy(inputEl);
     var autocompleteDropdownAjax = app.autocomplete.create({
         inputEl: inputEl,
         openIn: 'dropdown',
         // preloader: true,
         valueProperty: 'keyword', //object's "value" property name
         textProperty: 'keyword', //object's "text" property name
         limit: 10, //limit to 20 results
         // dropdownContainerEl:'.search-dropdown',
         source: function (query, render) {
             var autocomplete = this;
             var results = [];
             if (query.length === 0) {
                 render(results);
                 return;
             }


             // Do Ajax request to Autocomplete data
             app.request({
                 url: 'autoComplete',
                 method: 'POST',
                 dataType: 'json',
                 //send "query" to server. Useful in case you generate response dynamically
                 data: {
                     keyword: query
                 },
                 success: function (data) {
                     for (var i = 0; i < data.length; i++) {
                         if (data[i].toLowerCase().indexOf(query.toLowerCase()) >= 0) results.push(data[i]);
                     }
                     render(results);
                 }
             });
         }
     });
     autocompleteDropdownAjax.on("close",function () {
         var keyword = "";
         if (page === "search"){
             keyword = $("#search-input").val();
             $("#search-form").submit();
         }
         if (page === "searchResult"){
             keyword = $("#result-input").val();
             $("#searchResult-form").submit();
         }

     });
 }

 mainView.router.on("routeChange",function () {
     if (this.currentRoute.route.id === "search" || this.currentRoute.route.id === "searchResult"){
         var page = this.currentRoute.route.id;
         setTimeout(function () {

             createAutoComplete(page)
         },500)

     }
 });