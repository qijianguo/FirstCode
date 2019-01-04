package www.qijianguo.com.firstcode.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import www.qijianguo.com.bean.Person;
import www.qijianguo.com.firstcode.R;

/**
 * Description:
 * <p>
 * User: Administrator
 * Date: 2019-01-04
 * Time: 16:44
 */
public class ListViewAdapter extends ArrayAdapter<Person> {
    private Context mContext;
    private List<Person> mPersonList;
    private int mResourceId;

    public ListViewAdapter(@NonNull Context context, int resourceId, @NonNull List<Person> personList) {
        super(context, resourceId, personList);
        this.mContext = context;
        this.mResourceId = resourceId;
        this.mPersonList = personList;
    }

    @SuppressLint("SetTextI18n")
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view;
        ViewHolder viewHolder;
        // 优化 1
        if (convertView == null) {
            view = LayoutInflater.from(mContext).inflate(mResourceId, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.mImageViewPortrait = view.findViewById(R.id.person_portrait);
            viewHolder.mTextViewName = view.findViewById(R.id.person_name);
            viewHolder.mTextViewAge = view.findViewById(R.id.person_age);
            // 将ViewHolder存储到View中
            view.setTag(viewHolder);
        } else {
            view = convertView;
            // 从View中获取
            viewHolder = (ViewHolder) view.getTag();
        }
        Person person = mPersonList.get(position);
        viewHolder.mImageViewPortrait.setImageResource(R.mipmap.ic_launcher);
        viewHolder.mTextViewName.setText(person.getName() + position);
        viewHolder.mTextViewAge.setText(String.valueOf(person.getAge() + position));
        return view;
    }

    // 优化 2
    class ViewHolder {
        ImageView mImageViewPortrait;
        TextView mTextViewName;
        TextView mTextViewAge;
    }
}
