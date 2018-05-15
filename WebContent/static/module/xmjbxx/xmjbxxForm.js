var validateForm;
var validateSsqkForm;
var validateQtxxForm;
var validatePhoneInputForm;
var lhjsgmOptions = null;
var step = 1;//1.项目基本信息 2.投资情况 3.前期工作 ...
var operateType = null;
function setOperateType(type){
    operateType = type;

    if("view" == operateType){
        $("#selectContact").hide();
        $("#xmjbxxForm").attr("disabled",true);
    }
}

// 保存（并关闭弹窗）
function doSubmit(func) {//回调函数，在编辑和保存动作时，供openDialog调用提交表单。
	
	var curFormId = getCurInputForm();
    if(!checkSubmit(curFormId)){
        return false;
    }
    if("inputForm" == curFormId){
        return submitXmjbxxForm(func);
    }else if("inputForm2" == curFormId) {
        return submitTzqkForm(func);
    }else if("inputForm3" == curFormId) {
        return submitQqgz(func);//前期工作
    }else if("inputForm7" == curFormId) {
        return submitPPP(func);//PPP项目
    }else if("inputForm4" == curFormId) {
        return submitQtxx(func);//其他信息
    }else if("inputForm5" == curFormId) {
        return submitSsqk(func);//实施情况
    }else if("inputForm6" == curFormId) {
        return submitZdxmk(func);
    }
    return true;
}

//导出
function doExport(){
    setTimeout(function(){
        $.jBox.tip('导出项目信息，待开发', 'info', {opacity:0,
            timeout: 2000});
    }, 500);
}

//保存并下一步
function saveAndNext(func){
	
    var curFormId = getCurInputForm();
    if(!checkSubmit(curFormId)){
        return false;
    }

    if("inputForm" == curFormId){
        submitXmjbxxForm(nexStep);
    }else if("inputForm2" == curFormId) {
        submitTzqkForm(nexStep);//投资情况
    }else if("inputForm3" == curFormId) {
        submitQqgz(nexStep);//前期工作
    }else if("inputForm7" == curFormId) {
        submitPPP(nexStep);//PPP项目
    }else if("inputForm4" == curFormId) {
        submitQtxx(nexStep);//其他信息
    }else if("inputForm5" == curFormId) {
        var success = submitSsqk(nexStep);//实施情况
        if(success && typeof func === 'function'){
            func();
        }
    }
}

