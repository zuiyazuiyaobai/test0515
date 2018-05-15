$(function () {
    laydate.render({
        elem: '#sjkgsj', //目标元素。由于laydate.js封装了一个轻量级的选择器引擎，因此elem还允许你传入class、tag但必须按照这种方式 '#id .class'
        event: 'focus' //响应事件。如果没有传入event，则按照默认的click
    });
    laydate.render({
        elem: '#sjjgsj', //目标元素。由于laydate.js封装了一个轻量级的选择器引擎，因此elem还允许你传入class、tag但必须按照这种方式 '#id .class'
        event: 'focus' //响应事件。如果没有传入event，则按照默认的click
    });

    for(var i = 1; i < 7; i++) {
        $(".row_" + i).each(function(){
            $(this).bind("change", function () {
                if($(this).hasClass("row_1")){
                    calcuSum(1);
                }else if($(this).hasClass("row_2")){
                    calcuSum(2);
                }else if($(this).hasClass("row_3")){
                    calcuSum(3);
                }else if($(this).hasClass("row_4")){
                    calcuSum(4);
                }else if($(this).hasClass("row_5")){
                    calcuSum(5);
                }else if($(this).hasClass("row_6")){
                    calcuSum(6);
                }
            });
        });

        //加载完先调用一次
        calcuSum(i);
    }

});

function calcuSum(index){
    var rows = $(".row_" + index);
    var result = 0;
    var subSum1 = 0;
    var subSum2 = 0;
    var subSum3 = 0;
    for(var i = 0; i < rows.length; i++){
    	
        var value = $(rows[i]).val();
        if(value != null && value != ''){
            result += value / 1;

            // 统计分类小项
            if(i > 2 && i <= 10 ){
                subSum1 += value / 1;
            }else if(i >= 11 && i <= 13){
                subSum2 += value / 1;
            }else if(i >= 14 && i <= 16){
                subSum3 += value / 1;
            }
        }
    }
    
    $(".sum_" + index).val(result);
    $(".subSum1_" + index).val(subSum1);
    $(".subSum2_" + index).val(subSum2);
    $(".subSum3_" + index).val(subSum3);
}


// 打开选择联系人页面
function openXzlxrDialog(){
    top.layer.open({
        type: 2,
        area: ['700px', '500px'],
        title: '选择联系人',
        maxmin: true, //开启最大化最小化按钮
        content: ctx + '/xmjbxx/sub/cInsBusinessContact/list',
        btn: ['确认','关闭'],
        yes: function(index, layero){
            var iframeWin = layero.find('iframe')[0];
            iframeWin.contentWindow.doSubmit(function(name,office,mobile){
                $("#name").val(name);
                $("#office").val(office);
                $("#mobile").val(mobile);
                setTimeout(function () {
                    top.layer.close(index)
                }, 100);
            });
            return false;
        },
        cancel: function(index){
        }
    });
}
