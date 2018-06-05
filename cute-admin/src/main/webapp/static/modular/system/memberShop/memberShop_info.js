/**
 * 初始化详情对话框
 */
var MemberShopInfoDlg = {
    memberShopInfoData : {}
};

/**
 * 清除数据
 */
MemberShopInfoDlg.clearData = function() {
    this.memberShopInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
MemberShopInfoDlg.set = function(key, val) {
    this.memberShopInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
MemberShopInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
MemberShopInfoDlg.close = function() {
    parent.layer.close(window.parent.MemberShop.layerIndex);
}

/**
 * 收集数据
 */
MemberShopInfoDlg.collectData = function() {
    this
    .set('mId')
    .set('shopName')
    .set('logo')
    .set('status')
    .set('addtime')
    .set('endtime')
    .set('tel')
    .set('email')
    .set('customerUrl')
    .set('businessLicense')
    .set('prov')
    .set('city')
    .set('area')
    .set('address')
    .set('desc')
    .set('goodsComment')
    .set('level')
    .set('balance')
    .set('bannerUrl');
}

/**
 * 提交添加
 */
MemberShopInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/memberShop/add", function(data){
        Feng.success("添加成功!");
        window.parent.MemberShop.table.refresh();
        MemberShopInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.memberShopInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
MemberShopInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/memberShop/update", function(data){
        Feng.success("修改成功!");
        window.parent.MemberShop.table.refresh();
        MemberShopInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.memberShopInfoData);
    ajax.start();
}

$(function() {

});