$(document).ready(function () {
	
 	//给滚动计划 编制区 核准确认 页面赋值;
	var aa  =$("#ycljxdtz1").val() + $("#zxljxdtz1").val();
    $("#ljxdtz1").val(aa.split('.')[0]);
    var val2=$("#ycljxdtz2").val()+ $("#zxljxdtz2").val();
    $("#ljxdtz2").val(val2.split('.')[0]);
    var val3=$("#ycljxdtz3").val()+ $("#zxljxdtz3").val();
    $("#ljxdtz3").val(val3.split('.')[0]);
	//zxzqmjdzxjszjljdwzj:$("#").val(),
    var val4=$("#ycljxdtz4").val()+ $("#zxljxdtz4").val();
	$("#ljxdtz4").val(val4.split('.')[0]);
	var val5=$("#ycljxdtz5").val()+ $("#zxljxdtz5").val();
	$("#ljxdtz5").val(val5.split('.')[0]);
	var val6=$("#ycljxdtz6").val()+ $("#zxljxdtz6").val();
	$("#ljxdtz6").val(val6.split('.')[0]);
	var val7=$("#ycljxdtz7").val()+ $("#zxljxdtz7").val();
	$("#ljxdtz7").val(val7.split('.')[0]);
	var val8=$("#ycljxdtz8").val()+ $("#zxljxdtz8").val();
	$("#ljxdtz8").val(val8.split('.')[0]);
	var val9=$("#ycljxdtz9").val()+ $("#zxljxdtz9").val();
	$("#ljxdtz9").val(val9.split('.')[0]);
	var val10=$("#ycljxdtz10").val()+ $("#zxljxdtz10").val();
	$("#ljxdtz10").val(val10.split('.')[0]);
	var val11=$("#ycljxdtz11").val()+ $("#zxljxdtz11").val();
	$("#ljxdtz11").val(val11.split('.')[0]);
	var val12=$("#ycljxdtz12").val()+ $("#zxljxdtz12").val();
	$("#ljxdtz12").val(val12.split('.')[0]);
	var val13=$("#ycljxdtz13").val()+ $("#zxljxdtz13").val();
	$("#ljxdtz13").val(val13.split('.')[0]);
	
	var val14=$("#ycljxdtz14").val()+ $("#zxljxdtz14").val();
	$("#ljxdtz14").val(val14.split('.')[0]);
	var val15=$("#ycljxdtz15").val()+ $("#zxljxdtz15").val();
	$("#ljxdtz15").val(val15.split('.')[0]);
	var val16=$("#ycljxdtz16").val();+ $("#zxljxdtz16").val();
	$("#ljxdtz16").val(val16.split('.')[0]);
	var val17=$("#ycljxdtz17").val()+ $("#zxljxdtz17").val();
	$("#ljxdtz17").val(val17.split('.')[0]);
	var val18=$("#ycljxdtz18").val()+ $("#zxljxdtz18").val();
	$("#ljxdtz18").val(val18.split('.')[0]);
	var val19=$("#ycljxdtz19").val()+ $("#zxljxdtz19").val();
	$("#ljxdtz19").val(val19.split('.')[0]);
	var val20=$("#ycljxdtz20").val()+ $("#zxljxdtz20").val();
	$("#ljxdtz20").val(val20.split('.')[0]);
	var val21=$("#ycljxdtz21").val()+ $("#zxljxdtz21").val();
	$("#ljxdtz21").val(val21.split('.')[0]);
	var val22=$("#ycljxdtz22").val()+ $("#zxljxdtz22").val();
	$("#ljxdtz22").val(val22.split('.')[0]);
	

    $("input[type='number']").each(function () {
        $(this).attr("maxlength", 12);
    });
    

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
    

    validateSsqkForm = $("#inputForm5").validate({
        errorPlacement: function (error, element) {
            $("#messageBox").text("输入有误，请先更正。");
            if (element.is(":checkbox") || element.is(":radio") || element.parent().is(".input-append")) {
                error.appendTo(element.parent().parent());
            } else {
                error.insertAfter(element);
            }
        }
    });


    validateQtxxForm = $("#inputForm4").validate({
        errorPlacement: function (error, element) {
            $("#messageBox").text("输入有误，请先更正。");
            if (element.is(":checkbox") || element.is(":radio") || element.parent().is(".input-append")) {
                error.appendTo(element.parent().parent());
            } else {
                error.insertAfter(element);
            }
        }
    });


    //是否申请专项建设基金
    $("#sfsqzxjsjj").bind("change", function () {
        var sfValue = $("#sfsqzxjsjj").val();
        $("td[name='sfsqzxjsjjLine']").each(function(){
            if('1' == sfValue){
                $(this).show();
            }else{
                $(this).hide();
            }
        });

        $("tr[name='sfsqzxjsjjLine']").each(function(){
            if('1' == sfValue){
                $(this).show();
            }else{
                $(this).hide();
            }
        });

        //专项证券信息 控制是否显示
        if('1' == sfValue){
            $("#qtxx_zxzqxx").show();
        }else{
            $("#qtxx_zxzqxx").hide();
        }
    });
    $("#sfsqzxjsjj").change();


    //是否PPP切换可见项目
    $("#sfppp").bind("change", function () {
        var sfppp = $("#sfppp option:selected").val();
        if (sfppp == "0") {//选择否就清空并隐藏
            $("#ycppp").hide();
            // $("#pppzl").val("");
            // $("#zfcyfs").val("");
            // $("#ncypppczms").val("");
            // $("#xmssjgmc").val("");
            // $("#ssjgxz").val("");
            // $("#jhssnd").val("");
        } else {
            $("#ycppp").show();
        }
    });

    
    //当 符合重大战略 的值为 一带一路 时，其他信息 显示一带一路的表单
    $("#fhzdzn").bind("change", function () {
        if('一带一路' == $(this).find("option:selected").text()){
            $("#qtxx_ydyl").show();
        }else{
            $("#qtxx_ydyl").hide();
        }
    });
    $("#fhzdzn").change();

   
    //PPP信息 是否组件项目公司 控制部分表单信息是否可见
    $("#sfzjxmgs").bind("change", function () {
        var value = $("#sfzjxmgs").val();
        if('1' == value){
            $("#zjgs1").show();
            $("#zjgs2").show();
        }else{
            $("#zjgs1").hide();
            $("#zjgs2").hide();
        }
    });
    $("#sfzjxmgs").change();

    $("#gb").bind("change", function () {
        var gb = $(this).val();
        if(null != gb && '' != gb && "1" != gb){
            $("#jsddId").parent().parent().hide();
        }else{
            $("#jsddId").parent().parent().show();
        }
    });
    $("#gb").change();

    for (var j = 1; j < 15; j++) {
        $(".countCol_" + j).bind("change", function () {
            //自动求和
            var countParent = $(this).attr("countParent");
            var total = 0;
            var $cols = $(".countCol_" + countParent.split("_")[1]);
            for (var i = 0; i < $cols.length; i++) {
                var val = $($cols[i]).val();
                total += (val == null ? 0 : val / 1);
            }
            $("#" + countParent).val(total);

            //资金需求水平求和
            var colNum = countParent.split("_")[1];
            if("10" == colNum || "11" == colNum || "12" == colNum || "13" == colNum){
                var $row10 = $($(this).parent().parent().find("input[countParent='sumCol_10']")[0]);
                var $row11 = $($(this).parent().parent().find("input[countParent='sumCol_11']")[0]);
                var $row12 = $($(this).parent().parent().find("input[countParent='sumCol_12']")[0]);
                var $row13 = $($(this).parent().parent().find("input[countParent='sumCol_13']")[0]);
                var rowCount = ($row10.val() == null ? 0 : $row10.val() / 1) + ($row11.val() == null ? 0 : $row11.val() / 1) +
                    ($row12.val() == null ? 0 : $row12.val() / 1) + ($row13.val() == null ? 0 : $row13.val() / 1);
                $($(this).parent().parent().find("input[countParent='sumCol_9']")[0]).val(rowCount).change();
            }

            //子类求和
            var subCountParent = $(this).attr("subCountParent");
            if(null != subCountParent && "" != subCountParent){
                var subCount = 0;
                var $subCountCols = $("input[subCountParent='" + subCountParent + "']");
                for(var i = 0; i < $subCountCols.length; i++) {
                    subCount += ($($subCountCols[i]).val() == null ? 0 : $($subCountCols[i]).val() / 1);
                }
                $("input[subSum='" + subCountParent + "']").val(subCount);
            }
        });
        
        //加载完就出发触发一次
        $(".countCol_" + j).change();
    }


    // tab 切换样式更换
    $("#test").bind("click", function (e) {
        if("view" == operateType){//如果是通过添加的方式来打开弹窗
        	
            switchTab(e);//切换到目标tab
        } else {
        	
            if(doSubmit()){//提交当前表单成功
            	
                switchTab(e);//切换到目标tab
            }
        }
    });

    //事件选择器 laydate 声明
    initLayDates(['qqgzs_0_pfsj', 'qqgzs_1_pfsj', 'qqgzs_2_pfsj', 'qqgzs_3_pfsj', 'qqgzs_4_pfsj', 'qqgzs_5_pfsj'
        , 'qqgzs_6_pfsj', 'qqgzs_7_pfsj', 'qqgzs_8_pfsj', 'qqgzs_9_pfsj', 'qqgzs_10_pfsj', 'qqgzs_11_pfsj', 'qqgzs_12_pfsj', 'qqgzs_13_pfsj'
        , 'qqgzs_14_pfsj', 'qqgzs_15_pfsj']);

    initLayDates(['fapzsj','xmgszjrq']);

    laydate.render({
        elem: '#starttimen', //目标元素。由于laydate.js封装了一个轻量级的选择器引擎，因此elem还允许你传入class、tag但必须按照这种方式 '#id .class'
        type: 'year',
        done: function(value){
            var startTimeYear = value;
            if(null == startTimeYear || '' == startTimeYear) {
                $("#xmscjd").val("");
                return;
            }

            var curYear = (new Date()).getFullYear();
            var xmscjd = "";
            if (curYear == startTimeYear) {
                xmscjd = "开工阶段";
            } else if (startTimeYear - curYear == 1) {
                xmscjd = "储备阶段";
            } else if (startTimeYear - curYear > 1) {
                xmscjd = "谋划阶段";
            }
            $("#xmscjd").val(xmscjd);
        }
    });
    laydate.render({
        elem: '#endtime', //目标元素。由于laydate.js封装了一个轻量级的选择器引擎，因此elem还允许你传入class、tag但必须按照这种方式 '#id .class'
        type: 'year' //响应事件。如果没有传入event，则按照默认的click
    });
    laydate.render({
        elem: '#jhssnd', //目标元素。由于laydate.js封装了一个轻量级的选择器引擎，因此elem还允许你传入class、tag但必须按照这种方式 '#id .class'
        type: 'year' //响应事件。如果没有传入event，则按照默认的click
    });


    // 数据初始化
    getLhjsgmOptions();


    if($("#dfzbsf").val() == null || $("#dfzbsf").val() == ''){
        $("#dfzbsf").val("无");
    }

    if("add" != operateType){
        //$("li[name='fen6']").hide();
        //$("#fen6").hide();
    }
    
    //是否申报5818项目

    $("#sfsbsbib").bind("change", function () {
 
        var sfValue = $("#sfsbsbib").val();
        if('1' == sfValue){
        	$("#sfsbsbib_div").show();
        }else{
        	$("#sfsbsbib_div").hide();
        }
    });
    $("#sfsbsbib").change();
    //是否是省服务业重大项目
    $("#sfsfwyzdxm").bind("change", function () {

        var sfValue = $("#sfsfwyzdxm").val();
        if('1' == sfValue){
        	$("#fwyssly_div").show();
        }else{
        	$("#fwyssly_div").hide();
        }
    });
    $("#sfsfwyzdxm").change();
    //是否是是申报为2017年省重点项目
   
    $("#sfszdold").bind("change", function () {

        var sfValue = $("#sfszdold").val();
        if('1' == sfValue){
            $("#sfszdold_div").show();
        }else{
            $("#sfszdold_div").hide();
        }
    });
    $("#sfszdold").change();
    
    //判断投资情况填写的总投资大于了基本信息中的总投资的情况
    var jbxxztz = $("#jbxxztz").val();
    var sumCol_1 = $("#sumCol_1").val();
    if(sumCol_1 > jbxxztz){
    	jAlert("请注意：投资情况填写的总投资额大于基本信息中的总投资额，请及时确认！","投资项目在线管理系统");
    }
    //初始化其他信息攻坚产业
    cshgjcy();
    //初始化健康养老示范项目
    cshjkly();
    
   /*//初始化企业信用
    qyxycsh();
    
    //这个是用来审核区查看信用的
	var xyflag=$("#xyflag").val();
	if(xyflag==1){
		operateType="view";//为了不引发保存
		$("#qqxy").click();
		$(".qyhidd").hide();
	}*/
});

