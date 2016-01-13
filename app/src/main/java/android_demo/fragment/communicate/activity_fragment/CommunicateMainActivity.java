package android_demo.fragment.communicate.activity_fragment;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.os.Handler;
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
public class CommunicateMainActivity extends Activity {

    @Bind(R.id.showReceive)
    TextView showReceive;

    //    @Bind(R.id.jump)
//    Button jump;
    AFragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_comminicate_layout);

        ButterKnife.bind(this);

        Bundle bundle = new Bundle();
        bundle.putString("A", "123456");

        fragment = new AFragment();
        fragment.setArguments(bundle);
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.right, fragment, AFragment.TAG);
        transaction.addToBackStack(AFragment.TAG);
        transaction.commit();


    }


    @Override
    protected void onResume() {
        super.onResume();

        Handler mHandler = new Handler();

        mHandler.post(new Runnable() {
            public void run() {
                fragment.setSumResult(new AFragment.ASendResultCallBack() {
                    @Override
                    public void setResult(long result) {
                        showReceive.setText(Long.toString(result));
                    }
                });
            }
        });

    }

//    @OnClick(R.id.jump)
//    public void jumpClick() {
//        Bundle bundle = new Bundle();
//        bundle.putString("A", "123456");
//
//        fragment = new AFragment();
//        fragment.setArguments(bundle);
//        FragmentTransaction transaction = getFragmentManager().beginTransaction();
//        transaction.replace(R.id.right, fragment, AFragment.TAG);
//        transaction.addToBackStack(AFragment.TAG);
//        transaction.commit();
//    }

//    @OnClick(R.id.getResult)
//    public void getResult() {
//        fragment.setSumResult(new AFragment.ASendResultCallBack() {
//            @Override
//            public void setResult(long result) {
//                showReceive.setText(Long.toString(result));
//            }
//        });
//    }
//

}
