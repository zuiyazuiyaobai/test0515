<%@ tag language="java" pageEncoding="UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp" %>
<%@ attribute name="id" type="java.lang.String" required="true" %>
<%@ attribute name="url" type="java.lang.String" required="true" %>
<%@ attribute name="type" type="java.lang.String" required="true" %>
<%@ attribute name="selectName" type="java.lang.String" required="true" %>
<%@ attribute name="operateIndex" type="java.lang.String" required="true" %><!-- 操作索引，要求唯一 -->
<%@ attribute name="label" type="java.lang.String" required="false" %>
<%@ attribute name="contentLabel" type="java.lang.String" required="false" %>
<%@ attribute name="imgStyle" type="java.lang.String" required="false" %>
<button class="btn btn-white btn-sm" onclick="openSelectPanel${operateIndex}()" data-toggle="tooltip" data-placement="top"><i
        class="fa ${imgStyle==null?'fa-pencil-square-o':'imgStyle'}"> ${label==null?'操作':label}</i>
</button>
<div id="selectPanelDiv${operateIndex}" style="display:none;">
    <form id="selectPanelForm${operateIndex}" action="${url}" method="post">
        <input hidden id="ids" name="ids" value=""/>
        <div style="margin: 30px 30px 0 30px;"><span style="font-size: 14px;">${contentLabel}</span></div>
        <div style="width:420px;margin:10px 0 0 30px;">
            <select id="selectId${operateIndex}" name="${selectName}" class="form-control required">
                <c:forEach var="office" items="${fns:getDictList(type)}">
                    <option value="${office.value}">${office.label}</option>
                </c:forEach>
            </select>
        </div>
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

    function openSelectPanel${operateIndex}() {
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

        top.layer.open({
            type: 1,
            area: ["500px", "400px"],
            title:"${label}",
            content:$("#selectPanelDiv${operateIndex}").html() ,
            btn: ['确定', '关闭'],
            btn1: function(index){
                //注意，弹框输入的是top域的form中的input，要将此值带回本iframe域内的form的input中再提交表单。
                top.$("#ids").val(ids);
                var value = top.$("#selectId${operateIndex}").val();
                if(null == value || '' == value) {
                    top.layer.alert("请选择！");
                    return false;
                }

                top.$("#selectPanelForm${operateIndex}").attr("target",top.getActiveTab().attr("name"));
                top.$("#selectPanelForm${operateIndex}").submit();
                top.layer.close(index);
            },

            btn2: function(index){
                top.layer.close(index);
            }
        });
    }
</script>