// 获取项目基本信息数据
var getXmjbxxFormDate = function(){
    var data = getFormValue("inputForm");

    var lhjsgmArr = [];
    var $lhjsgmSelect = $("select[name='lhjsgm']");
    for(var i = 0; i < $lhjsgmSelect.length; i++){
        var type = $($lhjsgmSelect[i]).val();
        var value = $($($lhjsgmSelect[i]).parent().find("input[name='lhjsgmValue']")).val();
        lhjsgmArr[i] = type + ":" + value;
    }
    data.lhjsgm = lhjsgmArr.join(",");

    return data;
};

/**
 * 通过 ID 列表批量初始化日期选择组件
 * @param ids 如：['id1','id2']
 */
function initLayDates(ids) {
    for (var i = 0; i < ids.length; i++) {
        laydate.render({
            elem: '#' + ids[i], //目标元素。由于laydate.js封装了一个轻量级的选择器引擎，因此elem还允许你传入class、tag但必须按照这种方式 '#id .class'
            event: 'focus' //响应事件。如果没有传入event，则按照默认的click
        });
    }
}

//添加量化建设规模
function addLhjsgm() {
    $("#lhjsgmTd").append(getLhjsgmTemplate);
}

//减少量化建设规模
function minusLhjsgm(ag) {
    $($(ag).parent()).remove();
}

//获取随机数
function _getTimeSequence() {
    var date = new Date();
    var year = date.getFullYear();
    var month = date.getMonth() + 1;
    var day = date.getDate();
    var hour = date.getHours();
    var minute = date.getMinutes();
    var second = date.getSeconds();

    var id = "" + year + month + day + hour + minute + second + _getRandomId(4);
    return id;
}

// 生成测试用的随机ID
function _getRandomId(n) {
    var l = 6;
    if (n != null && n > 14 && n < 20) {
        l = n - 14;
    }
    var str = "";
    for (var i = 0; i < l; i++) {
        str += (Math.round(Math.random() * 9));
    }
    return str;
}

