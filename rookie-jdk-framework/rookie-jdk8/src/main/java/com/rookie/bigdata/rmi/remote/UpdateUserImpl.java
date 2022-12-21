package com.rookie.bigdata.rmi.remote;

import com.rookie.bigdata.rmi.domain.User;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * @Classname UpdateUserImpl
 * @Description TODO
 * @Author rookie
 * @Date 2022/12/19 10:10
 * @Version 1.0
 * Description：远程接口实现类，必须继承UnicastRemoteObject
 * （继承RemoteServer->继承RemoteObject->实现Remote，Serializable），
 * 只有继承UnicastRemoteObject类，才表明其可以作为远程对象，被注册到注册表中供客户端远程调用
 * （补充：客户端lookup找到的对象，只是该远程对象的Stub（存根对象），
 * 而服务端的对象有一个对应的骨架Skeleton（用于接收客户端stub的请求，以及调用真实的对象）对应，
 * Stub是远程对象的客户端代理，Skeleton是远程对象的服务端代理，
 * 他们之间协作完成客户端与服务器之间的方法调用时的通信。）
 */
public class UpdateUserImpl extends UnicastRemoteObject implements IUpdateUser {
    private static final long serialVersionUID = 1L;

    /**
     * 因为UnicastRemoteObject的构造方法抛出了RemoteException异常，因此这里默认的构造方法必须写，
     * 也必须声明抛出RemoteException异常
     *
     * @throws RemoteException
     */

    public UpdateUserImpl() throws RemoteException {
    }

    @Override
    public User updateUser(User u) throws RemoteException {
        System.out.println("-----客户端发送的user-----"+u.toString());
        //更新u
        u.setName(u.getName()+"_更新");
        u.setAge(u.getAge()*2);
        return u;
    }
}

