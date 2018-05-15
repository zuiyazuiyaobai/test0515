<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ include file="/webpage/include/taglib.jsp"%>
<%@ attribute name="id" type="java.lang.String" required="true"%>
<%@ attribute name="url" type="java.lang.String" required="true"%>
<%@ attribute name="operateIndex" type="java.lang.String"
	required="true"%><!-- 操作索引，要求唯一 -->
<%@ attribute name="label" type="java.lang.String" required="false"%>
<%@ attribute name="imgStyle" type="java.lang.String" required="false"%>
<%@ attribute name="btnStyle" type="java.lang.String" required="false"%>
<!-- 函数名，在执行操作之前检查，如果函数返回结果为真，则执行，否则不执行 -->
<%@ attribute name="checkFunc" type="java.lang.String" required="false"%>
<button class="btn ${btnStyle==null?'btn-white':btnStyle} btn-sm"
	onclick="operateAll${operateIndex}()" data-toggle="tooltip"
	data-placement="top">
	<i class="fa ${imgStyle==null?'fa-pencil-square-o':imgStyle}">
		${label==null?'操作':label}</i>
</button>
<%-- 使用方法： 1.将本tag写在查询的form之前；2.传入table的id和controller的url --%>
<script type="text/javascript">
    $(document).ready(function () {
        $('#${id} thead tr th input.i-checks').on('ifChecked', function (event) { //ifCreated 事件应该在插件初始化之前绑定
            $('#${id} tbody tr td input.i-checks').iCheck('check');
        });

        $('#${id} thead tr th input.i-checks').on('ifUnchecked', function (event) { //ifCreated 事件应该在插件初始化之前绑定
            $('#${id} tbody tr td input.i-checks').iCheck('uncheck');
        });

    });

    function operateAll${operateIndex}() {
        var str = "";
        var ids = "";
        var pdhmdval=0;
        $("#${id} tbody tr td input.i-checks:checkbox").each(function () {
            if (true == $(this).is(':checked')) {
                str += $(this).attr("id") + ",";
                var tt = $(this).parent().parent().find("input[name=pdhmdclass]").val();
                if(tt !="" && tt!=0 && typeof(tt) != "undefined"){
                	pdhmdval +=1;
                }
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
       if(${operateIndex}==2){
       
       
        $.post("${ctx}/xmjbxx/xmjbxx/sngdjhThdbq2?ids=" + ids,function(result){
					    if(result==2){
					    	alert("此项目不属于本级储备库，请点击退回下级单位！");
					    }else{
					  
                 top.layer.confirm('确认要${label}吗?', {icon: 3, title: '系统提示'}, function (index) {
			         /*    window.location = "${url}?ids=" + ids;
			            top.layer.close(index);
			             */  <%--  url="${ctx}/xmjbxx/xmjbxx/sngdjhThdbq" --%>
				    	   window.location = "${ctx}/xmjbxx/xmjbxx/sngdjhThdbq?ids=" + ids;
			       		    top.layer.close(index);
			       					    });
						       }
		    });

       }else  if(${operateIndex}==5){
       var alertstr="确认要${label}吗?";
				 	if(pdhmdval!=0){
			        	alertstr="所选项目所属企业含有黑名单，仍然要${label}吗？";
			        }
           top.layer.confirm(alertstr, {icon: 3, title: '系统提示'}, function (index) {
     			window.location = "${url}?ids=" + ids;
			            top.layer.close(index);
			             
			       					    });
       
       }else  if(${operateIndex}==6){
       top.layer.confirm('确认要${label}吗?', {icon: 3, title: '系统提示'}, function (index) {
			        window.location = "${url}?ids=" + ids;
			            top.layer.close(index);
			             
			       					    });
       
       }
       else{
       
         top.layer.confirm('确认要${label}吗?', {icon: 3, title: '系统提示'}, function (index) {
			        window.location = "${url}?ids=" + ids;
			            top.layer.close(index);
			             
			       					    });
			
       
       
       }
            
             
     
    }
</script>