// 填充项目基本信息测试数据
function ceshi() {
    var tttt = _getTimeSequence();
    $("#zdkbmgj").val(tttt);
    $("#spjgptdm").val("jgptdm" + tttt);
    $("#xmmc").val("项目-测试-" + tttt);
    $("#xmlx").val("1");
    $("#jsxz").val("1");
    $("#gb").val("1");
    $("#jsddId").val("xjqh22063e3e4bf88bfc3c0e8d650102");
    $("#jsddName").val("天山区");
    $("#sshyId").val('a17c577091ef49e1a91532a6a0000103');
    $("#sshyName").val("林木育种和育苗");
    // $("#jsddxq").val("1");
    $("#jsxxdz").val(" 测试使用的地址");
    $("#gbhyId").val("afe159bd1b054f2d9e8a3faa67e94051");
    $("#gbhyName").val("农业机械服务");
    $("#sshy").val("1");
    $("#ztz").val("98");
    $("#starttimen").val("2017");
    $("#starttimey").val("1");
    $("#endtime").val("2017");
    $("#zyjsgm").val("测试.建设规模");
    $("#ndzhjsnr").val("测试年度主要建设内容");
    $("#bz").val("测试");
    $("#sfsqzyysnzj").val("1");
    $("#rcjgzjzrdw").val("日常监管直接责任单位");
    $("#rcjgzrdwjgzrr").val("钟超");
    $("#rcjgzjzrdwlxdh").val("13411112222");
    $("#xmfrdw").val("测试项目法人单位");
    $("#fhcyzc").val("农业");
    $("#fhgh").val("测试符合规划");
    $("#fhzdzn").val("3");
    $("#fhzftzfx").val("1");
    $("#zrname").val("张三");
    $("#zrphone").val("13475684541");
    $("#zrcall").val("0217-85432759");
    $("#zremail").val("123456789@qq.com");
    $("#zrwxzh").val("13475684541");
    $("#lxnameone").val("李四");
    $("#lxphoneone").val("15679423451");
    $("#lxcallone").val("0217-85432759");
    $("#lxemailone").val("456789123@qq.com");
    $("#lxwxzhone").val("15679423451");
    $("#lxnametwo").val("王五");
    $("#lxphonetwo").val("13817090149");
    $("#lxcalltwo").val("0217-85432758");
    $("#lxemailtwo").val("13817090201@163.com");
    $("#lxwxzhtwo").val("13817090210");
    $("#shfzbsone").val("测试审核辅助标志1");
    $("#shfzbstwo").val("测试审核辅助标志2");
    $("#shfzbsthree").val("测试审核辅助标志3");
    $("#xmpx").val("100");


    $("#sfsqzxjsjj").val("1");
    $("#fhghId").val("6811c507ee3b4b5bbe954d092e8d4318");
    $("#fhghName").val("深海空间站");
    $("#fhzftzfxId").val("84d1f14296af4b0988e52bce1ec0156e");
    $("#fhzftzfxName").val("国家一类口岸查验设施建设");

    //ppp项目
    //$("#sfppp").val("1");
    $("#pppzl").val("1");
    $("#zfcyfs").val("1");
    $("#ncypppczms").val("1");
    $("#xmssjgmc").val("测试项目实施机构名称");
    $("#ssjgxz").val("1");
    $("#jhssnd").val("2017");
    //其他信息
    $("#qtdw").val("测试牵头单位");
    $("#yzdw").val("测试业主单位");
    $("#jsdw").val("测试建设单位");
    $("#lx").val("1");
    $("#tjqk").val("测试推进情况");

    //完成
    $("#shbm").val("1");
    $("#ks").val("1");

    //量化建设规模
    var $lhjsgmSelect = $("select[name='lhjsgm']");
    for(var i = 0; i < $lhjsgmSelect.length; i++){
        var type = $($lhjsgmSelect[i]).val("1001");
        var value = $($($lhjsgmSelect[i]).parent().find("input[name='lhjsgmValue']")).val("33");
    }
}

//填充投资情况测试数据
function fillInTzqk(){
    for(var i = 0; i < 26; i++){
        $('input[name="tzqks['+i+'].ztz"]').each(function(){$(this).val((i+1)*100+1);});
        $('input[name="tzqks['+i+'].zbj"]').each(function(){$(this).val((i+1)*100+2);});
        $('input[name="tzqks['+i+'].ntz[0].je"]').each(function(){$(this).val((i+1)*100+3);});
        $('input[name="tzqks['+i+'].ntz[1].je"]').each(function(){$(this).val((i+1)*100+4);});
        $('input[name="tzqks['+i+'].ntz[2].je"]').each(function(){$(this).val((i+1)*100+5);});
        $('input[name="tzqks['+i+'].bcsqzxjszj"]').each(function(){$(this).val((i+1)*100+6);});
        $('input[name="tzqks['+i+'].ljxdtz"]').each(function(){$(this).val((i+1)*100+7);});
        $('input[name="tzqks['+i+'].ljwctz"]').each(function(){$(this).val((i+1)*100+8);});
        $('input[name="tzqks['+i+'].ljZjxqs"]').each(function(){$(this).val((i+1)*100+9);});
        $('input[name="tzqks['+i+'].zjxqs[0].je"]').each(function(){$(this).val((i+1)*100+10);});
        $('input[name="tzqks['+i+'].zjxqs[1].je"]').each(function(){$(this).val((i+1)*100+11);});
        $('input[name="tzqks['+i+'].zjxqs[2].je"]').each(function(){$(this).val((i+1)*100+12);});
        $('input[name="tzqks['+i+'].zjxqs[3].je"]').each(function(){$(this).val((i+1)*100+13);});
        $('input[name="tzqks['+i+'].qt"]').each(function(){$(this).val((i+1)*100+14);});
    }
}

function search(n, s) {
    $("#searchForm").attr("action", "${ctx}/iim/contact/index");
    $("#searchForm").submit();
    return false;
}

// 获取量化建设规模下拉框选项值，初始化请求
function getLhjsgmOptions(){
	
    if(null == lhjsgmOptions){
        $.post(ctx + "/sys/dict/listData",{type:'lhjsgm'},function(result){
            lhjsgmOptions = result;
            return lhjsgmOptions;
        });
    }else {
        return lhjsgmOptions;
    }
}

