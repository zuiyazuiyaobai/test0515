// 打开项目基本信息查看窗口
function openXmjbxxView(title,url,width,height){
    if(navigator.userAgent.match(/(iPhone|iPod|Android|ios)/i)){//如果是移动端，就使用自适应大小弹窗
        width='auto';
        height='auto';
    }else{//如果是PC端，根据用户设置的width和height显示。

    }

    //限制弹窗高度不高于浏览器高度
    var heightValue = 500;
    if(null == height || "" == height){
        heightValue = 500;
    }else if(height.indexOf("px") > -1){
        heightValue = height.substr(0, height.indexOf("px"));
    }else{
        heightValue = height;
    }
    var clientHeight = document.documentElement.clientHeight;
    if(clientHeight < heightValue) {
        height = clientHeight + "px";
    }

    top.layer.open({
        type: 2,
        area: [width, height],
        title: title,
        maxmin: true, //开启最大化最小化按钮
        content: url ,
        btn: ['关闭'],
        cancel: function(index){
        },
        success: function(layero, index) {
            var iframeWin = layero.find('iframe')[0];
            iframeWin.contentWindow.setOperateType("view");
        }
    });
}

// 打开调度任务查看窗口
function openSchedulerTaskView(id) {
    var height = document.documentElement.clientHeight;
    if (height > 600) {
        height = 600;
    }

    top.layer.open({
        type: 2,
        area: ['800px', height + 'px'],
        title: '查看调度任务',
        maxmin: true, //开启最大化最小化按钮
        content: ctx + '/task/schedulerTask/form?tab=1&id=' + id,
        btn: ['关闭'],
        cancel: function(index){
        },
        success: function (layero, index) {
            var iframeWin = layero.find('iframe')[0];
            iframeWin.contentWindow.setOperateType("view");
        }
    });
}
function openfkqk(id) {
    var height = document.documentElement.clientHeight;
    if (height > 600) {
        height = 600;
    }

    top.layer.open({
        type: 2,
        area: ['800px', height + 'px'],
        title: '查看调度反馈情况详情',
        maxmin: true, //开启最大化最小化按钮
        content: ctx + '/task/cInsBusinessXmjbxxTaskRelation/fkqkssqk?ssqkid=' + id,
        btn: ['关闭'],
        cancel: function(index){
        },
        success: function (layero, index) {
            var iframeWin = layero.find('iframe')[0];
            iframeWin.contentWindow.setOperateType("view");
        }
    });
}

// 打开项目基本信息查看窗口
function openxmxyfk(title,url,width,height){
    if(navigator.userAgent.match(/(iPhone|iPod|Android|ios)/i)){//如果是移动端，就使用自适应大小弹窗
        width='auto';
        height='auto';
    }else{//如果是PC端，根据用户设置的width和height显示。

    }

    //限制弹窗高度不高于浏览器高度
    var heightValue = 500;
    if(null == height || "" == height){
        heightValue = 500;
    }else if(height.indexOf("px") > -1){
        heightValue = height.substr(0, height.indexOf("px"));
    }else{
        heightValue = height;
    }
    var clientHeight = document.documentElement.clientHeight;
    if(clientHeight < heightValue) {
        height = clientHeight + "px";
    }

    top.layer.open({
        type: 2,
        area: [width, height],
        title: title,
        maxmin: true, //开启最大化最小化按钮
        content: url ,
        btn: ['关闭'],
        cancel: function(index){
        },
        success: function(layero, index) {
            var iframeWin = layero.find('iframe')[0];
        }
    });
}		

