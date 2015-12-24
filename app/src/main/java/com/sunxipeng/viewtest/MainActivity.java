package com.sunxipeng.viewtest;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewTreeObserver;
import android.widget.TextView;

/**
 * author sunxipeng
 */
public class MainActivity extends Activity {

   // private GestureDetector gestureDetector;

    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

       /* ViewGroup content = (ViewGroup) findViewById(android.R.id.content);

        content.getChildAt(0);

        Toast.makeText(this,"",Toast.LENGTH_SHORT).show();*/

        setContentView(R.layout.activity_main);

        tv = (TextView) findViewById(R.id.tv);

       /*
       //代码中动态添加布局，并且设置其参数

       //父布局
       LinearLayout ll = (LinearLayout) findViewById(R.id.ll);


        //View view = getLayoutInflater().inflate(R.layout.text,null);


        //子布局
        TextView view = new TextView(this);

        //设置子布局的padding
        view.setPadding(30,30,30,30);

        view.setText("AAAAAAAAAAAAAAAAAAA");

        view.setBackgroundColor(Color.RED);


        //设置子布局在父布局中的大小为包裹内容
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);


        //设置子布局与父布局之间的距离
        marginLayoutParams.topMargin = 10;


        //设置子布局和父布局的之间的其他参数
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(marginLayoutParams);



        ll.addView(view,layoutParams);*/


       /* //手势检测
        gestureDetector = new GestureDetector(this);

        //解决长按屏幕后无法拖动的现象
        gestureDetector.setIsLongpressEnabled(false);*/

      //  TextView textView = (TextView) findViewById(R.id.tv);




/*
        *//**
         * 此时在activity初始化的时候，View对象并没有进行测量，
         * 因此不可以在activity的生命周期中去获取View的坐标位置，
         * 因为View的measure过程和activity的生命周期是不一致的
         * 所以在这个时候获取到的数值全部都是0。
         *//*
        int left = textView.getLeft();

        int right = textView.getRight();

        int top = textView.getTop();

        int bottom = textView.getBottom();

        *//**
         * translationx和translationy是view左上角相对于父容器的偏移量
         *
         *//*
        float translationx = textView.getTranslationX();

        float translationy = textView.getTranslationY();


        *//**
         * x和y代表view左上角坐标
         *
         *//*
        float x = textView.getX();

        float y = textView.getY();

        int height = bottom-top;

        int width = right-left;


       *//* ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) textView.getLayoutParams();

        int height = layoutParams.height;

        int width = layoutParams.width;

        Log.d("textView的高=",String.valueOf(height));

        Log.d("textView的宽=",String.valueOf(width));*/

    }

   /* @Override
    public boolean onDown(MotionEvent e) {

        Log.d("gestureDetector","我触发了dowm事件");

        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {

        Log.d("gestureDetector","我触发了单击事件");

        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {

        Log.d("gestureDetector","我触发了拖动事件");

        return true;
    }

    @Override
    public void onLongPress(MotionEvent e) {

       Log.d("gestureDetector","我触发了长按事件");
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {


       Log.d("gestureDetector","我触发了快速滑动事件");
        return true;
    }


    *//**
     * 实现手势事件，必须实现ontouchEvent的方法
     * @param event
     * @return
     *//*
    @Override
    public boolean onTouchEvent(MotionEvent event) {

        return gestureDetector.onTouchEvent(event);
    }*/


    /**
     * 获取测量View的宽和高
     * @param hasFocus
     */
   /* @Override
    public void onWindowFocusChanged(boolean hasFocus) {

        super.onWindowFocusChanged(hasFocus);

        if(hasFocus){

            int width = tv.getMeasuredWidth();

            int heiht = tv.getMeasuredHeight();

            Log.d("MainActivity",String.valueOf(width));

            Log.d("MainActivity",String.valueOf(heiht));

        }
    }*/

    /**
     * 获取测量的View的宽和高
     */
/*    @Override
    protected void onStart() {
        super.onStart();

        tv.post(new Runnable() {
            @Override
            public void run() {

                int width = tv.getMeasuredWidth();

                int heiht = tv.getMeasuredHeight();

                Log.d("MainActivity", String.valueOf(width));

                Log.d("MainActivity",String.valueOf(heiht));

            }
        });
    }*/


    /**
     * 获取测量的View宽和高
     */
    @Override
    protected void onStart() {
        super.onStart();

        ViewTreeObserver observer = tv.getViewTreeObserver();
        
        observer.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {

            @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onGlobalLayout() {

                tv.getViewTreeObserver().removeOnGlobalLayoutListener(this);

                int width = tv.getMeasuredWidth();

                int heiht = tv.getMeasuredHeight();

                Log.d("MainActivity", String.valueOf(width));

                Log.d("MainActivity", String.valueOf(heiht));
            }
        });
    }
}
