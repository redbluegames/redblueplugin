package com.redbluegames.redblueplugin;
 
import com.unity3d.player.UnityPlayer;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Build;
import android.view.View;
 
public class ImmsersiveMode {

        public static void EnableImmersiveMode(Activity currentActivity){
          // Running this on UI thread so that the methods affecting the ui
          // always use the same thread.
          // http://answers.unity3d.com/questions/59897/android-accessing-thread-of-the-original-activitys.html
          UnityPlayer.currentActivity.runOnUiThread(new Runnable() {
            public void run() {
              SetImmersiveFlags ();
            }
          });
        }
        
        @SuppressLint("NewApi")
        static void SetImmersiveFlags ()
        {
          if (Build.VERSION.SDK_INT >= 19) { //KITKAT          
            int flags = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
            UnityPlayer.currentActivity.getWindow().getDecorView().setSystemUiVisibility(flags);
          }
        }
}