package android_demo.fragment.communicate.activity_fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import javax.security.auth.callback.Callback;

import android_demo.R;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by hades on 2016/1/3.
 */
public class AFragment extends Fragment {
    public static String TAG = "AFragment";

    @Bind(R.id.showReceive)
    TextView showReceive;

    @Bind(R.id.progressBar)
    ProgressBar progressBar;

    private Handler mHandler = new Handler();


    long mResult;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frament_communicate_a_layout, container, false);

        ButterKnife.bind(this, view);


        new Thread(new Runnable() {
            @Override
            public void run() {
                long result = 0;
                for (int i = 0; i < 5; i++) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    result += i;
                }

                mResult = result;
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        progressBar.setVisibility(View.INVISIBLE);
                    }
                });
            }

        }).start();

        return view;
    }

//    @OnClick(R.id.sendResult)
//    public void jumpClick() {
//
//
//    }

    @Override
    public void onResume() {
        super.onResume();

        showReceive.setText(getArguments().getString("A"));

    }

    public void setSumResult(ASendResultCallBack callBack) {
        callBack.setResult(mResult);
    }

    public interface ASendResultCallBack {
        public void setResult(long result);
    }


}
