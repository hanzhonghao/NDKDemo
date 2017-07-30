package com.zhonghao.ccalljava;

import android.util.Log;

/**
 * 项目名称：NDKDemo
 * 包名：com.zhonghao.ccalljava
 * 创建人：小豪
 * 创建时间：2017/7/26 16:10
 * 类描述：
 */

/**
 *  C回调Java方法的核心思想: 反射
    如何得到一个方法的签名?
    在命令行窗口中, 进入应用的classes/debug/目录
    执行命令: javap -s 全类名, 显示所有方法的签名信息
 */




public class JNI {
    {
        System.loadLibrary("ccalljava");
    }

    /**
     * 当执行这个方法的时候，让C代码调用
     * public int add(int x, int y)
     */
    public native void callbackAdd();

    /**
     * 当执行这个方法的时候，让C代码调用
     * public void helloFromJava()
     */
    public native void callbackHelloFromJava();


    /**
     * 当执行这个方法的时候，让C代码调用void printString(String s)
     */
    public native void callbackPrintString();

    /**
     * 当执行这个方法的时候，让C代码静态方法 static void sayHello(String s)
     */
    public native void callbackSayHello();




    public int add(int x, int y) {
        Log.e("TAG", "add() x=" + x + " y=" + y);
        return x + y;
    }

    public void helloFromJava() {
        Log.e("TAG", "helloFromJava()");
    }

    public void printString(String s) {
        Log.e("TAG","C中输入的：" + s);
    }

    public static void sayHello(String s){
        Log.e("TAG",  "我是java代码中的JNI."
                + "java中的sayHello(String s)静态方法，我被C调用了:"+ s);
    }
}