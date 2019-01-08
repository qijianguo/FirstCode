package www.qijianguo.com.firstcode.view;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.widget.Toast;

import www.qijianguo.com.firstcode.R;

public class BroadcastActivity extends BaseActivity {

    private NetWorkChangeReceiver mNetWorkChangeReceiver;
    private IntentFilter mIntentFilter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast);

        initView();
    }

    private void initView() {
        mIntentFilter = new IntentFilter();
        // 监听什么广播，就写相应的广播值
        mIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        mNetWorkChangeReceiver = new NetWorkChangeReceiver();
        // 注册广播接收器
        registerReceiver(mNetWorkChangeReceiver, mIntentFilter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // 动态注册一定要取消注册
        unregisterReceiver(mNetWorkChangeReceiver);
    }

    public static void actionStart(Context context) {
        Intent intent = new Intent(context, BroadcastActivity.class);
        context.startActivity(intent);
    }

    class NetWorkChangeReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            // Toast.makeText(context, "net work change!", Toast.LENGTH_SHORT).show();
            // 获取系统服务类ConnectivityManager， 其实专门管理网络连接的。
            ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
            if (networkInfo != null && networkInfo.isAvailable()) {
                Toast.makeText(context, "network is available", Toast.LENGTH_SHORT);
            } else {
                Toast.makeText(context, "network is unavailable", Toast.LENGTH_SHORT);
            }

        }
    }
}