//获取量化建设规模的模板
function getLhjsgmTemplate(){
    var options = getLhjsgmOptions();
    var lhjsgmTamplate = '';
    lhjsgmTamplate += ' <div style="margin-top:6px;">';
    lhjsgmTamplate += ' <span style="margin-left:5px;">类别：</span>';
    lhjsgmTamplate += ' <select name="lhjsgm" style="width:350px;" class="form-control required">';
    for(var i = 0; i < options.length; i++) {
        lhjsgmTamplate += ' <option value="' + options[i].value + '">' + options[i].label + '</option>';
    }
    lhjsgmTamplate += ' </select>';
    lhjsgmTamplate += ' <span style="margin-left:15px;">数值：</span>';
    lhjsgmTamplate += ' <span><input name="lhjsgmValue" maxlength="32" class="form-control" required style="width:100px" value=""/></span>';
    lhjsgmTamplate += ' <button type="button" class="btn btn-danger" onclick="minusLhjsgm(this)"><i class="fa fa-minus"></i> 删除</button>';
    lhjsgmTamplate += ' </div>';

    return lhjsgmTamplate;
}

//提交项目基本信息表单信息，成功返回true，失败返回false
function submitXmjbxxForm(callback){
	
    if (!validateForm.form()) {
        layer.alert("存在未填写的选项！");
        return false;
    }

    //校验量化建设规模
    //可为空，但是如果存在多项时，则不能为空
    var $lhjsgmSelect = $("select[name='lhjsgm']");
    if($lhjsgmSelect.length > 1){
        for(var i = 0; i < $lhjsgmSelect.length; i++){
            var type = $($lhjsgmSelect[i]).val();
            var value = $($($lhjsgmSelect[i]).parent().find("input[name='lhjsgmValue']")).val();
            if(null == type || "" == type){
                top.layer.alert("请选择量化建设规模的类别！");
                return false;
            }
            if(null == value || "" == value){
                top.layer.alert("请填写量化规模建设的数值！");
                return false;
            }
        }
    }
    
    
    var data = getXmjbxxFormDate();
    $.post(ctx + "/xmjbxx/xmjbxx/saveXmjbxx",data,function(msg){
        if(msg.success){
            showTipCur("保存项目基本信息成功！");
            $("#id").val(msg.body.id);
            if (typeof(callback) === "function"){
                callback();
                return true;
            }
        }else{
            layer.alert("保存失败！");
            return false;
        }
    });
    return true;
}

//提交项目基本信息表单信息，成功返回true，失败返回false
function submitTzqkForm(callback){
    //校验是否申请专项建设基金
    var sfsqzxjsjj = $("#sfsqzxjsjj").val();
    if(null == sfsqzxjsjj || '' == 1){
        layer.alert("请选择是否申请专项建设基金！");
        return false;
    }

    var data = getFormValue("inputForm2");
    data.id = $("#id").val();
    $.post(ctx + "/xmjbxx/xmjbxx/saveXmjbxxTzqk",data,function(msg){
        if(msg.success){
            showTipCur("保存投资情况成功！");
            if (typeof(callback) === "function"){
                callback();
            }
            return true;
        } else if (!msg.success) {
            showTipCur(msg.msg);
            return false;
        } else {
            showTipCur("保存信息失败！");
            return false;
        }
    });
    return true;
}

//提交 前期工作 表单信息，成功返回true，失败返回false
function submitQqgz(callback){
    var data = getFormValue("inputForm3");
    data.id = $("#id").val();
    $.post(ctx + "/xmjbxx/xmjbxx/saveXmjbxxQqgz",data,function(msg){
        if(msg.success){
            showTipCur("保存前期工作成功！");
            if (typeof(callback) === "function"){
                callback();
            }
            return true;
        } else if (!msg.success) {
            showTipCur(msg.msg);
            return false;
        } else {
            showTipCur("保存信息失败！");
            return false;
        }
    });
    return true;
}

//提交 PPP项目 表单信息，成功返回true，失败返回false
function submitPPP(callback){
	
    //校验是否申请专项建设基金
    var sfppp = $("#sfppp").val();
    if(null == sfppp || '' == sfppp){
        layer.alert("请选择是否PPP！");
        return false;
    }
    
    var data = getFormValue("inputForm7");
    
    if('1' == sfppp){
        if('' == data.pppzl){
            //layer.alert("请选择PPP种类！");
            //return false;
        }
        if('' == data.zfcyfs){
            //layer.alert("请选择政府参与方式！");
            //return false;
        }
        if('' == data.ncypppczms){
            //layer.alert("请选择拟采用PPP操作模式！");
            //return false;
        }
    }

    data.id = $("#id").val();
    $.post(ctx + "/xmjbxx/xmjbxx/saveSfPPP",data,function(msg){
        if(msg.success){
            showTipCur("保存省基建项目信息成功！");
            if (typeof(callback) === "function"){
                callback();
            }
            return true;
        } else if (!msg.success) {
            showTipCur(msg.msg);
            return false;
        } else {
            showTipCur("保存信息失败！");
            return false;
        }
    });
    return true;
}

//提交 其他信息 表单信息，成功返回true，失败返回false
function submitQtxx(callback){
    if (!validateQtxxForm.form()) {
        layer.alert("存在未填写的选项！");
        return false;
    }
    var data = getFormValue("inputForm4");

    data.id = $("#id").val();
    $.post(ctx + "/xmjbxx/xmjbxx/saveXmjbxxQtxx",data,function(msg){
        if(msg.success){
            showTipCur("保存5818项目信息成功！");
            if (typeof(callback) === "function"){
                callback();
            }
            return true;
        } else if (!msg.success) {
            showTipCur(msg.msg);
            return false;
        } else {
            showTipCur("保存信息失败！");
            return false;
        }
    });
    return true;
}

