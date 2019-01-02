package www.qijianguo.com.firstcode;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import www.qijianguo.com.firstcode.view.MenuActivity;

public class MainActivity extends Activity {

    private static final String TAG = "MainActivity";

    /** 跳转MENU页面 */
    private static final int TO_MENU = 200;

    private Button mButtonMenu;
    private Button mButtonIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mButtonMenu = findViewById(R.id.btn_menu);
        mButtonMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.btn_menu:
                        startMenuActivity();
                        break;
                }
            }
        });

        mButtonIntent = findViewById(R.id.btn_intent);
        mButtonIntent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.baidu.com"));
                startActivity(intent);
            }
        });
    }


    public void startMenuActivity() {
        Intent intent = new Intent(this, MenuActivity.class);
        // startActivity(intent);
        // 返回数据给上一个活动
        startActivityForResult(intent, TO_MENU);
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
}
