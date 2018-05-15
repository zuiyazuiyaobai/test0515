<%@ tag language="java" pageEncoding="UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp" %>
<%@ attribute name="id" type="java.lang.String" required="true" %>
<%@ attribute name="url" type="java.lang.String" required="true" %>
<%@ attribute name="operateIndex" type="java.lang.String" required="true" %><!-- 操作索引，要求唯一 -->
<%@ attribute name="panelName" type="java.lang.String" required="true" %><!-- 提交表单的变量名，要求唯一 -->
<%@ attribute name="nextOffices" type="java.lang.String" required="true" %><!-- 显示的变量名，要求唯一 -->
<%@ attribute name="nextOfficesName" type="java.lang.String" required="false" %>
<%@ attribute name="label" type="java.lang.String" required="false" %>
<%@ attribute name="imgStyle" type="java.lang.String" required="false" %>
<!-- 函数名，在执行操作之前检查，如果函数返回结果为真，则执行，否则不执行 -->
<%@ attribute name="checkFunc" type="java.lang.String" required="false" %>
<button class="btn btn-white btn-sm" onclick="operatePanel${operateIndex}()" data-toggle="tooltip" data-placement="top"><i
        class="fa ${imgStyle==null?'fa-pencil-square-o':'imgStyle'}"> ${label==null?'操作':label}</i>
</button>
<div id="panelFormDiv${operateIndex}" style="display:none;padding:20px">
<form id="panelForm${operateIndex}" action="${url}" method="post">
    <input hidden id="${panelName}Ids" name="ids" value=""/>
    <div style="margin: 30px 30px 0 30px;"><span style="font-size: 14px;">报送文号 :</span></div>
    <div style="width: 420px; margin: 10px 0 0 30px;"> <input id="bswh" name="bswh" value="" class="form-control input-sm"></div>
    <div style="margin: 30px 30px 0 30px;"><span style="font-size: 14px;">上报部门 :</span></div>
    <div style="width: 420px; margin: 10px 0 0 30px;">
    <% if(nextOfficesName!=null && !"".equals(nextOfficesName)){ %>
      <sys:treeselect id="office" name="officeId" value="${nextOffices}" labelName="officeName" labelValue="${nextOfficesName}" notAllowSelectParent="true" cssClass="form-control"
                    title="部门" url="/sys/office/treeData?showIds=${nextOffices}" isAll="true" />
    <%}else{ %>
       <sys:treeselect id="office" name="officeId" value="" labelName="officeName" labelValue="" notAllowSelectParent="true" cssClass="form-control"
                    title="部门" url="/sys/office/treeData?showIds=${nextOffices}" isAll="true" />
    <%} %>
    </div>
    <div style="margin: 30px 30px 0 30px;"><span style="font-size: 14px;">报送类别:</span></div>
    <div style="width: 420px; margin: 10px 0 0 30px;"> 
    <select id="bslb" name="bslb" class="form-control input-sm">
    	<!-- <option value="1">2017年省重点项目</option> -->
    	<option value="2">2018年省重点项目</option>
    	<!-- <option value="3">2017年省基建项目</option> -->
    	<option value="4">2018年省基建项目</option>
    	<option value="5">5818项目</option>
    	<option value="7">省节能减排专项资金项目</option>
    	<option value="8">京豫南北水调对口协作项目</option>
    	<option value="9">现代服务业重点项目</option>
    	<option value="10">省转型发展攻坚项目</option>
    	<option value="11">省先进制造重大项目</option>
    	<option value="12">2018年交通基础设施省补助资金项目</option>
    	<option value="13">健康养老示范项目</option>
    	<option value="6">其他项目</option>
    </select></div>
</form>
</div>
<%-- 使用方法： 1.将本tag写在查询的form之前；2.传入table的id和controller的url --%>
<script type="text/javascript">
    $(document).ready(function () {
        $('#${id} thead tr th input.i-checks').on('ifChecked', function(event){ //ifCreated 事件应该在插件初始化之前绑定
            $('#${id} tbody tr td input.i-checks').iCheck('check');
        });

        $('#${id} thead tr th input.i-checks').on('ifUnchecked', function(event){ //ifCreated 事件应该在插件初始化之前绑定
            $('#${id} tbody tr td input.i-checks').iCheck('uncheck');
        });

    });

    function operatePanel${operateIndex}() {
        var str = "";
        var ids = "";
        $("#${id} tbody tr td input.i-checks:checkbox").each(function () {
            if (true == $(this).is(':checked')) {
                str += $(this).attr("id") + ",";
            }
        });
        if (str.substr(str.length - 1) == ',') {
            ids = str.substr(0, str.length - 1);
        }
        if (ids == "") {
            top.layer.alert('请至少选择一条数据!', {icon: 0, title: '警告'});
            return;
        }

        // 在执行操作之前执行传入的判断是否可执行的校验函数
        if(typeof ${checkFunc==null?'notFunc':checkFunc} === 'function'){
            if(!${checkFunc}(ids)){
                return;
            }
        }

        top.layer.open({
            type: 1,
            area: ["500px", "400px"],
            title:"${label}",
            content:$("#panelFormDiv${operateIndex}").html() ,
            btn: ['确定', '关闭'],
            btn1: function(index){
                confirmx("注意：上报上级单位，您确定继续吗？",function(){
                    //注意，弹框输入的是top域的form中的input，要将此值带回本iframe域内的form的input中再提交表单。
                    top.$("#${panelName}Ids").val(ids);
                    var value = top.$("#officeId").val();
                    if(null == value || '' == value) {
                        top.layer.alert("请选择要上报的部门！");
                        return false;
                    }

                    top.$("#panelForm${operateIndex}").attr("target",top.getActiveTab().attr("name"));
                    top.$("#panelForm${operateIndex}").submit();
                    top.layer.close(index);
                });
            },

            btn2: function(index){
                top.layer.close(index);
            }
        });
    }
</script>