//提交 其他信息 表单信息，成功返回true，失败返回false
function submitSsqk(callback){
    if (!validateSsqkForm.form()) {
        layer.alert("存在未填写的选项！");
        return false;
    } 
    var data = getFormValue("inputForm5");
    var objss=get_ssqkOjbect();
    data.ssqkInfo = JSON.stringify(objss);
    data['xmjbxx.id'] = $("#id").val();
    
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
    $.post(ctx + "/xmjbxx/xmjbxx/saveXmjbxxSsqk",data,function(msg){
        if(msg.success){
            showTipCur("保存实施情况成功！");
            if (typeof(callback) === "function"){
                callback();
            }
            return true;
        } else if (!msg.success) {
            showTipCur(msg.msg);
            return false;
        } else {
            showTipCur("保存信息失败！");
            return false;
        }
    });
    return true;
}
function get_ssqkOjbect(){
	var objess={	
		//截至本报告期累计到位资金
		zyysntzljdwzjtwo:$("#zyysntzljdwzjtwo").val(),
		qtzyczxjszjljdwzjtwo:$("#qtzyczxjszjljdwzjtwo").val(),
		zxzqmjdzxjszjljdwzjtwo:$("#zxzqmjdzxjszjljdwzjtwo").val(),
		zysljsjjljdwzjtwo:$("#zysljsjjljdwzjtwo").val(),
		nsbdgcjjljdwzjtwo:$("#nsbdgcjjljdwzjtwo").val(),
		tljszxjjljdwzjtwo:$("#tljszxjjljdwzjtwo").val(),
		mhfzjjljdwzjtwo:$("#mhfzjjljdwzjtwo").val(),
		gjzdslgcjsjjljdwzjtwo:$("#gjzdslgcjsjjljdwzjtwo").val(),
		dzxskymhqfcjjljdwzjtwo:$("#dzxskymhqfcjjljdwzjtwo").val(),
		dzxskymhqfcjyjjljdwzjtwo:$("#dzxskymhqfcjyjjljdwzjtwo").val(),
		glgkjszxjjljdwzjtwo:$("#glgkjszxjjljdwzjtwo").val(),
		shengjiysntzljdwzjtwo:$("#shengjiysntzljdwzjtwo").val(),
		shijiysntzljdwzjtwo:$("#shijiysntzljdwzjtwo").val(),
		xianjiysntzljdwzjtwo:$("#xianjiysntzljdwzjtwo").val(),
		shengjiczzjljdwzjtwo:$("#shengjiczzjljdwzjtwo").val(),
		shijiczzjljdwzjtwo:$("#shijiczzjljdwzjtwo").val(),
		xianjiczzjljdwzjtwo:$("#xianjiczzjljdwzjtwo").val(),
		dfzxjsjjljdwzjtwo:$("#dfzxjsjjljdwzjtwo").val(),
		qyzytzljdwzjtwo:$("#qyzytzljdwzjtwo").val(),
		yhdkljdwzjtwo:$("#yhdkljdwzjtwo").val(),
		lywzljdwzjtwo:$("#lywzljdwzjtwo").val(),
		zjqdddljdwzjtwo:$("#zjqdddljdwzjtwo").val(),
		qtzjljdwzjtwo:$("#qtzjljdwzjtwo").val(),
		
		//截至本报告期累计完成资金
		zyysntzjzbbgljwcjj:$("#zyynsjzbbgwc").val(),
		qtzyczxjszjjzbbgljwcjj:$("#qtczxjszjjzbbgwc").val(),
		zxzqmjjszjjzbbgljwcjj:$("#zxzqmjjzbbgwc").val(),
		zysljszjjzbbgljwcjj:$("#zysljzbbgwc").val(),
		nsbdgczjjzbbgljwcjj:$("#nsbdjzbbgwc").val(),
		tljszxzjjzbbgljwcjj:$("#tljsjzbbgwc").val(),
		mhfzzjjzbbgljwcjj:$("#mhfz_zbbgwc").val(),
		gjzdslgcjszjjzbbgljwcjj:$("#zjzdsljzbbgwc").val(),
		dzxskymhqfczjjzbbgljwcjj:$("#dzxskfcjzbbgwc").val(),
		dzxskymhqfcjyzjjzbbgljwcjj:$("#dzxskfcjyjzbbgwc").val(),
		glgkjszjjzbbgljwcjj:$("#glgkjzbbgwc").val(),
		sjysntzjzbbgljwcjj:$("#sjysntzjzbbgwc").val(),
		cityjysntzjzbbgljwcjj:$("#cityysntzjzbbgwc").val(),
		xjysntzjzbbgljwcjj:$("#xjysntzjzbbgwc").val(),
		sjczzjjzbbgljwcjj:$("#sjczjzbbgwc").val(),
		cityjczzjjzbbgljwcjj:$("#cityczjzbbgwc").val(),
		xjczzjjzbbgljwcjj:$("#xjczjzbbgwc").val(),
		dfzxjszjjzbbgljwcjj:$("#dfzxjzbbgwc").val(),
		qyzytzjzbbgljwcjj:$("#zytzjzbbgwc").val(),
		yhdkjzbbgljwcjj:$("#yhdkjzbbgwc").val(), 
		lywzjzbbgljwcjj:$("#lywzjzbbgwc").val(),
		zjqdddjzbbgljwcjj:$("#qdddzjzbbgwc").val(),
		qtzjjzbbgljwcjj:$("#qtzjjzbbgwc").val(),
		
		//截至本报告期累计支付资金
		zyysntzljzfzj:$("#zyysntzljzfzj").val(),
		qtzyczxjszjljzfzj:$("#qtzyczxjszjljzfzj").val(),
		zxzqmjdzxjszjljzfzj:$("#zxzqmjdzxjszjljzfzj").val(),
		zysljsjjljzfzj:$("#zysljsjjljzfzj").val(),
		nsbdgcjjljzfzj:$("#nsbdgcjjljzfzj").val(),
		tljszxjjljzfzj:$("#tljszxjjljzfzj").val(),
		mhfzjjljzfzj:$("#mhfzjjljzfzj").val(),
		gjzdslgcjsjjljzfzj:$("#gjzdslgcjsjjljzfzj").val(),
		dzxskymhqfcjjljzfzj:$("#dzxskymhqfcjjljzfzj").val(),
		dzxskymhqfcjyjjljzfzj:$("#dzxskymhqfcjyjjljzfzj").val(),
		glgkjszxjjljzfzj:$("#glgkjszxjjljzfzj").val(),
		shengjiysntzljzfzj:$("#shengjiysntzljzfzj").val(),
		shijiysntzljzfzj:$("#shijiysntzljzfzj").val(),
		xianjiysntzljzfzj:$("#xianjiysntzljzfzj").val(),
		shengjiczzjljzfzj:$("#shengjiczzjljzfzj").val(),
		shijiczzjljzfzj:$("#shijiczzjljzfzj").val(),
		xianjiczzjljzfzj:$("#xianjiczzjljzfzj").val(),
		dfzxjsjjljzfzj:$("#dfzxjsjjljzfzj").val(),
		qyzytzljzfzj:$("#qyzytzljzfzj").val(),
		yhdkljzfzj:$("#yhdkljzfzj").val(),
		lywzljzfzj:$("#lywzljzfzj").val(),
		zjqdddljzfzj:$("#zjqdddljzfzj").val(),
		qtzjljzfzj:$("#qtzjljzfzj").val()
	};	
	return objess;
}

