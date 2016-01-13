package android_demo.fragment.addToBackStack;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import android_demo.R;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by hades on 2016/1/3.
 */
public class AddToBackStackFragment extends Fragment {
    static int num = 0;
    public static String TAG = "AddToBackStackFragment";


    private static AddToBackStackFragment fragment = null;

    public static AddToBackStackFragment getInstance() {
        if (fragment == null) {
            fragment = new AddToBackStackFragment();
        }
        return fragment;
    }

    @Bind(R.id.jump)
    Button jumpBtn;

    @Bind(R.id.num)
    TextView numTv;

    @Override

    public void onAttach(Activity activity) {
        Log.d(TAG, "-----> onAttach----");
        super.onAttach(activity);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "-----> onCreate----");
        num++;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d(TAG, "-----> onCreateView----");
        View view = inflater.inflate(R.layout.fragment_add_to_back_stack_layout, container, false);
        ButterKnife.bind(this, view);

        Toast.makeText(getActivity(), Integer.toString(num), Toast.LENGTH_SHORT).show();
        //numTv.setText(Integer.toString(num));
        return view;
    }

    @OnClick(R.id.jump)
    public void jumpTo() {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        AddToBackStack2Fragment fragment = new AddToBackStack2Fragment();
        transaction.replace(R.id.root, fragment, AddToBackStack2Fragment.TAG);
       // transaction.addToBackStack(AddToBackStack2Fragment.TAG);
        transaction.commit();
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
