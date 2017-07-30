//
// Created by 小豪 on 2017/7/16.
//
#include "com_zhonghao_javacallc_JNI.h"

#include <string.h>
jint Java_com_zhonghao_javacallc_JNI_add(JNIEnv *env, jobject jobj, jint ji, jint jj) {
    int result = ji + jj;
    return result;
};

/**
 * 把一个jstring转换成一个c语言的char* 类型.
 */
char* _JString2CStr(JNIEnv* env, jstring jstr) {
    char* rtn = NULL;
    jclass clsstring = (*env)->FindClass(env, "java/lang/String");
    jstring strencode = (*env)->NewStringUTF(env,"GB2312");
    jmethodID mid = (*env)->GetMethodID(env, clsstring, "getBytes", "(Ljava/lang/String;)[B");
    jbyteArray barr = (jbyteArray)(*env)->CallObjectMethod(env, jstr, mid, strencode); // String .getByte("GB2312");
    jsize alen = (*env)->GetArrayLength(env, barr);
    jbyte* ba = (*env)->GetByteArrayElements(env, barr, JNI_FALSE);
    if(alen > 0) {
        rtn = (char*)malloc(alen+1); //"\0"
        memcpy(rtn, ba, alen);
        rtn[alen]=0;
    }
    (*env)->ReleaseByteArrayElements(env, barr, ba,0);
    return rtn;
}

/**
 *  从java传入字符串，C代码进程拼接
     *
     * @param java : I am from java
     *        c    : add I am from C
     * @return  I am form java add I am from C
 */
 jstring  Java_com_zhonghao_javacallc_JNI_sayHello
        (JNIEnv * env, jobject job, jstring jstr){

    char* fromJava = _JString2CStr(env,jstr);//I am form java add I am from C
    //c:
    char* fromC = "add I am from C";
    //拼接函数strcat
    strcat(fromJava,fromC);//把拼接的结果放在第一参数里面
    //jstring     (*NewStringUTF)(JNIEnv*, const char*);

    return  (*env)->NewStringUTF(env,fromJava);
};

/**
 * 给每个元素加上10
 */
JNIEXPORT jintArray JNICALL Java_com_zhonghao_javacallc_JNI_increaseArrayEles
        (JNIEnv * env, jobject jobj, jintArray jarray) {

    //1.得到数组的长度
    //jsize       (*GetArrayLength)(JNIEnv*, jarray);
    jsize size = (*env)->GetArrayLength(env, jarray);
    //2.得到数组元素
    //jint*       (*GetIntArrayElements)(JNIEnv*, jintArray, jboolean*);
    jint * intArray = (*env)->GetIntArrayElements(env, jarray, JNI_FALSE);
    //3.遍历数组，给每个元素加上10
    int i;
    for (i = 0; i < size; i++) {
//        *(intArray+i) = *(intArray+i) + 10;
        *(intArray + i) += 10;
    }
    //4.返回结果
    return jarray;
};

JNIEXPORT jint JNICALL Java_com_zhonghao_javacallc_JNI_checkPwd
        (JNIEnv * env, jobject jobject, jstring jstr){

    //服务器密码是123456
    char* origin  = "123456";
    char* fromUser = _JString2CStr(env,jstr);
    //函数比较字符串是否相同
    int code =strcmp(origin,fromUser);
    if(code==0){
        return 200;
    }else{
        return 400;
    }

};


