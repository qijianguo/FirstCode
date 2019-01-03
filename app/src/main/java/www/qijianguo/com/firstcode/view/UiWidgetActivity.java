package www.qijianguo.com.firstcode.view;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import www.qijianguo.com.firstcode.R;

/**
 * 优雅的设计UI
 */
public class UiWidgetActivity extends BaseActivity implements View.OnClickListener{

    private static final String TAG = "UiWidgetActivity";

    private TextView mTextView;

    private ImageView mImageView;

    private Button mButtonShowProgressBar;
    private Button mButtonChangeImageView;
    private Button mButtonShowAlertDialog;
    private Button mButtonShowProgressDialog;

    private ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ui_widge);

        initView();
    }

    private void initView() {
        mTextView = findViewById(R.id.text_view);
        mButtonShowProgressBar = findViewById(R.id.button_show_progress_bar);
        mButtonShowProgressBar.setOnClickListener(this);
        mButtonChangeImageView = findViewById(R.id.button_change_image_view);
        mButtonChangeImageView.setOnClickListener(this);

        mButtonShowAlertDialog = findViewById(R.id.button_show_alert_dialog);
        mButtonShowAlertDialog.setOnClickListener(this);

        mButtonShowProgressDialog = findViewById(R.id.button_show_progress_dialog);
        mButtonShowProgressDialog.setOnClickListener(this);

        mImageView = findViewById(R.id.image_view);
        mProgressBar = findViewById(R.id.progress_bar);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_show_progress_bar:
                // 使用进度条
                if (mProgressBar.getVisibility() == View.GONE) {
                    int progress = mProgressBar.getProgress();
                    if (progress >= mProgressBar.getMax()) {
                        mProgressBar.setVisibility(View.GONE);
                    } else {
                        progress += 10;
                        mProgressBar.setVisibility(View.VISIBLE);
                        mProgressBar.setProgress(progress);
                    }
                } else {
                    mProgressBar.setVisibility(View.GONE);
                }
                break;
            case R.id.button_change_image_view:
                // 切换图片
                mImageView.setImageResource(R.drawable.range_percent);
                break;
            case R.id.button_show_alert_dialog:
                // 使用弹窗
                AlertDialog.Builder dialog = new AlertDialog.Builder(UiWidgetActivity.this);
                dialog.setTitle("警告");
                dialog.setMessage("something is important!");
                dialog.setCancelable(false);
                dialog.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Log.d(TAG, "onClick: ok");
                    }
                });
                dialog.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Log.d(TAG, "onClick: cancel");
                    }
                });
                dialog.show();
                break;
            case R.id.button_show_progress_dialog:
                ProgressDialog progressDialog = new ProgressDialog(this);
                progressDialog.setTitle("This is progressDialog!");
                progressDialog.setMessage("Loading...");
                progressDialog.setCancelable(true);
                progressDialog.show();
                break;
            default:
                break;
        }
    }

    public static void actionStart(Context context) {
        Intent intent = new Intent(context, UiWidgetActivity.class);
        context.startActivity(intent);
    }
}
