package android_demo.webview.flip_conflict;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.DragEvent;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import android_demo.R;

/**
 * Created by hades on 2016/1/28.
 */
public class WebViewFlictConflictActivity extends Activity implements GestureDetector.OnGestureListener {
    /**
     * Called when the activity is first created.
     */

    int index = 0;
    List<String> path = new ArrayList<>();
    WebView wView;
    LinearLayout ll;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_webview_flict_conflict);

        wView = (WebView) findViewById(R.id.wv1);
        ll = (LinearLayout) findViewById(R.id.ll);
        WebSettings wSet = wView.getSettings();
        wSet.setJavaScriptEnabled(true);

        gestureScanner = new GestureDetector(this);
        path.add(0, "file:///android_asset/index.html");
        path.add(1, "file:///android_asset/index2.html");
        path.add(2, "file:///android_asset/index3.html");

        wView.loadUrl("file:///android_asset/index.html");
        //wView.loadUrl("content://com.android.htmlfileprovider/sdcard/index.html");
        //wView.loadUrl("http://wap.baidu.com");


        ll.setOnDragListener(new View.OnDragListener() {
            @Override
            public boolean onDrag(View v, DragEvent event) {

                return false;
            }
        });

    }

    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }

    private GestureDetector gestureScanner;


    @Override

    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {

        Toast.makeText(this, "Swipe to Explore the Happiness Path", Toast.LENGTH_LONG).show();

//
//        try {
//            if (Math.abs(e1.getY() - e2.getY()) > 250)
//                return false;
//            if (e1.getX() - e2.getX() > 120 && Math.abs(velocityX) > 200) {
//                Log.d("Fling", "Move Next");
//                index++;
//                wView.loadUrl(path.get(index % 3));
//                //do something...
//            } else if (e2.getX() - e1.getX() > 120 && Math.abs(velocityX) > 200) {
//                Log.d("Fling", "Move Previous");
//                //do something...
//                index--;
//                if (0 < index) {
//                    index = 0;
//                }
//
//                wView.loadUrl(path.get(index % 3));
//
//            }
//            return false;
//        } catch (Exception e) {
//            return false;
//        }
        return false;
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_MOVE:
                index++;
                wView.loadUrl(path.get(index % 3));
                return true;

            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
                index--;
                if (0 < index) {
                    index = 0;
                }

                wView.loadUrl(path.get(index % 3));
                return true;
        }

        return super.onTouchEvent(event);

    }
}
