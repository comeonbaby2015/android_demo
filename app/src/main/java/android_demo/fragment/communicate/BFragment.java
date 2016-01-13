package android_demo.fragment.communicate;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import android_demo.R;
import android_demo.fragment.communicate.activity_fragment.AFragment;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by hades on 2016/1/3.
 */
public class BFragment extends Fragment {
    public static String TAG = "BFragment";

    @Bind(R.id.showReceive)
    TextView showReceive;

    @Bind(R.id.jump)
    Button jump;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frament_communicate_a_layout, container, false);

        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

        showReceive.setText(getArguments().getString("A"));

    }

    @OnClick(R.id.jump)
    public void jumpClick() {
        Bundle bundle = new Bundle();
        bundle.putString("A", "2");

        AFragment fragment = new AFragment();
        fragment.setArguments(bundle);
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.root, fragment, BFragment.TAG);
        transaction.addToBackStack(BFragment.TAG);
        transaction.commit();
    }
}
