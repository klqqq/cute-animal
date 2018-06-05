package com.cute.java.core.base.tips;

/**
 * 返回给前台的成功提示
 *
 * @author liuqiang
 * @date 2016年11月12日 下午5:05:22
 */
public class SuccessTip extends Tip {
	
	public SuccessTip(){
		super.code = 200;
		super.message = "操作成功";
	}
}
