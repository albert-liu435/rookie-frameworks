package com.rookie.bigdata.rmi;

import com.rookie.bigdata.rmi.remote.IUpdateUser;
import com.rookie.bigdata.rmi.remote.UpdateUserImpl;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/**
 * @Classname Server
 * @Description TODO
 * @Author rookie
 * @Date 2022/12/19 10:11
 * @Version 1.0
 * Description：服务端启动类，用于创建远程对象注册表以及注册远程对象
 */
public class Server {
    public static void main(String[] args) throws Exception {
        try{
            // 本地主机上的远程对象注册表Registry的实例，
            // 并指定端口为8888，这一步必不可少（Java默认端口是1099）
            LocateRegistry.createRegistry(8888);
            //创建一个远程对象
            IUpdateUser rUpdateUser=new UpdateUserImpl();
            //把远程对象注册到RMI注册服务器上,命名为 rUpdate
            //绑定的URL标准格式为：rmi://host:port/name(其中协议名可以省略，下面两种写法都是正确的）
            // Naming.bind("//localhost:8888/rUpdate",rUpdateUser);
            Naming.bind("rmi://localhost:8888/rUpdate",rUpdateUser);
            System.out.println("------------远程对象IUpdateUser注册成功，等待客户端调用...");
        }catch (RemoteException e) {
            System.out.println("创建远程对象发生异常！");
            e.printStackTrace();
        } catch (AlreadyBoundException e) {
            System.out.println("发生重复绑定对象异常！");
            e.printStackTrace();
        } catch (MalformedURLException e) {
            System.out.println("发生URL畸形异常！");
            e.printStackTrace();
        }

    }
}
