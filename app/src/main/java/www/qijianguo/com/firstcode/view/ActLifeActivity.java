package www.qijianguo.com.firstcode.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import www.qijianguo.com.firstcode.R;

public class ActLifeActivity extends BaseActivity implements View.OnClickListener{

    private static final String TAG = "ActLifeActivity";

    private Button mButtonMain;
    private Button mButtonNormal;
    private Button mButtonDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initData(savedInstanceState);

        setContentView(R.layout.activity_act_life);
        mButtonMain = findViewById(R.id.btn_back);
        mButtonMain.setOnClickListener(this);

        mButtonNormal = findViewById(R.id.btn_normal);
        mButtonNormal.setOnClickListener(this);
        mButtonDialog = findViewById(R.id.btn_dialog);
        mButtonDialog.setOnClickListener(this);
    }

    private void initData(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            String message = savedInstanceState.getString("message");
            Log.d(TAG, "initData: message:" + message);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: start");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: resume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: pause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: stop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: destroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart: restart");
    }


    @Override
    public void onClick(View view) {
        Intent intent = null;
        switch (view.getId()) {
            case R.id.btn_back:
                intent = new Intent(ActLifeActivity.this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_normal:
                intent = new Intent(ActLifeActivity.this, NormalActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_dialog:
                intent = new Intent(ActLifeActivity.this, DialogActivity.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    /**
     * 此方法在意外退出的时候调用，将一些重要数据放到Bundle中，在onCreate中获取Bundle（一般在onCreate中的Bundle是null）
     */
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(TAG, "onSaveInstanceState: 异常退出");
        String message = "意外退出时保存的数据";
        outState.putString("message", message);
    }

    public static void actionStart(Context context, String message) {
        Intent intent = new Intent(context, ActLifeActivity.class);
        intent.putExtra("message", message);
        context.startActivity(intent);
    }
    
    /*
01-03 06:22:56.506 4534-4534/www.qijianguo.com.firstcode D/ActLifeActivity: onStart: start
01-03 06:22:56.507 4534-4534/www.qijianguo.com.firstcode D/ActLifeActivity: onResume: resume
01-03 06:23:01.135 4534-4534/www.qijianguo.com.firstcode D/ActLifeActivity: onPause: pause
01-03 06:23:02.248 4534-4534/www.qijianguo.com.firstcode D/ActLifeActivity: onStop: stop
01-03 06:23:09.111 4534-4534/www.qijianguo.com.firstcode D/ActLifeActivity: onRestart: restart
01-03 06:23:09.111 4534-4534/www.qijianguo.com.firstcode D/ActLifeActivity: onStart: start
01-03 06:23:09.112 4534-4534/www.qijianguo.com.firstcode D/ActLifeActivity: onResume: resume
01-03 06:23:15.894 4534-4534/www.qijianguo.com.firstcode D/ActLifeActivity: onPause: pause
01-03 06:23:25.681 4534-4534/www.qijianguo.com.firstcode D/ActLifeActivity: onResume: resume
01-03 06:23:29.638 4534-4534/www.qijianguo.com.firstcode D/ActLifeActivity: onPause: pause
01-03 06:23:33.386 4534-4534/www.qijianguo.com.firstcode D/ActLifeActivity: onResume: resume
    */
}
