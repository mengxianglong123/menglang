
/********************监听用户选择模板********************/
var imgCurrentId = null;
var imgId = 0;
$("#app").on("click",".create-img",function () {
    // console.log("点击")
    var mark = '  <div class="img-select-mark">\n' +
        '                    <i class="iconfont iconwancheng"></i>\n' +
        '                </div>';
    $(this).parent().find(".img-select-mark").remove();
    imgCurrentId = $(this).find("img").attr("alt");
    $(this).append(mark);
});

function toWrite() {
    if (imgCurrentId === null)
    {
        app.dialog.alert("","您还未选择模板");
    }
    else
    {
        imgId = imgCurrentId;
        mainView.router.navigate("/createInput/");
    }
    imgCurrentId = null;
}

/********************监听用户输入创作内容********************/
var title = null;
var words = null;
var name = null;
function selFont() {
    var formData = app.form.convertToData('#create-form');
    if (formData.words === ""){
        app.dialog.alert("","正文不可为空");
    }
    else
    {
        title = formData.title;
        words = formData.words;
        name = formData.name;
        mainView.router.navigate("/selCreateFont/");
    }
}

/********************监听用户选择字体********************/
var fontId = null;
var fontCurrentId = null;
$("#app").on("click",".create-font",function () {
    var mark = '  <div class="img-select-mark">\n' +
        '                    <i class="iconfont iconwancheng"></i>\n' +
        '                </div>';
    $(this).parent().find(".img-select-mark").remove();
    fontCurrentId = $(this).find("img").attr("alt");
    $(this).append(mark);
});

function toCreate() {
    if (fontCurrentId === null)
    {
        app.dialog.alert("","您还未选择字体")
    }
    else
    {
        app.dialog.preloader("正在渲染");
        fontId = fontCurrentId;
        app.request({
            url: 'createImg',
            method: 'GET',
            data:{
                imgId:imgId,
                fontId:fontId,
                title:title,
                words:words,
                name:name
            },
            success: function (data) {
                app.dialog.close();
                mainView.router.navigate("/createOut/?time="+data);
            }
        });
    }
}

function createBack() {
    mainView.router.navigate("/",{
        clearPreviousHistory:true,
        history:false
    });
}