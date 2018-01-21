package zz.jsict.com.sortandlocktableview;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TestActivity extends AppCompatActivity implements CustomHorizontalScrollView.onScrollChangeListener {

    private LinearLayout mainTable;
    private List<CustomHorizontalScrollView> rowList = new ArrayList<>();
    private ArrayList<String> mFirstData = new ArrayList<>();
    private TestList testList;
    private List<TestBean> testBeanList = new ArrayList<>();

    private boolean sort = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        mainTable = (LinearLayout) findViewById(R.id.mainTable);


        mFirstData.add("姓名");
        mFirstData.add("出勤");
        mFirstData.add("旷工");
        mFirstData.add("迟到");
        mFirstData.add("早退");
        mFirstData.add("请假");
        mFirstData.add("出差");
        mFirstData.add("外出");
        mFirstData.add("脱岗");
        mFirstData.add("脱岗");
        mFirstData.add("脱岗");
        mFirstData.add("脱岗");
        mFirstData.add("脱岗");

        TestBean testBean1 = new TestBean("张政1", "1", "2", "3", "4", "5");
        TestBean testBean2 = new TestBean("张政2", "2", "1", "4", "3", "5");
        TestBean testBean3 = new TestBean("张政3", "3", "2", "1", "5", "4");
        TestBean testBean4 = new TestBean("张政4", "6", "0", "1", "2", "1");
        TestBean testBean5 = new TestBean("张政5", "4", "2", "1", "4", "5");
        TestBean testBean6 = new TestBean("张政6", "9", "2", "2", "2", "2");
        TestBean testBean7 = new TestBean("张政7", "1", "2", "3", "4", "5");
        TestBean testBean8 = new TestBean("张政8", "4", "3", "2", "1", "5");
        TestBean testBean9 = new TestBean("张政9", "8", "7", "6", "5", "2");
        TestBean testBean10 = new TestBean("张政10", "10", "20", "30", "40", "50");
        {
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
        }
        //第一行
        final LinearLayout firstRow = new LinearLayout(this);
        LinearLayout.LayoutParams firstRowParam = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        firstRow.setLayoutParams(firstRowParam);
        firstRow.setOrientation(LinearLayout.HORIZONTAL);
        //第一行 第一格 【姓名】
        TextView xingming = new TextView(this);
        xingming.setTextColor(ContextCompat.getColor(this, R.color.dark));
        xingming.setTextSize(2, 16);
        xingming.setBackgroundColor(ContextCompat.getColor(this, R.color.white));
        xingming.setGravity(Gravity.CENTER);
        xingming.setText(mFirstData.get(1));
        LinearLayout.LayoutParams xingmingParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        xingmingParams.height = 60;
        xingmingParams.width = 120;
        xingming.setLayoutParams(xingmingParams);
        firstRow.addView(xingming);
        //第一行 剩下的可滑动部分
        CustomHorizontalScrollView firstScrollView = new CustomHorizontalScrollView(this);
        LinearLayout.LayoutParams firstScrollViewParam = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        firstScrollView.setLayoutParams(firstScrollViewParam);
        firstScrollView.setScrollBarSize(0);

        LinearLayout firstRowScrollPart = new LinearLayout(this);
        HorizontalScrollView.LayoutParams firstRowScrollPartParam = new HorizontalScrollView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        firstRowScrollPart.setLayoutParams(firstRowScrollPartParam);
        firstRowScrollPart.setOrientation(LinearLayout.HORIZONTAL);

        for (int i = 1; i < mFirstData.size(); i++) {
            TextView text = new TextView(this);
            text.setTextColor(ContextCompat.getColor(this, R.color.dark));
            text.setTextSize(2, 16);
            text.setBackgroundColor(ContextCompat.getColor(this, R.color.white));
            text.setGravity(Gravity.CENTER);
            text.setText(mFirstData.get(i));
            LinearLayout.LayoutParams textParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            textParams.height = 60;
            textParams.width = 120;
            text.setLayoutParams(textParams);
            text.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(sort) {
                        Collections.sort(testBeanList, new Comparator<TestBean>() {
                            @Override
                            public int compare(TestBean testBean, TestBean t1) {
                                return Integer.parseInt(testBean.getNum1()) - (Integer.parseInt(t1.getNum1()));
                            }
                        });
                        mainTable.removeAllViews();
                        mainTable.addView(firstRow);
                        generateTable();
                        sort = !sort;
                    }else{
                        Collections.sort(testBeanList, new Comparator<TestBean>() {
                            @Override
                            public int compare(TestBean testBean, TestBean t1) {
                                return Integer.parseInt(t1.getNum1()) - (Integer.parseInt(testBean.getNum1()));
                            }
                        });
                        mainTable.removeAllViews();
                        mainTable.addView(firstRow);
                        generateTable();
                        sort = !sort;
                    }
                }
            });
            firstRowScrollPart.addView(text);
        }

        firstScrollView.addView(firstRowScrollPart);
        firstScrollView.setOnScrollChangeListener(this);
        rowList.add(firstScrollView);
        firstRow.addView(firstScrollView);
        mainTable.addView(firstRow);

        generateTable();
    }


    private void generateTable() {
        //表格主体行
        for (TestBean testBean : testBeanList) {
            //创建行
            LinearLayout row = new LinearLayout(this);
            LinearLayout.LayoutParams rowParam = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            row.setLayoutParams(rowParam);
            row.setOrientation(LinearLayout.HORIZONTAL);
            //第一行 第一格 【姓名】
            TextView name = new TextView(this);
            name.setTextColor(ContextCompat.getColor(this, R.color.dark));
            name.setTextSize(2, 16);
            name.setBackgroundColor(ContextCompat.getColor(this, R.color.white));
            name.setGravity(Gravity.CENTER);
            name.setText(testBean.getName());
            LinearLayout.LayoutParams nameParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            nameParams.height = 60;
            nameParams.width = 120;
            name.setLayoutParams(nameParams);
            row.addView(name);
            //第一行 剩下的可滑动部分
            CustomHorizontalScrollView scrollView = new CustomHorizontalScrollView(this);
            LinearLayout.LayoutParams scrollViewParam = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            scrollView.setLayoutParams(scrollViewParam);
            scrollView.setScrollBarSize(0);

            LinearLayout rowScrollPart = new LinearLayout(this);
            HorizontalScrollView.LayoutParams rowScrollPartParam = new HorizontalScrollView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            rowScrollPart.setLayoutParams(rowScrollPartParam);
            rowScrollPart.setOrientation(LinearLayout.HORIZONTAL);

            TextView text1 = new TextView(this);
            text1.setTextColor(ContextCompat.getColor(this, R.color.dark));
            text1.setTextSize(2, 16);
            text1.setBackgroundColor(ContextCompat.getColor(this, R.color.white));
            text1.setGravity(Gravity.CENTER);
            text1.setText(testBean.getNum1());
            LinearLayout.LayoutParams textParams1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            textParams1.height = 60;
            textParams1.width = 120;
            text1.setLayoutParams(textParams1);
            rowScrollPart.addView(text1);

            TextView text2 = new TextView(this);
            text2.setTextColor(ContextCompat.getColor(this, R.color.dark));
            text2.setTextSize(2, 16);
            text2.setBackgroundColor(ContextCompat.getColor(this, R.color.white));
            text2.setGravity(Gravity.CENTER);
            text2.setText(testBean.getNum2());
            LinearLayout.LayoutParams textParams2 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            textParams2.height = 60;
            textParams2.width = 120;
            text2.setLayoutParams(textParams2);
            rowScrollPart.addView(text2);

            TextView text3 = new TextView(this);
            text3.setTextColor(ContextCompat.getColor(this, R.color.dark));
            text3.setTextSize(2, 16);
            text3.setBackgroundColor(ContextCompat.getColor(this, R.color.white));
            text3.setGravity(Gravity.CENTER);
            text3.setText(testBean.getNum3());
            LinearLayout.LayoutParams textParams3 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            textParams3.height = 60;
            textParams3.width = 120;
            text3.setLayoutParams(textParams3);
            rowScrollPart.addView(text3);

            TextView text4 = new TextView(this);
            text4.setTextColor(ContextCompat.getColor(this, R.color.dark));
            text4.setTextSize(2, 16);
            text4.setBackgroundColor(ContextCompat.getColor(this, R.color.white));
            text4.setGravity(Gravity.CENTER);
            text4.setText(testBean.getNum4());
            LinearLayout.LayoutParams textParams4 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            textParams4.height = 60;
            textParams4.width = 120;
            text4.setLayoutParams(textParams4);
            rowScrollPart.addView(text4);

            TextView text5 = new TextView(this);
            text5.setTextColor(ContextCompat.getColor(this, R.color.dark));
            text5.setTextSize(2, 16);
            text5.setBackgroundColor(ContextCompat.getColor(this, R.color.white));
            text5.setGravity(Gravity.CENTER);
            text5.setText(testBean.getNum4());
            LinearLayout.LayoutParams textParams5 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            textParams5.height = 60;
            textParams5.width = 120;
            text5.setLayoutParams(textParams5);
            rowScrollPart.addView(text5);

            TextView text6 = new TextView(this);
            text6.setTextColor(ContextCompat.getColor(this, R.color.dark));
            text6.setTextSize(2, 16);
            text6.setBackgroundColor(ContextCompat.getColor(this, R.color.white));
            text6.setGravity(Gravity.CENTER);
            text6.setText(testBean.getNum4());
            LinearLayout.LayoutParams textParams6 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            textParams6.height = 60;
            textParams6.width = 120;
            text6.setLayoutParams(textParams6);
            rowScrollPart.addView(text6);

            TextView text7 = new TextView(this);
            text7.setTextColor(ContextCompat.getColor(this, R.color.dark));
            text7.setTextSize(2, 16);
            text7.setBackgroundColor(ContextCompat.getColor(this, R.color.white));
            text7.setGravity(Gravity.CENTER);
            text7.setText(testBean.getNum4());
            LinearLayout.LayoutParams textParams7 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            textParams7.height = 60;
            textParams7.width = 120;
            text7.setLayoutParams(textParams7);
            rowScrollPart.addView(text7);

            TextView text8 = new TextView(this);
            text8.setTextColor(ContextCompat.getColor(this, R.color.dark));
            text8.setTextSize(2, 16);
            text8.setBackgroundColor(ContextCompat.getColor(this, R.color.white));
            text8.setGravity(Gravity.CENTER);
            text8.setText(testBean.getNum4());
            LinearLayout.LayoutParams textParams8 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            textParams8.height = 60;
            textParams8.width = 120;
            text8.setLayoutParams(textParams8);
            rowScrollPart.addView(text8);

            TextView text9 = new TextView(this);
            text9.setTextColor(ContextCompat.getColor(this, R.color.dark));
            text9.setTextSize(2, 16);
            text9.setBackgroundColor(ContextCompat.getColor(this, R.color.white));
            text9.setGravity(Gravity.CENTER);
            text9.setText(testBean.getNum4());
            LinearLayout.LayoutParams textParams9 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            textParams9.height = 60;
            textParams9.width = 120;
            text9.setLayoutParams(textParams9);
            rowScrollPart.addView(text9);

            TextView texta = new TextView(this);
            texta.setTextColor(ContextCompat.getColor(this, R.color.dark));
            texta.setTextSize(2, 16);
            texta.setBackgroundColor(ContextCompat.getColor(this, R.color.white));
            texta.setGravity(Gravity.CENTER);
            texta.setText(testBean.getNum4());
            LinearLayout.LayoutParams textParamsa = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            textParamsa.height = 60;
            textParamsa.width = 120;
            texta.setLayoutParams(textParamsa);
            rowScrollPart.addView(texta);

            TextView textb = new TextView(this);
            textb.setTextColor(ContextCompat.getColor(this, R.color.dark));
            textb.setTextSize(2, 16);
            textb.setBackgroundColor(ContextCompat.getColor(this, R.color.white));
            textb.setGravity(Gravity.CENTER);
            textb.setText(testBean.getNum4());
            LinearLayout.LayoutParams textParamsb = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            textParamsb.height = 60;
            textParamsb.width = 120;
            textb.setLayoutParams(textParamsb);
            rowScrollPart.addView(textb);

            TextView textc = new TextView(this);
            textc.setTextColor(ContextCompat.getColor(this, R.color.dark));
            textc.setTextSize(2, 16);
            textc.setBackgroundColor(ContextCompat.getColor(this, R.color.white));
            textc.setGravity(Gravity.CENTER);
            textc.setText(testBean.getNum4());
            LinearLayout.LayoutParams textParamsc = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            textParamsc.height = 60;
            textParamsc.width = 120;
            textc.setLayoutParams(textParamsc);
            rowScrollPart.addView(textc);

            scrollView.addView(rowScrollPart);
            scrollView.setOnScrollChangeListener(this);
            rowList.add(scrollView);
            row.addView(scrollView);
            mainTable.addView(row);
        }
    }

    @Override
    public void onScrollChanged(HorizontalScrollView var1, int var2, int var3) {
        for (CustomHorizontalScrollView view : rowList) {
            view.scrollTo(var2, var3);
        }
    }
}
