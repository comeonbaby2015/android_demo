package android_demo.fragment.lifecycle;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;

import android_demo.R;

public class LifecycleActivity extends Activity {
    private final String TAG = "SingleInstanceActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liecycle_layout);
        Log.d(TAG, "-----> onCreate----");

        LifecycleFragment fragment = new LifecycleFragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.root, fragment, LifecycleFragment.TAG);
        transaction.addToBackStack(LifecycleFragment.TAG);
        transaction.commit();

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
}
