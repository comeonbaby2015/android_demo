package android_demo.fragment.addToBackStack;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;

import android_demo.R;

public class AddToBackStackActivity extends Activity {
    private final String TAG = "AddToBackStackActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_to_back_stack_layout);
        Log.d(TAG, "-----> onCreate----");

        //AddToBackStackFragment fragment = new AddToBackStackFragment();
        AddToBackStackFragment fragment = AddToBackStackFragment.getInstance();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.root, fragment, AddToBackStackFragment.TAG);
        //transaction.add(R.id.root, fragment, AddToBackStackFragment.TAG);
        //transaction.addToBackStack(AddToBackStackFragment.TAG);
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
