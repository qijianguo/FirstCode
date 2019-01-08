package www.qijianguo.com.firstcode.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class CustomReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "custom broadcast", Toast.LENGTH_LONG).show();
        // 截断这条广播，后面的广播接收器再无法收到这条广播
        abortBroadcast();
    }
}
