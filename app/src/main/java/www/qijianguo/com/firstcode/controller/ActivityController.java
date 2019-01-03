package www.qijianguo.com.firstcode.controller;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 管理活动
 * <p>
 * User: Administrator
 * Date: 2019-01-03
 * Time: 15:30
 */
public class ActivityController {

    private static volatile List<Activity> stackActivity = new ArrayList<>();

    public static void addActivity(Activity activity) {
        if (!stackActivity.contains(activity)) {
            stackActivity.add(activity);
        }
    }

    public static void removeActivity(Activity activity) {
        if (stackActivity.contains(activity)) {
            stackActivity.remove(activity);
        }
    }

    public static void finishAllActivity() {
        stackActivity.forEach(activity -> {
            if (!activity.isFinishing()) {
                activity.finish();
                // 杀掉当前进程
                android.os.Process.killProcess(android.os.Process.myPid());
            }
        });
    }
}
