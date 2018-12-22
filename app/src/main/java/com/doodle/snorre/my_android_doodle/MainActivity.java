package com.doodle.snorre.my_android_doodle;

import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.doodle.snorre.my_android_doodle.camera.CameraPreview;

public class MainActivity extends AppCompatActivity {

    private boolean hasCamera;
    private Camera camera;
    private CameraPreview cameraPreview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("INFO","onCreate");

        setContentView(R.layout.activity_main);

        hasCamera = checkCameraHardware(getApplicationContext());

        camera = getCameraInstance();
        cameraPreview = new CameraPreview(getApplicationContext(),camera);


    }

    /** Check if this device has a camera */
    private boolean checkCameraHardware(Context context) {
        Log.d("INFO","Checking for camera!");
        if (context.getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA)){
            // this device has a camera
            return true;
        } else {
            // no camera on this device
            return false;
        }
    }

    /** A safe way to get an instance of the Camera object. */
    public static Camera getCameraInstance(){
        Camera c = null;
        try {
            c = Camera.open(); // attempt to get a Camera instance
            Log.d("INFO","Camera opened!");
        }
        catch (Exception e){
            Log.d("EXCEPTION","EXCEPTION: " + e);
            // Camera is not available (in use or does not exist)
        }
        return c; // returns null if camera is unavailable
    }

}
