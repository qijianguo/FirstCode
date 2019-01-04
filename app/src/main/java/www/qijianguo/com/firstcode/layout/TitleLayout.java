package www.qijianguo.com.firstcode.layout;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import www.qijianguo.com.firstcode.R;
import www.qijianguo.com.firstcode.controller.ActivityController;
import www.qijianguo.com.firstcode.view.MainActivity;

/**
 * Description:
 * <p>
 * User: Administrator
 * Date: 2019-01-04
 * Time: 16:03
 */
public class TitleLayout extends LinearLayout implements View.OnClickListener{

    private Context mContext;

    private static final String TAG = "TitleLayout";

    public TitleLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        View view = LayoutInflater.from(context).inflate(R.layout.title, this);
        Title.mButtonBack = view.findViewById(R.id.title_back);
        Title.mButtonBack.setOnClickListener(this);
        Title.mTextView = view.findViewById(R.id.title_title);
        Title.mTextView.setOnClickListener(this);
        Title.mButtonEdit = view.findViewById(R.id.title_edit);
        Title.mButtonEdit.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.title_back:
                Log.d(TAG, "onClick: back");
                MainActivity.actionStart(mContext);
                ActivityController.removeActivity((Activity) mContext);// getContext();
                break;
            case R.id.title_title:
                Log.d(TAG, "onClick: title");
                break;
            case R.id.title_edit:
                Log.d(TAG, "onClick: edit");
                break;
            default:
                break;
        }
    }

    static class Title {
        public static Button mButtonBack;
        public static TextView mTextView;
        public static Button mButtonEdit;
    }
}
