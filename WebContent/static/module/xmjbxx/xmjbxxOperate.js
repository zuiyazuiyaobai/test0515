/**
 * 执行加锁操作前检查
 * @param ids 传入 xmjbxxId 的数组字符串，以","分隔
 * @returns {boolean} 返回是否允许继续操作的布尔值
 * 注：需要该列表选择 input:checkbox 含有 sztAttr userGradeAttr xmmcAttr 三个属性
 */
function checkJiasuo(ids){
    var idsArr = ids.split(",");
    for (var i = 0; i < idsArr.length; i++) {
        var id = idsArr[i];
        if (null == id) {
            continue;
        }

        var $curSelect = $("#" + id);
        var szt = $curSelect.attr("sztAttr");
        var userGrade = $curSelect.attr("userGradeAttr");
        var xmmc = $curSelect.attr("xmmcAttr");
        if (userGrade === szt) {
            top.layer.alert("项目（" + xmmc + "）已锁定，不需要加锁！", {icon: 0});
            return false;
        } else if (Number(szt) > Number(userGrade)) {
            top.layer.alert("项目（" + xmmc + "）锁等级高于您的用户层级，无法加锁！");
            return false;
        }
    }
    return true;
}

/**
 * 执行解锁操作前检查
 * @param ids 传入 xmjbxxId 的数组字符串，以","分隔
 * @returns {boolean} 返回是否允许继续操作的布尔值
 *
 * 注：需要该列表选择 input:checkbox 含有 sztAttr userGradeAttr xmmcAttr 三个属性
 */
function checkJiesuo(ids){
    var idsArr = ids.split(",");
    for (var i = 0; i < idsArr.length; i++) {
        var id = idsArr[i];
        if (null == id) {
            continue;
        }

        var $curSelect = $("#" + id);
        var szt = $curSelect.attr("sztAttr");
        var userGrade = $curSelect.attr("userGradeAttr");
        var xmmc = $curSelect.attr("xmmcAttr");
        if ('0' === szt) {
            top.layer.alert("项目（" + xmmc + "）未锁定，不需要解锁！", {icon: 0});
            return false;
        } else if (Number(szt) > Number(userGrade)) {
            top.layer.alert("项目（" + xmmc + "）锁等级高于您的用户层级，无法解锁！");
            return false;
        }
    }
    return true;
}

/**
 * 执行编辑操作前检查
 * @param id 传入 xmjbxxId 的数组字符串，以","分隔
 * @returns {boolean} 返回是否允许继续操作的布尔值
 *
 * 注：需要该列表选择 input:checkbox 含有 sztAttr 属性
 */
function checkEdit(id){
    var szt = $("#" + id).attr("sztAttr");
    if('0' === szt){
        return true;
    }else{
        top.layer.alert("该项目处于锁定状态，不能进行编辑！", {icon: 0});
        return false;
    }
}