//提交 其他信息（省基建5818重点项目信息） 表单信息，成功返回true，失败返回false
function submitZdxmk(callback){
	var data = getFormValue("inputForm6");
	data['xmjbxx.id'] = $("#id").val();
	var sfzdgjcy = $("#sfzdgjcy option:checked").val();
	var sfszdgjcy = $("#szdgjcy option:checked").val();
	var sfxszdgjcy = $("#xszdgjcy option:checked").val();
	var szdgjcylx = $("#szdgjcylx option:checked").val();
	var xszdgjcylx = $("#sxzdgjcy").val();
	if(sfzdgjcy==0){
		data['sfzdgjcy'] = sfzdgjcy;
		data['sfszdgjcy'] = "";
		data['sfxszdgjcy'] = "";
		data['szdgjcylx'] = "";
		data['xszdgjcylx'] = "";	  
    }else{
      if(sfszdgjcy == 0){
    	data['sfzdgjcy'] = sfzdgjcy;
  		data['sfszdgjcy'] = sfszdgjcy;
  		data['sfxszdgjcy'] = sfxszdgjcy;
  		data['szdgjcylx'] = szdgjcylx;
  		data['xszdgjcylx'] = "";
      	
      }
      if(sfxszdgjcy == 1){
    	  data['sfzdgjcy'] = sfzdgjcy;
    		data['sfszdgjcy'] = sfszdgjcy;
    		data['sfxszdgjcy'] = sfxszdgjcy;
    		data['szdgjcylx'] = "";
    		data['xszdgjcylx'] = xszdgjcylx;
      }
    }	
//    data.id = $("#id").val();
	debugger;
	data.id = $("#id").val();//				xmjbxxid
    data.xmjbxxid = $("#xmjbxxid").val();
    data.jkylxmfj = $("#jkyl_xmfj_sel option:checked").val();
    data.jkylxmlx = $("#jkyl_xmlx_sel option:checked").val();
    data.jkyldwxz = $("#jkyl_dwxz_sel option:checked").val();
    data.sfjkylxm = $("#sfjkylxm").val();
    $.post(ctx + "/xmjbxx/xmjbxx/saveXmjbxxZdxmk",data,function(msg){
        
    	if(msg.success){
            showTipCur("保存其他信息成功！");
            if (typeof(callback) === "function"){
                callback();
            }
            return true;
        } else if (!msg.success) {
            showTipCur(msg.msg);
            return false;
        } else {
            showTipCur("保存信息失败！");
            return false;
        }
    });
    return true;
}

//获取当前 Tab 的 name（对应 div 的 ID）
function getCurTab() {
    if ($("#fen1").is(":visible")){
        return "fen1";
    }
    if ($("#fen2").is(":visible")){
        return "fen2";
    }
    if ($("#fen3").is(":visible")){
        return "fen3";
    }
    if ($("#fen4").is(":visible")){
        return "fen4";
    }
    if ($("#fen5").is(":visible")){
        return "fen5";
    }
    if ($("#fen6").is(":visible")){
        return "fen6";
    }
    if ($("#fen7").is(":visible")){
        return "fen7";
    }
}

// 获取对应 tab 所对应的 form 表单的 ID
function getCurInputForm(){
    var curTab = getCurTab();
    return $("#" + curTab).parent().attr("id");
}

function closeCurWindow(){
    showTip("保存成功！");
    var index = top.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
    top.layer.close(index); //再执行关闭
}

function checkSubmit(curFormId){
    // 获取当前输入的表单
    // 如果项目基本信息已提交，则后面的表单可提交
    // 否则，需要先保存项目基本信息，才能保存后面的表单信息
    var xmjbxxId = $("#id").val();
    if("inputForm" != curFormId && (null == xmjbxxId || "" == xmjbxxId)){
        switchXmjbxxTab();
        layer.alert("请先保存项目基本信息！");
        return false;
    }
    return true;
}

//切换到下一个 tab
function nexStep(){
	
    var nextStepId = getNextStepName();
    $("#test").find("li").each(function () {
        if (nextStepId == $(this).attr("name") && !$(this).hasClass('two')) {
            $(this).addClass("two");
        } else {
            $(this).removeClass("two");
        }
    });
    
    $("div[name='inputForm']").each(function () {
        if (nextStepId == $(this).attr("id")) {
            $(this).show();
        } else {
            $(this).hide();
        }
    });
}

//获取下一个tab的名称
function getNextStepName(){
	
    var curFormId = getCurInputForm();
    if("inputForm" == curFormId){
        return "fen2";
    }else if("inputForm2" == curFormId) {
        return "fen3";
    }else if("inputForm3" == curFormId) {
        return "fen7";
    }else if("inputForm7" == curFormId) {
        return "fen4";
    }else if("inputForm4" == curFormId) {
        return "fen5";
    }else if("inputForm5" == curFormId) {
        return "fen6";
    }else if("inputForm6" == curFormId) {
        closeCurWindow();
    }
}

