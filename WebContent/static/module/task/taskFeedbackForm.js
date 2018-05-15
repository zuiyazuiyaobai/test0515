var validateForm;
$(document).ready(function () {
    validateForm = $("#inputForm").validate({
        submitHandler: function (form) {
            loading('正在提交，请稍等...');
            form.submit();
        },
        errorContainer: "#messageBox",
        errorPlacement: function (error, element) {
            $("#messageBox").text("输入有误，请先更正。");
            if (element.is(":checkbox") || element.is(":radio") || element.parent().is(".input-append")) {
                error.appendTo(element.parent().parent());
            } else {
                error.insertAfter(element);
            }
        }
    });

    bindTabSwitchEven();
});

function doSubmit(func){
    submitSsqk(func);
}

function setOperateType(type){
    operateType = type;

    if("view" == operateType){
        $("#selectContact").hide();
        $("#taskFeedbackForm").attr("disabled",true);
    }
}

function submitSsqk(callback){
    if (!validateForm.form()) {
        layer.alert("存在未填写的选项！");
        return false;
    }

    var data = getFormValue("inputForm");
    data['zyysntzljdwzjtwo'] = $("#zyysntzljdwzjtwo").val();
    data['qtzyczxjszjljdwzjtwo'] = $("#qtzyczxjszjljdwzjtwo").val();
    data['zxzqmjdzxjszjljdwzjtwo'] =$("#zxzqmjdzxjszjljdwzjtwo").val();
    data['zysljsjjljdwzjtwo'] = $("#zysljsjjljdwzjtwo").val();
    data['nsbdgcjjljdwzjtwo'] = $("#nsbdgcjjljdwzjtwo").val();
    data['tljszxjjljdwzjtwo'] = $("#tljszxjjljdwzjtwo").val();
    data['mhfzjjljdwzjtwo'] = $("#mhfzjjljdwzjtwo").val();
    data['gjzdslgcjsjjljdwzjtwo'] = $("#gjzdslgcjsjjljdwzjtwo").val();
    data['dzxskymhqfcjjljdwzjtwo'] = $("#dzxskymhqfcjjljdwzjtwo").val();
    data['dzxskymhqfcjyjjljdwzjtwo'] = $("#dzxskymhqfcjyjjljdwzjtwo").val();
    data['glgkjszxjjljdwzjtwo'] = $("#glgkjszxjjljdwzjtwo").val();
    data['shengjiysntzljdwzjtwo'] = $("#shengjiysntzljdwzjtwo").val();
    data['shijiysntzljdwzjtwo'] = $("#shijiysntzljdwzjtwo").val();
    data['xianjiysntzljdwzjtwo'] = $("#xianjiysntzljdwzjtwo").val();
    data['shengjiczzjljdwzjtwo'] = $("#shengjiczzjljdwzjtwo").val();
    data['shijiczzjljdwzjtwo'] = $("#shijiczzjljdwzjtwo").val();
    data['xianjiczzjljdwzjtwo'] = $("#xianjiczzjljdwzjtwo").val();
    data['dfzxjsjjljdwzjtwo'] = $("#dfzxjsjjljdwzjtwo").val();
    data['qyzytzljdwzjtwo'] = $("#qyzytzljdwzjtwo").val();
    data['yhdkljdwzjtwo'] = $("#yhdkljdwzjtwo").val();
    data['lywzljdwzjtwo'] = $("#lywzljdwzjtwo").val();
    data['zjqdddljdwzjtwo'] = $("#zjqdddljdwzjtwo").val();
    data['qtzjljdwzjtwo'] = $("#qtzjljdwzjtwo").val();
    
    data['zyysntzjzbbgljwcjj'] = $("#zyysntzjzbbgljwcjj").val();
    data['qtzyczxjszjjzbbgljwcjj'] = $("#qtzyczxjszjjzbbgljwcjj").val();
    data['zxzqmjjszjjzbbgljwcjj'] = $("#zxzqmjjszjjzbbgljwcjj").val();
    data['zysljszjjzbbgljwcjj'] = $("#zysljszjjzbbgljwcjj").val(); 
    data['nsbdgczjjzbbgljwcjj'] = $("#nsbdgczjjzbbgljwcjj").val();
    data['tljszxzjjzbbgljwcjj'] = $("#tljszxzjjzbbgljwcjj").val();
    data['mhfzzjjzbbgljwcjj'] = $("#mhfzzjjzbbgljwcjj").val();
    data['gjzdslgcjszjjzbbgljwcjj'] = $("#gjzdslgcjszjjzbbgljwcjj").val();
    data['dzxskymhqfczjjzbbgljwcjj'] = $("#dzxskymhqfczjjzbbgljwcjj").val();
    data['dzxskymhqfcjyzjjzbbgljwcjj'] = $("#dzxskymhqfcjyzjjzbbgljwcjj").val(); 
    data['glgkjszjjzbbgljwcjj'] = $("#glgkjszjjzbbgljwcjj").val();
    data['sjysntzjzbbgljwcjj'] = $("#sjysntzjzbbgljwcjj").val();
    data['cityjysntzjzbbgljwcjj'] = $("#cityjysntzjzbbgljwcjj").val();
    data['xjysntzjzbbgljwcjj'] = $("#xjysntzjzbbgljwcjj").val();
    data['sjczzjjzbbgljwcjj'] = $("#sjczzjjzbbgljwcjj").val();
    data['cityjczzjjzbbgljwcjj'] = $("#cityjczzjjzbbgljwcjj").val(); 
    data['xjczzjjzbbgljwcjj'] = $("#xjczzjjzbbgljwcjj").val();
    data['dfzxjszjjzbbgljwcjj'] = $("#dfzxjszjjzbbgljwcjj").val();
    data['qyzytzjzbbgljwcjj'] = $("#qyzytzjzbbgljwcjj").val();
    data['yhdkjzbbgljwcjj'] = $("#yhdkjzbbgljwcjj").val();
    data['lywzjzbbgljwcjj'] = $("#lywzjzbbgljwcjj").val();
    data['zjqdddjzbbgljwcjj'] = $("#zjqdddjzbbgljwcjj").val(); 
    data['qtzjjzbbgljwcjj'] = $("#qtzjjzbbgljwcjj").val();
    
    data['zyysntzljzfzj'] = $("#zyysntzljzfzj").val();
    data['qtzyczxjszjljzfzj'] = $("#qtzyczxjszjljzfzj").val();
    data['zxzqmjdzxjszjljzfzj'] = $("#zxzqmjdzxjszjljzfzj").val();
    data['zysljsjjljzfzj'] = $("#zysljsjjljzfzj").val();
    data['nsbdgcjjljzfzj'] = $("#nsbdgcjjljzfzj").val();
    data['tljszxjjljzfzj'] = $("#tljszxjjljzfzj").val();
    data['mhfzjjljzfzj'] = $("#mhfzjjljzfzj").val();
    data['gjzdslgcjsjjljzfzj'] = $("#gjzdslgcjsjjljzfzj").val();
    data['dzxskymhqfcjjljzfzj'] = $("#dzxskymhqfcjjljzfzj").val();
    data['dzxskymhqfcjyjjljzfzj'] = $("#dzxskymhqfcjyjjljzfzj").val();
    data['glgkjszxjjljzfzj'] = $("#glgkjszxjjljzfzj").val();
    data['shengjiysntzljzfzj'] = $("#shengjiysntzljzfzj").val();
    data['shijiysntzljzfzj'] = $("#shijiysntzljzfzj").val();
    data['xianjiysntzljzfzj'] = $("#xianjiysntzljzfzj").val();
    data['shengjiczzjljzfzj'] = $("#shengjiczzjljzfzj").val();
    data['shijiczzjljzfzj'] = $("#shijiczzjljzfzj").val();
    data['xianjiczzjljzfzj'] = $("#xianjiczzjljzfzj").val();
    data['dfzxjsjjljzfzj'] = $("#dfzxjsjjljzfzj").val();
    data['qyzytzljzfzj'] = $("#qyzytzljzfzj").val();
    data['yhdkljzfzj'] = $("#yhdkljzfzj").val();
    data['lywzljzfzj'] = $("#lywzljzfzj").val();
    data['zjqdddljzfzj'] = $("#zjqdddljzfzj").val();
    data['qtzjljzfzj'] = $("#qtzjljzfzj").val();
    $.post(ctx + "/task/cInsBusinessXmjbxxTaskRelation/saveTaskFeedback",data,function(msg){
        if(msg.success){
            showTipCur(msg.success);
            if (typeof(callback) === "function"){
                callback();
            }
            return true;
        } else if (!msg.success) {
            top.layer.alert(msg.msg);
            return false;
        } else {
            showTipCur("保存信息失败！");
            return false;
        }
    });
    return true;
}

function bindTabSwitchEven(){
    $(".tab").each(function () {
        $(this).bind("click", function () {
            // 样式调整
            if (!$(this).hasClass("tab_cur")) {
                $(this).addClass("tab_cur");
            }
            $(this).siblings("li.tab").each(function () {
                if ($(this).hasClass("tab_cur")) {
                    $(this).removeClass("tab_cur");
                }
            });

            // 内容切换
            var liName = $(this).attr("name");
            if ("tab_1" == liName) {
                $("#tab_1").show();
                $("#tab_2").hide();
                $("#tab_3").hide();
            } else if ("tab_2" == liName) {
                $("#tab_1").hide();
                $("#tab_2").show();
                $("#tab_3").hide();
            } else if ("tab_3" == liName) {
                $("#tab_1").hide();
                $("#tab_2").hide();
                $("#tab_3").show();
            }

        })
    });
}