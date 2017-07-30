package com.zhonghao.javacallc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private JNI jni;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        jni = new JNI();
    }

    public void add(View v){
        int result = jni.add(99, 1);
        Log.e(MainActivity.class.getSimpleName(),"result"+ result);
        Toast.makeText(this,"result is "+ result,Toast.LENGTH_SHORT).show();
    }
    public void String(View v){
        String result = jni.sayHello("I am from java!");
        Log.e(MainActivity.class.getSimpleName(),"result"+ result);
        Toast.makeText(this,"result is "+ result,Toast.LENGTH_SHORT).show();
    }
    public void array(View v){
        int array[] = {1,2,3,4,5};
        int result[] =jni.increaseArrayEles(array);
        for(int i=0;i<array.length;i++){
            Toast.makeText(this, "array["+i+"]==="+result[i], Toast.LENGTH_SHORT).show();
            Log.e(MainActivity.class.getSimpleName(),"array["+i+"]==="+result[i]);
        }

    }
    public void checkpw(View v){
        int result =jni.checkPwd("12345678");
        Log.e(MainActivity.class.getSimpleName(),"result"+ result);
        Toast.makeText(this, "result"+ result, Toast.LENGTH_SHORT).show();
    }
}
