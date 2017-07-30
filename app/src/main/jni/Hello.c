//
// Created by 小豪 on 2017/7/9.
//

#include <stdio.h>
#include <stdlib.h>
#include <jni.h>

/**
 * jstring ：返回值
 * Java_全类名_方法名
 * JNIEnv* env:里面有很多方法
 * jobject jobj：谁调用了这个方法就是谁的实例
 * 当前就是JNI.this
 */
jstring Java_com_zhonghao_ndkdemo_JNI_sayHello(JNIEnv* env,jobject jobj) {
    //jstring     (*NewStringUTF)(JNIEnv*, const char*);
    char* text = "I am from c!!!";
    return (*env)->NewStringUTF(env,text);
}

//    JNIEXPORT jstring JNICALL Java_com_zhonghao_ndkdemo_JNI_sayHello(JNIEnv* env,jobject jobj);{
//    return (*env)->NewStringUTF(env, "Hello World");
//}

//                  JNIEXPORT jstring JNICALL Java_com_chen_jnidemo_JNI_printHelloWorld
//        (JNIEnv env, jobject jobj) {
//    return (*env)->NewStringUTF(env, "Hello World");
//}