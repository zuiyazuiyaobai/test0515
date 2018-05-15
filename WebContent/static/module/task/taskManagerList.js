$(document).ready(function () {
    laydate.render({
        elem: '#startDate', //目标元素。由于laydate.js封装了一个轻量级的选择器引擎，因此elem还允许你传入class、tag但必须按照这种方式 '#id .class'
        range: true,
        change: function (value, date, endDate) {
            $("#startDateStart").val(date.year + '-' + date.month + '-' + date.date);
            $("#startDateEnd").val(endDate.year + '-' + endDate.month + '-' + endDate.date);
        },
        done: function (value) {
            //点击清空时，清除隐藏域的值
            if (null == value || '' == value) {
                $("#startDate").val("");
                $("#startDateStart").val("");
                $("#startDateEnd").val("");
            }
        }
    });
    laydate.render({
        elem: '#endDate', //目标元素。由于laydate.js封装了一个轻量级的选择器引擎，因此elem还允许你传入class、tag但必须按照这种方式 '#id .class'
        range: true,
        change: function (value, date, endDate) {
            $("#endDateStart").val(date.year + '-' + date.month + '-' + date.date);
            $("#endDateEnd").val(endDate.year + '-' + endDate.month + '-' + endDate.date);
        },
        done: function (value) {
            //点击清空时，清除隐藏域的值
            if (null == value || '' == value) {
                $("#endDate").val("");
                $("#endDateStart").val("");
                $("#endDateEnd").val("");
            }
        }
    });
});

//打开添加页面
function openAddSchedulerTaskView() {
    var target = null;
    var height = document.documentElement.clientHeight;
    if (height > 600) {
        height = 600;
    }

    top.layer.open({
        type: 2,
        area: ['800px', height + 'px'],
        title: '新增调度任务',
        maxmin: true, //开启最大化最小化按钮
        content: ctx + '/task/schedulerTask/form?tab=1',
        btn: ['保存并下一步', '关闭'],
        yes: function (index, layero) {//保存当前 tab 并关闭弹窗
            var body = top.layer.getChildFrame('body', index);
            var iframeWin = layero.find('iframe')[0]; //得到iframe页的窗口对象，执行iframe页的方法：iframeWin.method();
            var inputForm = body.find('#inputForm');
            var top_iframe;
            if (target) {
                top_iframe = target;//如果指定了iframe，则在改frame中跳转
            } else {
                top_iframe = top.getActiveTab().attr("name");//获取当前active的tab的iframe
            }
            inputForm.attr("target", top_iframe);//表单提交成功后，从服务器返回的url在当前tab中展示

            iframeWin.contentWindow.saveAndNext(function(){
                showTipCur("保存成功！");
                setTimeout(function () {
                    top.layer.close(index)
                }, 100);
                setTimeout(function () {
                    sortOrRefresh();
                }, 500);
            });
            return false;
        },
        cancel: function (index) {
            //右上角关闭按钮
        },
        success: function (layero, index) {
            var iframeWin = layero.find('iframe')[0];
            iframeWin.contentWindow.setOperateType("add");
        }
    });
}

//打开添加页面
function openEditSchedulerTaskView() {
    var target = null;
    var height = document.documentElement.clientHeight;
    if (height > 600) {
        height = 600;
    }

    var size = $("#contentTable tbody tr td input.i-checks:checked").size();
    if(size == 0 ){
        top.layer.alert('请至少选择一条数据!', {icon: 0, title:'警告'});
        return;
    }

    if(size > 1 ){
        top.layer.alert('只能选择一条数据!', {icon: 0, title:'警告'});
        return;
    }
    var id =  $("#contentTable tbody tr td input.i-checks:checkbox:checked").attr("id");

    top.layer.open({
        type: 2,
        area: ['800px', height + 'px'],
        title: '修改调度任务',
        maxmin: true, //开启最大化最小化按钮
        content: ctx + '/task/schedulerTask/form?tab=1&id=' + id,
        btn: ['保存', '关闭'],
        yes: function (index, layero) {//保存当前 tab 并关闭弹窗
            var body = top.layer.getChildFrame('body', index);
            var iframeWin = layero.find('iframe')[0]; //得到iframe页的窗口对象，执行iframe页的方法：iframeWin.method();
            var inputForm = body.find('#inputForm');
            var top_iframe;
            if (target) {
                top_iframe = target;//如果指定了iframe，则在改frame中跳转
            } else {
                top_iframe = top.getActiveTab().attr("name");//获取当前active的tab的iframe
            }
            inputForm.attr("target", top_iframe);//表单提交成功后，从服务器返回的url在当前tab中展示

            iframeWin.contentWindow.doSubmit(function () {
                showTipCur("保存成功！");
                setTimeout(function () {
                    top.layer.close(index)
                }, 100);
                setTimeout(function () {
                    sortOrRefresh();
                }, 500);
            });
        },
        cancel: function (index) {
        }
    });
}
