package www.qijianguo.com.firstcode.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Arrays;
import java.util.List;

import www.qijianguo.com.bean.Person;
import www.qijianguo.com.firstcode.R;
import www.qijianguo.com.firstcode.adapter.ListViewAdapter;

public class ListViewActivity extends BaseActivity {

    private static final String TAG = "ListViewActivity";

    private List<Person> data = Arrays.asList(
            new Person("", "张三", 23),
            new Person("", "张三", 23),
            new Person("", "张三", 23),
            new Person("", "张三", 23),
            new Person("", "张三", 23),
            new Person("", "张三", 23),
            new Person("", "张三", 23),
            new Person("", "张三", 23),
            new Person("", "张三", 23),
            new Person("", "张三", 23),
            new Person("", "张三", 23),
            new Person("", "张三", 23),
            new Person("", "张三", 23),
            new Person("", "张三", 23),
            new Person("", "张三", 23)
    );

    private ListView mListView;
    private ListViewAdapter mListViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        initView();
    }

    private void initView() {
        mListView = findViewById(R.id.list_view);

        mListViewAdapter = new ListViewAdapter(this, R.layout.list_view_item, data);
        mListView.setAdapter(mListViewAdapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.d(TAG, "onItemClick: " + data.get(i).getName() + i);
            }
        });
    }

    public static void actionStart(Context context) {
        Intent intent  = new Intent(context, ListViewActivity.class);
        context.startActivity(intent);
    }
}
