package bwie.com.zhangshuaikang20180806.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class FlowLayout extends ViewGroup{
    private List<List<View>> childViews = new ArrayList<>();
    private List<Integer> mLineHeigth = new ArrayList<>();

    public FlowLayout(Context context) {
        super(context,null);
    }

    public FlowLayout(Context context, AttributeSet attrs) {
        super(context, attrs,0);
    }

    public FlowLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthsize = MeasureSpec.getSize(widthMeasureSpec);
        int widthmode = MeasureSpec.getMode(widthMeasureSpec);
        int heigthsize = MeasureSpec.getSize(heightMeasureSpec);
        int heigthmode = MeasureSpec.getMode(heightMeasureSpec);

        int width = 0;
        int heigth = 0;

        int linewidth = 0;
        int lineheigth = 0;

        int childCount = getChildCount();
        for (int i = 0; i <childCount ; i++) {
            View child = getChildAt(i);

            measureChild(child,widthMeasureSpec,heightMeasureSpec);

            MarginLayoutParams lp = (MarginLayoutParams) getLayoutParams();

            int childwidth = child.getMeasuredWidth() + lp.leftMargin + lp.rightMargin;

            int childheight = child.getMeasuredHeight() + lp.topMargin + lp.bottomMargin;

            if(linewidth+childwidth>widthsize){
                width = Math.max(width, linewidth);
                linewidth = childwidth;
                heigth += childheight;
                childheight += lineheigth;
            }else{
                linewidth += childwidth;
                lineheigth = Math.max(lineheigth,childwidth);

            }
            if(i == childCount-1){
                width = Math.max(width,lineheigth);
                heigth += lineheigth;
            }
        }

    }

    @Override
    protected void onLayout(boolean b, int i, int i1, int i2, int i3) {
        childViews.clear();
        mLineHeigth.clear();

        int width = getWidth();

        int lineHeight = 0;
        int lineWidth = 0;

        List<View> lineViews = new ArrayList<View>();
        int childCount = getChildCount();

        }
}
