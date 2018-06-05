/**
 * 管理初始化
 */
var MemberShop = {
    id: "MemberShopTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
MemberShop.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: '会员ID', field: 'mId', visible: true, align: 'center', valign: 'middle'},
            {title: '企业名称', field: 'shopName', visible: true, align: 'center', valign: 'middle'},
            {title: '企业logo', field: 'logo', visible: true, align: 'center', valign: 'middle'},
            {title: '状态', field: 'status', visible: true, align: 'center', valign: 'middle'},
            {title: '加入时间', field: 'addtime', visible: true, align: 'center', valign: 'middle'},
            {title: '编辑时间', field: 'endtime', visible: true, align: 'center', valign: 'middle'},
            {title: '电话', field: 'tel', visible: true, align: 'center', valign: 'middle'},
            {title: '邮箱', field: 'email', visible: true, align: 'center', valign: 'middle'},
            {title: '客服url', field: 'customerUrl', visible: true, align: 'center', valign: 'middle'},
            {title: '营业执照', field: 'businessLicense', visible: true, align: 'center', valign: 'middle'},
            {title: '省', field: 'prov', visible: true, align: 'center', valign: 'middle'},
            {title: '市', field: 'city', visible: true, align: 'center', valign: 'middle'},
            {title: '区', field: 'area', visible: true, align: 'center', valign: 'middle'},
            {title: '地址', field: 'address', visible: true, align: 'center', valign: 'middle'},
            {title: '描述', field: 'desc', visible: true, align: 'center', valign: 'middle'},
            {title: '评论数', field: 'goodsComment', visible: true, align: 'center', valign: 'middle'},
            {title: '等级', field: 'level', visible: true, align: 'center', valign: 'middle'},
            {title: '余额', field: 'balance', visible: true, align: 'center', valign: 'middle'},
            {title: 'banner_url', field: 'bannerUrl', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
MemberShop.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        MemberShop.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加
 */
MemberShop.openAddMemberShop = function () {
    var index = layer.open({
        type: 2,
        title: '添加',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/memberShop/memberShop_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看详情
 */
MemberShop.openMemberShopDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/memberShop/memberShop_update/' + MemberShop.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除
 */
MemberShop.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/memberShop/delete", function (data) {
            Feng.success("删除成功!");
            MemberShop.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("memberShopId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询列表
 */
MemberShop.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    MemberShop.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = MemberShop.initColumn();
    var table = new BSTable(MemberShop.id, "/memberShop/list", defaultColunms);
    table.setPaginationType("client");
    MemberShop.table = table.init();
});
