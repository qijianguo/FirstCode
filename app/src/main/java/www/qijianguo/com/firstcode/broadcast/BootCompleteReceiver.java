package www.qijianguo.com.firstcode.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Description: 静态注册广播，开机启动的广播
 * <p>
 * User: Administrator
 * Date: 2019-01-08
 * Time: 13:36
 */
public class BootCompleteReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "boot complete", Toast.LENGTH_SHORT).show();
    }
}
