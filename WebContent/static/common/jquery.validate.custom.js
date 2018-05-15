jQuery.validator.addMethod("isMobile", function(value, element) {
    var length = value.length;
    var mobile = /^(13[0-9]{9})|(18[0-9]{9})|(14[0-9]{9})|(17[0-9]{9})|(15[0-9]{9})$/;
    return this.optional(element) || (length === 11 && mobile.test(value));
}, "请正确填写手机号码");

jQuery.validator.addMethod("isCall", function(value, element) {
    var tel = /^0\d{2,3}-?\d{7,8}$/;
    return this.optional(element) || tel.test(value);
}, "请正确填写座机号");
