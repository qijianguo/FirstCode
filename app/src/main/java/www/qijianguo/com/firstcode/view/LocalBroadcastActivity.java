package www.qijianguo.com.firstcode.view;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import www.qijianguo.com.firstcode.R;

public class LocalBroadcastActivity extends BaseActivity implements View.OnClickListener{

    private LocalBroadcastManager mLocalBroadcastManager;
    private IntentFilter mIntentFilter;
    private LocalReceiver mLocalReceiver;

    private Button mButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_local_broadcast);
        initView();
    }

    private void initView() {
        mLocalBroadcastManager = LocalBroadcastManager.getInstance(this);
        mIntentFilter = new IntentFilter();
        mIntentFilter.addAction("www.qijianguo.com.firstcode.view.LOCAL_BROADCAST");
        mLocalReceiver = new LocalReceiver();
        mLocalBroadcastManager.registerReceiver(mLocalReceiver, mIntentFilter);
        mButton = findViewById(R.id.local_broadcast);
        mButton.setOnClickListener(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mLocalBroadcastManager.unregisterReceiver(mLocalReceiver);
    }

    @Override
    public void onClick(View view) {

    }

    class LocalReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(context, "local broadcast", Toast.LENGTH_LONG).show();
        }
    }

    public static void actionStart(Context context) {
        Intent intent = new Intent(context, LocalBroadcastActivity.class);
        context.startActivity(intent);
    }

}
