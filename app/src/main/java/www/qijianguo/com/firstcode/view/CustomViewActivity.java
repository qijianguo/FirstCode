package www.qijianguo.com.firstcode.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import www.qijianguo.com.firstcode.R;

public class CustomViewActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_view);
    }

    public static void actionStart(Context context) {
        Intent intent = new Intent(context, CustomViewActivity.class);
        context.startActivity(intent);
    }
}
