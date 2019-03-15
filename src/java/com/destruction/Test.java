package com.destruction;

import com.hungry.HungrySingleton;
import com.innerclass.InnerClassSingleton;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

public class Test {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException, IOException, ClassNotFoundException {
        //1、使用反射破坏单例
        HungrySingleton hungrySingleton = HungrySingleton.getInstance();

        Class clazz = HungrySingleton.class;
        Constructor con  =clazz.getDeclaredConstructor();
        con.setAccessible(true);
        HungrySingleton new_hungrySingleton = (HungrySingleton) con.newInstance();
        System.out.println(hungrySingleton==new_hungrySingleton);//false 创建了两个对象

        //2、使用序列化/反序列化破坏单例
        InnerClassSingleton innerClassSingleton = InnerClassSingleton.getInstance();

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("InnerClassSingleton.obj"));
        oos.writeObject(innerClassSingleton);
        oos.flush();
        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("InnerClassSingleton.obj"));
        InnerClassSingleton new_innerClassSingleton = (InnerClassSingleton) ois.readObject();
        ois.close();
        System.out.println(innerClassSingleton==new_innerClassSingleton);//false 创建了两个对象
    }
}
