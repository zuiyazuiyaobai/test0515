<%@ tag language="java" pageEncoding="UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp" %>
<%@ attribute name="id" type="java.lang.String" required="true" %>
<%@ attribute name="url" type="java.lang.String" required="true" %>
<%@ attribute name="operateIndex" type="java.lang.String" required="true" %><!-- 操作索引，要求唯一 -->
<%@ attribute name="label" type="java.lang.String" required="false" %>
<%@ attribute name="imgStyle" type="java.lang.String" required="false" %>
<button class="btn btn-white btn-sm" onclick="openSelectOfficePanel${operateIndex}()" data-toggle="tooltip" data-placement="top"><i
        class="fa ${imgStyle==null?'fa-pencil-square-o':'imgStyle'}"> ${label==null?'操作':label}</i>
</button>
<div id="selectOfficePanelDiv${operateIndex}" style="display:none;">
    <form id="selectOfficePanelForm${operateIndex}" action="${url}" method="post">
        <input hidden id="ids" name="ids" value=""/>
        <div style="margin: 30px 30px 0 30px;"><span style="font-size: 14px;">转办接收部门 :</span></div>
        <div style="width:420px;margin:10px 0 0 30px;">
            <select id="selectOfficeId${operateIndex}" name="officeId" class="form-control required">
                <c:forEach var="office" items="${fns:getSameGradeOffice()}">
                    <option value="${office.id}">${office.name}</option>
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

    function openSelectOfficePanel${operateIndex}() {
        var str = "";
        var ids = "";
        $("#contentTable tbody tr td input.i-checks:checkbox").each(function () {
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
            content:$("#selectOfficePanelDiv${operateIndex}").html() ,
            btn: ['确定', '关闭'],
            btn1: function(index){
                //注意，弹框输入的是top域的form中的input，要将此值带回本iframe域内的form的input中再提交表单。
                top.$("#ids").val(ids);
                var value = top.$("#selectOfficeId${operateIndex}").val();
                if(null == value || '' == value) {
                    top.layer.alert("请选择要转办的部门！");
                    return false;
                }

                top.$("#selectOfficePanelForm${operateIndex}").attr("target",top.getActiveTab().attr("name"));
                top.$("#selectOfficePanelForm${operateIndex}").submit();
                top.layer.close(index);
            },

            btn2: function(index){
                top.layer.close(index);
            }
        });
    }
</script>