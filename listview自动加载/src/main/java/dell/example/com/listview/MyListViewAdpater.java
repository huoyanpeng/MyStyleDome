package dell.example.com.listview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

/**
 * author: 霍彦朋 (dell) .
 * date: 2017/6/7.
 * function:
 */
public class MyListViewAdpater extends BaseAdapter {
    private Context context;
    private List<ItemBean> list;

    public MyListViewAdpater(Context context, List<ItemBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        final ViewHolder viewHolder;
        if (view==null){
            view=View.inflate(context,R.layout.item_listview,null);
            viewHolder=new ViewHolder();
            viewHolder.textView= (TextView) view.findViewById(R.id.item_text);
            viewHolder.box= (CheckBox) view.findViewById(R.id.item_check);

            view.setTag(viewHolder);
        }else {
            viewHolder= (ViewHolder) view.getTag();
        }

        viewHolder.textView.setText(list.get(i).getName());
        viewHolder.box.setChecked(list.get(i).ischecked());
        ViewHolder finalViewHolder = viewHolder;
        viewHolder.box.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(list.get(i).ischecked()){
                    list.get(i).setIschecked(false);
                    viewHolder.box.setChecked(false);
                } else {
                    list.get(i).setIschecked(true);
                    viewHolder.box.setChecked(true);
                }

                notifyDataSetChanged();

            }
        });


        return view;
    }
    class ViewHolder{
        TextView textView;
        CheckBox box;
    }
}
