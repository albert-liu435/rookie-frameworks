package com.rookie.bigdata.factory.factorymethod.pizza;

public class LDCheesePizza extends Pizza{

	@Override
	public void prepare() {
		//  Auto-generated method stub
		setName("伦敦的奶酪pizza");
		System.out.println(" 伦敦的奶酪pizza 准备原材料");
	}
}
