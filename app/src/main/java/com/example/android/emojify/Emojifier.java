package com.example.android.emojify;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.util.SparseArray;
import android.widget.Toast;

import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.face.Face;
import com.google.android.gms.vision.face.FaceDetector;

public class Emojifier {

    public static final String TAG = Emojifier.class.getSimpleName();

    public static void detectFaces (Context context, Bitmap picture) {

         // Create the face detector, disable tracking and enable classifications
        FaceDetector faceDetector = new FaceDetector.Builder(context)
                .setTrackingEnabled(false)
                .setClassificationType(FaceDetector.ALL_CLASSIFICATIONS)
                .build();

         // Build the frame
        Frame frame = new Frame.Builder().setBitmap(picture).build();

         // Detect the faces
         SparseArray<Face> faces = faceDetector.detect(frame);

         // Log the number of faces
         Log.d(TAG, "detect faces: number of faces = " + faces.size());

         // If there are no faces detected, show a Toast message
         if(faces.size() == 0){
             Toast.makeText(context, "no faces detected", Toast.LENGTH_SHORT).show();
         }

         // Release the detector
         faceDetector.release();
    }
}
