package www.qijianguo.com.firstcode.view;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import www.qijianguo.com.firstcode.R;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    private static final String TAG = "MainActivity";

    /** 跳转MENU页面 */
    private static final int TO_MENU = 200;

    private Button mButtonMenu;
    private Button mButtonIntent;
    private Button mButtonLife;
    private Button mButtonUiWidget;
    private Button mButtonCustomView;
    private Button mButtonListView;
    private Button mButtonBroadcast;
    private Button mButtonCustomBroadcast;
    private Button mButtonLocalBroadcast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mButtonMenu = findViewById(R.id.btn_menu);
        mButtonMenu.setOnClickListener(this);

        mButtonIntent = findViewById(R.id.btn_intent);
        mButtonIntent.setOnClickListener(this);

        mButtonLife = findViewById(R.id.btn_life);
        mButtonLife.setOnClickListener(this);

        mButtonUiWidget = findViewById(R.id.btn_ui_widget);
        mButtonUiWidget.setOnClickListener(this);

        mButtonCustomView = findViewById(R.id.btn_custom_view);
        mButtonCustomView.setOnClickListener(this);

        mButtonListView = findViewById(R.id.btn_list_view);
        mButtonListView.setOnClickListener(this);

        mButtonBroadcast = findViewById(R.id.btn_broadcast);
        mButtonBroadcast.setOnClickListener(this);

        mButtonCustomBroadcast = findViewById(R.id.btn_custom_broadcast);
        mButtonCustomBroadcast.setOnClickListener(this);

        mButtonLocalBroadcast = findViewById(R.id.btn_local_broadcast);
        mButtonLocalBroadcast.setOnClickListener(this);

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // requestCode 请求码
        // resultCode 结果码
        // data 数据
        Log.d(TAG, String.format("onActivityResult: resultCode=%s", resultCode));
        switch (requestCode) {
            case TO_MENU:
                switch (resultCode) {
                    case RESULT_OK:
                        String menu = data.getStringExtra("menu");
                        Toast.makeText(this, "menu:" + menu, Toast.LENGTH_LONG).show();
                        break;
                    case RESULT_CANCELED:
                        break;
                }
                break;
                
        }

    }

    @Override
    public void onClick(View view) {
        Intent intent = null;
        switch (view.getId()) {
            case R.id.btn_menu:
                intent = new Intent(this, MenuActivity.class);
                // startActivity(intent);
                // 返回数据给上一个活动
                startActivityForResult(intent, TO_MENU);
                break;
            case R.id.btn_intent:
                intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.baidu.com"));
                startActivity(intent);
                break;
            case R.id.btn_life:
                intent = new Intent(MainActivity.this, ActLifeActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.btn_ui_widget:
                UiWidgetActivity.actionStart(this);
                finish();
                break;
            case R.id.btn_custom_view:
                CustomViewActivity.actionStart(this);
                finish();
                break;
            case R.id.btn_list_view:
                ListViewActivity.actionStart(this);
                finish();
                break;
            case R.id.btn_broadcast:
                BroadcastActivity.actionStart(this);
                break;
            case R.id.btn_custom_broadcast:
                intent = new Intent("www.qijianguo.com.firstcode.broadcast.CUSTOM_BROADCAST");
                sendBroadcast(intent);
                // 发送有序广播
                // sendOrderedBroadcast(intent, null);
                break;
            case R.id.btn_local_broadcast:
                LocalBroadcastActivity.actionStart(this);
                break;
            default:
                break;
        }
    }

    public static void actionStart(Context context) {
        Intent intent  = new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }
}
