package android_demo.fragment.singleInstance;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;

import android_demo.R;
import android_demo.fragment.lifecycle.LifecycleFragment;

public class SingleInstanceActivity extends Activity {
    private final String TAG = SingleInstanceActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liecycle_layout);
        Log.d(TAG, "-----> onCreate----");
        getFragmentManager().beginTransaction().replace(R.id.root, new AFragment(), AFragment.TAG).addToBackStack(AFragment.TAG).commit();

        getLastNonConfigurationInstance();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "-----> onStart----");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "-----> onResume----");
    }

    @Override
    protected void onPause() {

        super.onPause();
        Log.d(TAG, "-----> onPause----");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "-----> onStop----");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "-----> onDestroy----");
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.d(TAG, "-----> onConfigurationChanged----");
    }

    @Override
    public Object onRetainNonConfigurationInstance() {
        return super.onRetainNonConfigurationInstance();
    }
}
