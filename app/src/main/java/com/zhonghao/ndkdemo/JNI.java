package com.zhonghao.ndkdemo;

/**
 * 项目名称：NDKDemo
 * 包名：com.zhonghao.ndkdemo
 * 类描述：Java调用对应的C代码的
 * 创建人：小豪
 * 创建时间：2017/7/9 11:57
 */

public class JNI {
    {
        System.loadLibrary("Hello");
    }

    /**
     * 定义native方法
     * 调用C代码对应的方法
     * @return
     */
    public native String sayHello();
}
