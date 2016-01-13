package android_demo.fragment.lifecycle;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import android_demo.R;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by hades on 2016/1/3.
 */
public class Lifecycle2Fragment extends Fragment {
    public static String TAG = "AFragment";


    @Override

    public void onAttach(Activity activity) {
        Log.d(TAG, "-----> onAttach----");
        super.onAttach(activity);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "-----> onCreate----");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d(TAG, "-----> onCreateView----");
        View view = inflater.inflate(R.layout.fragment_lifecycle2_layout, container, false);
        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        Log.d(TAG, "-----> onActivityCreated----");
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "-----> onStart----");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "-----> onResume----");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "-----> onPause----");
    }

    @Override
    public void onStop() {
        Log.d(TAG, "-----> onStop----");
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        Log.d(TAG, "-----> onDestroyView----");
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "-----> onDestroy----");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(TAG, "-----> onDetach----");
    }

}
