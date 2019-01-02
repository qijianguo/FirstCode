package www.qijianguo.com.firstcode.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import www.qijianguo.com.firstcode.MainActivity;
import www.qijianguo.com.firstcode.R;

public class MenuActivity extends Activity {

    private Button mButtonBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        initView();
    }

    private void initView() {
        mButtonBack = findViewById(R.id.btn_back);
        mButtonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.btn_back:
                        Intent intent = new Intent(MenuActivity.this, MainActivity.class);
                        intent.putExtra("menu", "menu111");
                        // 重要：专门向上一个活动传递数据的
                        setResult(RESULT_OK, intent);
                        finish();
                        break;
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_item:
                Toast.makeText(MenuActivity.this, "点击了add_item", Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(MenuActivity.this, "点击了remove_item", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra("menu", "menu111");
        setResult(RESULT_OK, intent);
        finish();
    }
}
