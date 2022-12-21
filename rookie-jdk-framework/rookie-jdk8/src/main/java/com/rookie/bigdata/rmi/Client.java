package com.rookie.bigdata.rmi;

import com.rookie.bigdata.rmi.domain.User;
import com.rookie.bigdata.rmi.remote.IUpdateUser;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * @Classname Client
 * @Description TODO
 * @Author rookie
 * @Date 2022/12/19 10:11
 * @Version 1.0
 * Description：该类为客户端启动类，用于在注册表中查找远程对象实现远程方法调用，
 */
public class Client {
    public static void main(String[] args) {
        try{
            // 在RMI服务注册表中查找名称为rUpdate的对象，并调用其上的方法
            IUpdateUser rUpdateUser = (IUpdateUser) Naming.lookup("rmi://localhost:8888/rUpdate");
            //构造User对象，测试远程对象传输
            User user = new User("甲粒子",20);
            System.out.println("-------------- 服务端返回的的user为" + rUpdateUser.updateUser(user).toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
