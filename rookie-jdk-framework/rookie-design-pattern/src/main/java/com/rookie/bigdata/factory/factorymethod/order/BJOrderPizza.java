package com.rookie.bigdata.factory.factorymethod.order;


import com.rookie.bigdata.factory.factorymethod.pizza.BJCheesePizza;
import com.rookie.bigdata.factory.factorymethod.pizza.BJPepperPizza;
import com.rookie.bigdata.factory.factorymethod.pizza.Pizza;

public class BJOrderPizza extends OrderPizza {


	@Override
	Pizza createPizza(String orderType) {

		Pizza pizza = null;
		if(orderType.equals("cheese")) {
			pizza = new BJCheesePizza();
		} else if (orderType.equals("pepper")) {
			pizza = new BJPepperPizza();
		}
		//  Auto-generated method stub
		return pizza;
	}

}
