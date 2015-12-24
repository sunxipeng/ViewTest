package com.sunxipeng.viewtest;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;

/**
 * Created by Administrator on 2015/12/23.
 */
public class CustomView extends ViewGroup {


    public CustomView(Context context, AttributeSet attrs) {

        super(context, attrs);

    }


    /**
     * 用来处理点击事件和滑动事件
     *
     * @param event
     * @return
     */
    @Override
    public boolean onTouchEvent(MotionEvent event) {

        /**
         * X和Y代表的是相对于当前View左上角的坐标
         */
        float x = event.getX();

        float y = event.getY();

        /**
         * rawX和rawY代表的是相对于手机屏幕左上角的坐标
         */
        float rawX = event.getRawX();

        float rawY = event.getRawY();


        /**
         * minSlideDistance代表的是系统所能识别出的被认为是滑动的最小距离,
         * 如果两次滑动的之间的距离小于这个常量，那么系统就不认为你是在进行滑动操作。
         * 在处理滑动时，可以利用这个常量进行过滤。
         */
        int minSlideDistance = ViewConfiguration.get(getContext()).getScaledTouchSlop();

        /**
         * 关于VelocityTracker
         */

        return super.onTouchEvent(event);
    }

    /**
     * 用来进行事件的分发，返回结果受当前View的OnTouchEvent和下级View的dispatchTouchEvent方法的影响
     *
     * @param event
     * @return
     */
    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {

        return super.dispatchTouchEvent(event);
    }


    /**
     * 表示是否拦截某个事件
     *
     * @param ev
     * @return
     */
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return super.onInterceptTouchEvent(ev);
    }


    /**
     * 表示事件分发机制的伪代码
     */
    public boolean mydispatchTouchEvent(MotionEvent event) {

        //表示子布局的viewgroup
        View view = null;

        //表示默认的向下进行事件的分发
        boolean consume = false;

        if (onInterceptTouchEvent(event)) {

            consume = onTouchEvent(event);

        } else {

            consume = view.dispatchTouchEvent(event);

        }

        return consume;
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        super.onMeasure(widthMeasureSpec, heightMeasureSpec);



    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {


    }


    @Override
    public void setWillNotDraw(boolean willNotDraw) {
        super.setWillNotDraw(false);
    }


    /**
     * 绘制自己
     * @param canvas
     */
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


    }

    /**
     * 绘制childern,通过遍历所有的子元素的draw方法，
     * 如此draw事件就一层一层的传递下去了
     *
     * @param canvas
     */
    @Override
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
    }



}
