package com.rookie.bigdata.prototype.deepclone;

import java.io.Serializable;

/**
 * @Classname DeepCloneableTarget
 * @Description TODO
 * @Author rookie
 * @Date 2022/11/7 22:52
 * @Version 1.0
 */

public class DeepCloneableTarget implements Serializable, Cloneable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private String cloneName;

    private String cloneClass;

    //构造器
    public DeepCloneableTarget(String cloneName, String cloneClass) {
        this.cloneName = cloneName;
        this.cloneClass = cloneClass;
    }

    //因为该类的属性，都是String , 因此我们这里使用默认的clone完成即可
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
