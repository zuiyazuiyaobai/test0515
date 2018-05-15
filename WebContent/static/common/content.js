var $parentNode = window.parent.document;

function $childNode(name) {
    return window.frames[name]
}

$(function () {
    // tooltips
    $('.tooltip-demo').tooltip({
        selector: "[data-toggle=tooltip]",
        container: "body"
    });

    // 使用animation.css修改Bootstrap Modal
    $('.modal').appendTo("body");

    $("[data-toggle=popover]").popover();

    //折叠ibox
    $('.collapse-link').click(function () {
        var ibox = $(this).closest('div.ibox');
        var button = $(this).find('i');
        var content = ibox.find('div.ibox-content');
        content.slideToggle(200);
        button.toggleClass('fa-chevron-up').toggleClass('fa-chevron-down');
        ibox.toggleClass('').toggleClass('border-bottom');
        setTimeout(function () {
            ibox.resize();
            ibox.find('[id^=map-]').resize();
        }, 50);
    });

    //左右折叠ibox
    $('.collapse-left-link').click(function () {
        var ibox = $(this).closest('div.leftBox');
        var button = $(this).find('i');
        var content = ibox.find('div.leftBox-content');
        content.slideToggle(200);
        button.toggleClass('fa-chevron-left').toggleClass('fa-chevron-right');
        if (button.hasClass('fa-chevron-left')) {
            setTimeout(function () {
                ibox.width("180px");
                // ibox.find('[id^=map-]').resize();
            }, 200);
        } else {
            setTimeout(function () {
                ibox.width("10px");
                // ibox.find('[id^=map-]').resize();
            }, 200);
        }
    });

    //折叠指定样式的ibox（搜索栏）
    $('.collapse-custom-link').click(function () {
    	debugger;
        var ibox = $(this).closest('div.ibox-custom');
        var button = $(this).find('i');
        var content = ibox.find('div.ibox-custom-content');
        var buttonText = button.parent().find("span[name='button-text']");
        var moreSearch = ibox.find('#moreSearch');
        // 通过 slideToggle() 的方式切换默认隐藏到显示状态时会导致“闪屏”
        // 换成 toggleClass 的方式更为平滑
        content.toggleClass('ibox-custom-content-hide').toggleClass('ibox-custom-content-show');
        button.toggleClass('fa-chevron-down').toggleClass('fa-chevron-up');
        if(button.hasClass('fa-chevron-up')){
            buttonText.text("收起");
            moreSearch.val(GLOBAL.YES);
        }else{
            buttonText.text("更多");
            moreSearch.val(GLOBAL.NO);
        }
        // ibox.toggleClass('').toggleClass('border-bottom');
        setTimeout(function () {
            ibox.resize();
            ibox.find('[id^=map-]').resize();
        }, 50);
    });

    // 初始化是否展开更多搜索
    // moreSearch 默认值为 false
    $("div.ibox-custom").find("#moreSearch").each(function(){
        if(GLOBAL.YES == $(this).val()){
            $(this).closest('div.ibox-custom').find('.collapse-custom-link').click();
        }
    });

    //关闭ibox
    $('.close-link').click(function () {
        var content = $(this).closest('div.ibox');
        content.remove();
    });

    //判断当前页面是否在iframe中
    if (top == this) {
        var gohome = '<div class="gohome"><a class="animated bounceInUp" href="index.html?v=3.1" title="返回首页"><i class="fa fa-home"></i></a></div>';
        $('body').append(gohome);
    }
});

//animation.css
function animationHover(element, animation) {
    element = $(element);
    var close = $(element).find(".close-link");
    element.hover(
        function () {
            close.removeClass("hidden");
            element.addClass('animated ' + animation);
        },
        function () {
            //动画完成之前移除class
            window.setTimeout(function () {
                element.removeClass('animated ' + animation);
                close.addClass("hidden");
            }, 300);
        });
}

//拖动面板
function WinMove() {
    var element = "[class*=col]";
    var handle = ".ibox-title";
    var connect = "[class*=col]";
    $(element).sortable({
        handle: handle,
        connectWith: connect,
        tolerance: 'pointer',
        forcePlaceholderSize: true,
        opacity: 0.8
    }).disableSelection();
}