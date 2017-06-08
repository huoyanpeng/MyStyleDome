package dell.example.com.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private List<ItemBean> list=new ArrayList<>();
    private List<ItemBean> list02=new ArrayList<>();
    private Button button;
    private boolean checked;
    private int mFotalItemCount,mVisibleItemCount,mFirstVisibleItem;
    private boolean falg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initDate();

        final MyListViewAdpater adapter=new MyListViewAdpater(this,list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for(int i=0;i<list.size();i++){
                    if(!checked){
                        list.get(i).setIschecked(true);
                    }else {
                        list.get(i).setIschecked(false);
                    }
                }
                adapter.notifyDataSetChanged();
                if(!checked){
                    checked = true;
                }else {
                    checked = false;
                }

            }
        });
        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if(i == AbsListView.OnScrollListener.SCROLL_STATE_IDLE ) {

                    if (100==list.size()){
                        return;
                    }else {
                        //滚动停止
                        if (mFotalItemCount - mVisibleItemCount - mFirstVisibleItem <= 5) {
                            for (int j = 50; j < 100; j++) {
                                ItemBean itemBean = new ItemBean();
                                itemBean.setName("测试数据" + j);
                                list.add(itemBean);
                            }
                            adapter.notifyDataSetChanged();
                        }
                    }

                }
            }

            @Override
            public void onScroll(AbsListView absListView, int i, int i1, int i2) {

                    mFirstVisibleItem=i;
                    mVisibleItemCount=i1;
                    mFotalItemCount=i2;
            }
        });

    }

    private void initDate() {
        for (int i = 0; i <50 ; i++) {
            ItemBean itemBean=new ItemBean();
            itemBean.setName("测试数据"+i);
            list.add(itemBean);
        }
        for (int i = 50; i <100; i++) {
            ItemBean itemBean = new ItemBean();
            itemBean.setName("测试数据"+50);
            list02.add(itemBean);
        }
    }

    private void initView() {
        listView = (ListView) findViewById(R.id.listView);
        button = (Button) findViewById(R.id.butt);
    }
}
