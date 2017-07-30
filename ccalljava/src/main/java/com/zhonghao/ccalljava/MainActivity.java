package com.zhonghao.ccalljava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {
private JNI jin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        jin = new JNI();
    }

    public void add(View view){
        jin.callbackAdd();

    }

    public void String(View view){
        jin.callbackHelloFromJava();

    }

    public void test1(View view){
        jin.callbackPrintString();

    }

    public void test2(View view){
        jin.callbackSayHello();

    }
}