//响应点击事件切换tab
function switchTab(e){
    e = e || window.event;
    var tar = e.srcElement || e.target;
    if (tar.nodeName.toLowerCase() == "li" && !$(tar).hasClass('two')) {
        $(tar).addClass("two");
        if($("#qqxy").hasClass('two')){
       	 $("#fen10").show();
       }
        $(tar).siblings().removeClass("two");
        $("div[name='inputForm']").each(function(){
            if($(this).attr("id") == $(tar).attr("name")){
                $(this).show();
            }else{
                $(this).hide();
            }
        })
    }
}

// 切换回项目基本信息页面（第一个 tab）
function switchXmjbxxTab(){
    $($("li[name='fen1']")[0]).addClass("two");
    $($("li[name='fen1']")[0]).siblings().removeClass("two");
    $("div[name='inputForm']").each(function() {
        if ($(this).attr("id") == "fen1") {
            $(this).show();
        } else {
            $(this).hide();
        }
    })
}

//打开项目公司构成页面
function openCzblView(){
    if("view" == operateType){//如果是通过添加的方式来打开弹窗
        openDialogView('项目公司股东构成及出资比例',ctx + '/xmjbxx/sub/cInsBusinessXmgs/xmgsgc?xmid=' + $("#id").val(),'700px','500px');//切换到目标tab
    } else {
        openCzblDialog();//切换到目标tab
    }
}

//打开项目公司构成页面
function openCzblDialog(){
    top.layer.open({
        type: 2,
        area: ['700px', '500px'],
        title: '项目公司股东构成及出资比例',
        maxmin: true, //开启最大化最小化按钮
        content: ctx + '/xmjbxx/sub/cInsBusinessXmgs/xmgsgc?xmid=' + $("#id").val(),
        btn: ['确认','关闭'],
        yes: function(index, layero){
    		
            var iframeWin = layero.find('iframe')[0];
            iframeWin.contentWindow.doSubmit(function(){
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
        cancel: function(index){
        }
    });
}
//文本域
function Q(s) { return document.getElementById(s); }  

function checkWord(c) {
    var maxstrlen = 1000;    
    len = maxstrlen;
    var str = c.value;              //对象的内容
    myLen = getStrleng(str);   //计算str的字符个数
    var wck = Q("wordCheck");
    if (myLen > len * 2) {
        c.value = str.substring(0, i - 1);
    } else {
        wck.innerHTML = Math.floor((len * 2 - myLen) / 2);    //Math.floor(x),返回值：小于等于 x，且与 x 最接近的整数
    }                                                                                       //但是Math.floor((5 * 2 - 1) / 2)=4
}

function getStrleng(str) {
    var maxstrlen = 1000;  
    myLen = 0;
    i = 0;
    for (; (i < str.length) && (myLen <= maxstrlen * 2); i++) {
        if (str.charCodeAt(i) > 0 && str.charCodeAt(i) < 128)           //根据Unicode编码值判断是否汉字
            myLen++;
        else
            myLen += 2;
    }
    return myLen;
}

// 计算项目所处阶段
function checkSpjgptdm(){
    var spjgptdm = $("#spjgptdm").val();
    if(null == spjgptdm){
        top.layer.alert("请先输入审批监管平台代码！");
        return;
    }

    top.layer.open({
        type: 1,
        area: ["500px", "400px"],
        title: "验证监管平台代码",
        content: $("#phoneInputFormDiv").html(),
        btn: ['确定', '关闭'],
        btn1: function (index) {

            if(!validatePhoneInputForm.form()){
                top.layer.alert("请正确填写手机号码！");
                return false;
            }

            var lxphoneone = top.$("#lxphoneoneInput").val();
            if (null == lxphoneone || '' == lxphoneone) {
                top.layer.alert("请正确填写手机号码！");
                return false;
            }

            $.post(ctx + "/xmjbxx/xmjbxx/getCInsBusinessInfo", {spjgptdm: spjgptdm, lxphoneone: lxphoneone}, function (result) {
                console.log("result:");
                console.log(result);
                if (result.success) {
                    showTipCur("审批监管平台代码验证成功！");
                    setPortionXmjbxx(result.body.info);
                    return true;
                } else if (!result.success) {
                    top.layer.alert(result.msg);
                    return false;
                }
            });

            top.layer.close(index);
        },
        btn2: function (index) {
            top.layer.close(index);
        },
        success: function(){
            console.log("get in ...");
            validatePhoneInputForm = top.$("#phoneInputForm").validate({
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
        }
    });
}

// 设置指定的项目信息
function setPortionXmjbxx(info){
    $("#xmmc").val(info.xmmc);
    $("#xmlx").val(info.xmlx);
    $("#jsxz").val(info.jsxz);
    $("#gb").val(info.gb);
    $("#jsdd").val(info.jsdd);
    $("#gbhy").val(info.gbhy);
    $("#sshy").val(info.sshy);
    $("#ztz").val(info.ztz);
    $("#starttimen").val(info.starttimen);
    $("#starttimey").val(info.starttimey);
    $("#endtime").val(info.endtime);
    $("#zyjsgm").val(info.zyjsgm);
    $("#ndzhjsnr").val(info.ndzhjsnr);
    $("#xmfrdw").val(info.xmfrdw);
    $("#zrname").val(info.zrname);
    $("#zrcall").val(info.zrcall);
    $("#lxnameone").val(info.lxnameone);
    $("#lxphoneone").val(info.lxphoneone);
    $("#lxcallone").val(info.lxcallone);
    $("#lxemailone").val(info.lxemailone);

    // 树型字典或自带树型字典显示的文本
    $("#jsddName").val(info.jsddStr);
    $("#gbhyName").val(info.gbhyStr);
    $("#sshyName").val(info.sshyStr);
}