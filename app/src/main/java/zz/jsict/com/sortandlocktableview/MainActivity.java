package zz.jsict.com.sortandlocktableview;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ////////////////////子控件////////////////////
    private TextView firstTV;
    private CustomHorizontalScrollView mFirstRow;
    private RecyclerView mRecyclerView;

    private ArrayList<String> mFirstData = new ArrayList<>();
    private TestList testList;
    private List<TestBean> testBeanList = new ArrayList<>();

    private List<CustomHorizontalScrollView> viewList = new ArrayList<>();
    ////////////////////宽高////////////////////
    /**
     * 第一列的宽
     */
    private int firstLineWidth;
    /**
     * 第一行的高
     */
    private int firstRowHeight;
    /**
     * 第一列以及表格主体的高
     */
    private int mainHeight;
    /**
     * 第一行以及表格主体的宽
     */
    private int mainWidth;

    ////////////////////颜色////////////////////
    /**
     * 第一列背景色
     */
    private int firstLineBGColorId;
    /**
     * 第一列文字色
     */
    private int firstLineTextColorId;
    /**
     * 第一行背景色
     */
    private int firstRowBGColorId;
    /**
     * 第一行文字色
     */
    private int firstRowTextColorId;
    /**
     * 主体背景色
     */
    private int mainBGColorId;
    /**
     * 主体文字色
     */
    private int mainTextColorId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstTV = (TextView) findViewById(R.id.firstElement);
        mFirstRow = (CustomHorizontalScrollView) findViewById(R.id.firstLockedRow);
        mRecyclerView = (RecyclerView) findViewById(R.id.main);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        MyAdapter myAdapter = new MyAdapter();
        mRecyclerView.setAdapter(myAdapter);

        generateFirstLine();
        generateMain();
    }

    private void generateFirstLine() {
        firstTV.setText("姓名");
        mFirstData.add("出勤");
        mFirstData.add("旷工");
        mFirstData.add("迟到");
        mFirstData.add("早退");
        mFirstData.add("请假");
        mFirstData.add("出差");
        mFirstData.add("外出");
        mFirstData.add("脱岗");

        LinearLayout linearLayout = new LinearLayout(this);
        HorizontalScrollView.LayoutParams llParams = new HorizontalScrollView.LayoutParams(HorizontalScrollView.LayoutParams.MATCH_PARENT, HorizontalScrollView.LayoutParams.WRAP_CONTENT);
        linearLayout.setOrientation(LinearLayout.HORIZONTAL);
        linearLayout.setLayoutParams(llParams);
        for (String str : mFirstData) {
            TextView textView = new TextView(this);
            textView.setTextColor(ContextCompat.getColor(this, R.color.dark));
            textView.setTextSize(2, 16);
            textView.setGravity(Gravity.CENTER);
            textView.setText(str);
            LinearLayout.LayoutParams textViewParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            textViewParams.height = 60;
            textViewParams.width = 120;
            textView.setLayoutParams(textViewParams);
            linearLayout.addView(textView);
        }
        mFirstRow.addView(linearLayout);
    }

    private void generateMain() {
        TestBean testBean1 = new TestBean("张政1", "1", "2", "3", "4", "5");
        TestBean testBean2 = new TestBean("张政2", "1", "2", "3", "4", "5");
        TestBean testBean3 = new TestBean("张政3", "1", "2", "3", "4", "5");
        TestBean testBean4 = new TestBean("张政4", "1", "2", "3", "4", "5");
        TestBean testBean5 = new TestBean("张政5", "1", "2", "3", "4", "5");
        TestBean testBean6 = new TestBean("张政6", "1", "2", "3", "4", "5");
        TestBean testBean7 = new TestBean("张政7", "1", "2", "3", "4", "5");
        TestBean testBean8 = new TestBean("张政8", "1", "2", "3", "4", "5");
        TestBean testBean9 = new TestBean("张政9", "1", "2", "3", "4", "5");
        TestBean testBean10 = new TestBean("张政10", "1", "2", "3", "4", "5");
        testBeanList = new ArrayList<>();
        testBeanList.add(testBean1);
        testBeanList.add(testBean2);
        testBeanList.add(testBean3);
        testBeanList.add(testBean4);
        testBeanList.add(testBean5);
        testBeanList.add(testBean6);
        testBeanList.add(testBean7);
        testBeanList.add(testBean8);
        testBeanList.add(testBean9);
        testBeanList.add(testBean10);
        testList = new TestList(testBeanList);

        for (int i = 0; i < testBeanList.size(); i++) {

//            viewList.add();
        }
    }

    class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

        @Override
        public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.item_table, parent, false);
            return new MyViewHolder(view);
        }

        @Override
        public void onBindViewHolder(MyAdapter.MyViewHolder holder, int position) {
            holder.name.setText(testBeanList.get(position).getName());

            LinearLayout linearLayout = new LinearLayout(MainActivity.this);
            HorizontalScrollView.LayoutParams llParams = new HorizontalScrollView.LayoutParams(HorizontalScrollView.LayoutParams.MATCH_PARENT, HorizontalScrollView.LayoutParams.WRAP_CONTENT);
            linearLayout.setLayoutParams(llParams);
            linearLayout.setOrientation(LinearLayout.HORIZONTAL);

            for (int i = 0; i < testBeanList.size(); i++) {
                TextView textView1 = new TextView(MainActivity.this);
                textView1.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.dark));
                textView1.setTextSize(2, 16);
                textView1.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.white));
                textView1.setGravity(Gravity.CENTER);
                textView1.setText(testBeanList.get(i).getNum1());
                LinearLayout.LayoutParams textViewParams1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                textViewParams1.height = 60;
                textViewParams1.width = 120;
                textView1.setLayoutParams(textViewParams1);
                linearLayout.addView(textView1);

                TextView textView2 = new TextView(MainActivity.this);
                textView2.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.dark));
                textView2.setTextSize(2, 16);
                textView2.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.white));
                textView2.setGravity(Gravity.CENTER);
                textView2.setText(testBeanList.get(i).getNum1());
                LinearLayout.LayoutParams textViewParams2 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                textViewParams1.height = 60;
                textViewParams1.width = 120;
                textView2.setLayoutParams(textViewParams2);
                linearLayout.addView(textView2);
            }
            holder.scrollView.addView(linearLayout);
        }

        @Override
        public int getItemCount() {
            return testBeanList.size();
        }

        class MyViewHolder extends RecyclerView.ViewHolder {

            private TextView name;
            private CustomHorizontalScrollView scrollView;

            public MyViewHolder(View itemView) {
                super(itemView);
                name = itemView.findViewById(R.id.item_myTable_name);
                scrollView = itemView.findViewById(R.id.item_myTable_content);
//                scrollView.setOnScrollChangeListener(new CustomHorizontalScrollView.onScrollChangeListener() {
//                    @Override
//                    public void onScrollChanged(HorizontalScrollView var1, int var2, int var3) {
//                        if(this.mScrollViews.size() > 0) {
//                            if(this.mTableViewListener != null) {
//                                this.mTableViewListener.onTableViewScrollChange(var2, var3);
//                            }
//
//                            for(int i = 0; i < this.mScrollViews.size(); ++i) {
//                                HorizontalScrollView scrollView = (HorizontalScrollView)this.mScrollViews.get(i);
//                                scrollView.scrollTo(var2, var3);
//                            }
//                        }
//                    }
//                });
            }
        }
    }
}
