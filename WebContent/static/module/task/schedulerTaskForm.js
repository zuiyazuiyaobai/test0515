var validateForm;
var operateType = "";

function saveAndNext(func){
    var curTabName = getCurTabName();
    var $firstBtn = $(self.frameElement).parent().siblings("div.layui-layer-btn").find("a.layui-layer-btn0");
    if("tab_1" == curTabName && "保存并下一步" == $firstBtn.text()) {
        if (validateForm.form()) {//校验输入
            saveSchedulerTask(function(){
                switchTab("tab_2");
                $firstBtn.text("保存");
            });
        }
    }else if("tab_1" == curTabName && "保存" == $firstBtn.text()) {
        if (validateForm.form()) {//校验输入
            func();
        }
    }else if("tab_2" == curTabName) {
        if(typeof func === 'function'){
            func();
        }
    }
    return false;
}

function doSubmit(func) {//回调函数，在编辑和保存动作时，供openDialog调用提交表单。
    var curTabName = getCurTabName();
    if("tab_1" == curTabName) {
        if (validateForm.form()) {//校验输入
            saveSchedulerTask(function(){
                if (typeof func === 'function') {
                    func();
                }
            });
        }
    }else if("tab_2" == curTabName) {
        if(typeof func === 'function'){
            func();
        }
    }
}

function setOperateType(type) {
    operateType = type;
    if("view" == type){
        $("#operate").remove();
        $("#schedulerTask").attr("disabled", true);
    }
}

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

    $('#contentTable thead tr th input.i-checks').on('ifChecked', function(event){ //ifCreated 事件应该在插件初始化之前绑定
        $('#contentTable tbody tr td input.i-checks').iCheck('check');
    });

    $('#contentTable thead tr th input.i-checks').on('ifUnchecked', function(event){ //ifCreated 事件应该在插件初始化之前绑定
        $('#contentTable tbody tr td input.i-checks').iCheck('uncheck');
    });

    // 初始化日期组件
    laydate.render({
        elem: '#startDate'
    });
    laydate.render({
        elem: '#endDate'
    });

    bindTabSwitchEven();

    if (null != tab && '' != tab && tab != '1') {
        $("li[name='tab_" + tab + "']").each(function () {
            $(this).click()
        });
    }
});

function txxm() {
    var type = $("#type").val();
    var taskId = $("#id").val();
    if(taskId == null || '' == taskId) {
        console.info("TODO the taskId is test data ...");
        taskId = "testId";
    }

    top.layer.open({
        type: 2,
        area: ['800px', '500px'],
        title: '从本级滚动计划库挑选项目',
        maxmin: true, //开启最大化最小化按钮
        // content: ctx + '/xmjbxx/xmjbxx/selectSchedulerTaskXmjbxxForm?taskId=' + taskId + '&originType=' + type,
        content: ctx + '/xmjbxx/xmjbxx/selectSchedulerTaskXmjbxxForm?taskId=' + taskId,
        btn: ['确定', '关闭'],
        yes: function (index, layero) {
            var body = top.layer.getChildFrame('body', index);
            var iframeWin = layero.find('iframe')[0]; //得到iframe页的窗口对象，执行iframe页的方法：iframeWin.method();
            var inputForm = body.find('#inputForm');
            var top_iframe;
            top_iframe = top.getActiveTab().attr("name");//获取当前active的tab的iframe
            inputForm.attr("target", top_iframe);//表单提交成功后，从服务器返回的url在当前tab中展示

            iframeWin.contentWindow.doSubmit(function () {
                top.layer.close(index);
                // sortOrRefresh();
                window.location.href = ctx + "/task/schedulerTask/form?id=" + taskId + "&tab=2";
            });
        },
        cancel: function (index) {
        }
    });
}

function deleteSelect() {
    var str = "";
    var ids = "";
    $("#contentTable tbody tr td input.i-checks:checkbox").each(function(){
        if(true == $(this).is(':checked')){
            str+=$(this).attr("id")+",";
        }
    });
    if(str.substr(str.length-1)== ','){
        ids = str.substr(0,str.length-1);
    }
    if(ids == ""){
        top.layer.alert('请至少选择一条数据!', {icon: 0, title:'警告'});
        return;
    }
    top.layer.confirm('确认要彻底删除数据吗?', {icon: 3, title:'系统提示'}, function(index){
        top.layer.close(index);

        $.post(ctx + "/task/cInsBusinessXmjbxxTaskRelation/deleteSelect",{ids: ids},function(result){
            if(result.success){
                $("#contentTable tbody tr td input.i-checks:checkbox").each(function(){
                    if(true == $(this).is(':checked')){
                        $(this).parent().parent().parent().remove();
                    }
                });

                showTipCur(result.msg);
                return false;
            }else if(!result.success){
                showTipCur(result.msg);
                return false;
            }else{
                showTipCur("调度任务项目删除失败！");
                return false;
            }
        })


    });
}

// 获取当前 tab 的名称
function getCurTabName(){
    return $("li.tab_cur").attr("name");
}

function saveSchedulerTask(func){
    var data = getFormValue("inputForm");
    $.post(ctx + "/task/schedulerTask/saveSchedulerTask", data, function(result){
        if(result.success){
            $("#id").val(result.body.id);
            showTipCur(result.msg);
            if(typeof func === 'function'){
                func();
            }
            return false;
        }else if(!result.success){
            showTipCur(result.msg);
            return false;
        }else{
            showTipCur("调度任务保存失败！");
            return false;
        }
    })
}

function switchTab(tabName){
    $("li[name='" + tabName + "']").click();
}

function bindTabSwitchEven(){
    $(".tab").each(function () {
        $(this).bind("click", function () {
            // 检查调度任务基本信息是否保存了
            var id = $("#id").val();
            if(id == null || id == ""){
                saveAndNext();
                return;
            }

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
                // $("#taskOriginSpan").hide();
            } else if ("tab_2" == liName) {
                $("#tab_1").hide();
                $("#tab_2").show();
                // $("#taskOriginSpan").show();
            }

        })
    });
}