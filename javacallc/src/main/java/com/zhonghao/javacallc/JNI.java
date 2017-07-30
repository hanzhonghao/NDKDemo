package com.zhonghao.javacallc;

/**
 * 项目名称：NDKDemo
 * 包名：com.zhonghao.javacallc
 * 类描述：Java调用C
 * 创建人：小豪
 * 创建时间：2017/7/16 10:59
 */

public class JNI {

    {
        System.loadLibrary("javacallc");
    }

    /**
     * 让C代码做加法运算，把结果返回
     * @param x
     * @param y
     * @return
     */
    public native int add(int x, int y);

    /**
     * 从Java传入字符串，C代码进行拼接
     * @param s I am from java
     * @return I am from java and I am from C
     */
    public native String sayHello(String s);

    /**
     * 让C代码每个元素都加上10
     * @param intArray
     * @return
     */
    public native int[] increaseArrayEles(int[] intArray);

    /**
     *应用：检查密码是否正确，如果正确返回200.否则返回400
     */
    public native int checkPwd(String pwd);

}
