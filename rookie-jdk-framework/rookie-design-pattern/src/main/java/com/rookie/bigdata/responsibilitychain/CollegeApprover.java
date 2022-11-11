package com.rookie.bigdata.responsibilitychain;

/**
 * @Classname CollegeApprover
 * @Description
 * @Author rookie
 * @Date 2022/11/11 11:33
 * @Version 1.0
 */
public class CollegeApprover extends Approver {

    public CollegeApprover(String name) {
        // TODO Auto-generated constructor stub
        super(name);
    }

    @Override
    public void processRequest(PurchaseRequest purchaseRequest) {
        // TODO Auto-generated method stub
        if(purchaseRequest.getPrice() < 5000 && purchaseRequest.getPrice() <= 10000) {
            System.out.println(" 请求编号 id= " + purchaseRequest.getId() + " 被 " + this.name + " 处理");
        }else {
            approver.processRequest(purchaseRequest);
        }
    }
}

