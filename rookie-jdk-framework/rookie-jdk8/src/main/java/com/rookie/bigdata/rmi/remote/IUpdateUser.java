package com.rookie.bigdata.rmi.remote;

import com.rookie.bigdata.rmi.domain.User;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @Classname IUpdateUser
 * @Description TODO
 * @Author rookie
 * @Date 2022/12/19 10:09
 * @Version 1.0
 * <p>
 * Description：远程接口，该接口需要继承Remote接口，并且接口中的方法全都要抛出RemoteException异常
 */
public interface IUpdateUser extends Remote {
    User updateUser(User u) throws RemoteException;
}

