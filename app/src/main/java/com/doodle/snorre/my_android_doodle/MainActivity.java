package com.doodle.snorre.my_android_doodle;


import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import io.firekast.FKCamera;
import io.firekast.FKCameraFragment;
import io.firekast.FKError;
import io.firekast.FKStream;
import io.firekast.FKStreamer;
import io.firekast.Firekast;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "INFO";
    private FKCameraFragment mCameraFragment;
    private FKCamera mCamera;
    private FKStreamer mStreamer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG,"onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        try {
            Firekast.initialize(this, "bbc46d61-0003-4830-b39f-4ed6c71b8492", "fb08e606-17e7-4a08-a2eb-f96a5f6f4ce2");
            Log.d(TAG,"Firekast initialized successfully.");
            // 1. get fragment from layout
            mCameraFragment = (FKCameraFragment) getSupportFragmentManager().findFragmentByTag("camera_fragment");//findFragmentById(R.id.camera_fragment);
            Log.d(TAG,"Fragment OK");


        }catch (Exception e){
            Log.d(TAG,"Error initializing Firekast: " + e);
        }

    }


    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG, "onResume");

    }

    @Override
    protected void onPause() {
        Log.e(TAG, "onPause");
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        Log.e(TAG, "onDestroy");
        super.onDestroy();
    }
}



