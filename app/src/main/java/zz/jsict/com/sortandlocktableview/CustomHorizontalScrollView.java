package zz.jsict.com.sortandlocktableview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.HorizontalScrollView;

/**
 * Created by zz on 2018/1/11.
 * 自定义一个HorizontalScrollView，重写onScrollChanged，方便对滚动事件进行联动
 */

public class CustomHorizontalScrollView extends HorizontalScrollView {
    private CustomHorizontalScrollView.onScrollChangeListener onScrollChangeListener;

    public CustomHorizontalScrollView(Context context) {
        super(context);
    }

    public CustomHorizontalScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomHorizontalScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setOnScrollChangeListener(CustomHorizontalScrollView.onScrollChangeListener onScrollChangeListener) {
        this.onScrollChangeListener = onScrollChangeListener;
    }

    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        if(this.onScrollChangeListener != null) {
            this.onScrollChangeListener.onScrollChanged(this, l, t);
        }

    }

    public interface onScrollChangeListener {
        void onScrollChanged(HorizontalScrollView var1, int var2, int var3);
    }
}

