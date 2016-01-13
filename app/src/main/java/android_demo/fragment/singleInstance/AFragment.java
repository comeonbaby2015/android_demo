package android_demo.fragment.singleInstance;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import android_demo.R;
import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by hades on 2016/1/3.
 */
public class AFragment extends Fragment {
    public static String TAG = AFragment.class.getSimpleName();
    private static int a = 0;
    private int a2 = 0;

    @Bind(R.id.jumpA)
    Button jumpA;

    @Bind(R.id.jumpB)
    Button jumpB;

    @Bind(R.id.input)
    EditText input;

    @Override

    public void onAttach(Activity activity) {
        Log.d(TAG, "-----> onAttach----");
        super.onAttach(activity);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "-----> onCreate----");
        a++;
        a2 = a;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d(TAG, "-----> onCreateView----");
        View view = inflater.inflate(R.layout.fragment_single_instance_a_layout, container, false);

        ButterKnife.bind(this, view);

        jumpA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (getFragmentManager().findFragmentByTag(AFragment.TAG) != null) {
                    getFragmentManager().popBackStack(AFragment.TAG, 0);

                } else {
                    getFragmentManager().beginTransaction().replace(R.id.root, new AFragment(), AFragment.TAG).addToBackStack(AFragment.TAG).commit();

                }
            }
        });


        jumpB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (getFragmentManager().findFragmentByTag(BFragment.TAG) != null) {
                    getFragmentManager().popBackStack(BFragment.TAG, 0);
                } else {
                    getFragmentManager().beginTransaction().replace(R.id.root, new BFragment(), BFragment.TAG).addToBackStack(BFragment.TAG).commit();
                }
            }
        });


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

        input.setText(Integer.toString(a2));
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
        a--;
        a2 = a;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(TAG, "-----> onDetach----");
    }



}
