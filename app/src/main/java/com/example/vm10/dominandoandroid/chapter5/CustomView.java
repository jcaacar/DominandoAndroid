package com.example.vm10.dominandoandroid.chapter5;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Handler;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

public class CustomView extends View {

    private static final String TAG = CustomView.class.getSimpleName();

    private Paint mPaint;
    private TextPaint mTextPaint;
    private GestureDetector mGestureDetector;

    private Handler mHandler;
    private int mCount = 10000;

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            mCount += 155000;
            invalidate();
        }
    };

    public CustomView(Context context) {
        super(context);
    }

    public CustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onAttachedToWindow() {
        Log.e(TAG, "onAttachedToWindow");
        super.onAttachedToWindow();

        mTextPaint = new TextPaint();
        mTextPaint.setFlags(Paint.ANTI_ALIAS_FLAG);
        mTextPaint.setTextAlign(Paint.Align.LEFT);
        mTextPaint.setColor(Color.BLUE);
        float textSize = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 30, getResources().getDisplayMetrics());
        mTextPaint.setTextSize(textSize);

        mPaint = new Paint();
        mPaint.setFlags(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(Color.RED);

        mHandler = new Handler();
        mGestureDetector = new GestureDetector(getContext(), new CustomGesture());
    }

    @Override
    protected void onDetachedFromWindow() {
        Log.e(TAG, "onDetachedFromWindow");
        super.onDetachedFromWindow();
        mHandler.removeCallbacksAndMessages(null);
        mHandler = null;
        mGestureDetector = null;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Log.e(TAG, "onDraw");
        String count = String.valueOf(mCount);
        Rect bounds = new Rect();
        mTextPaint.getTextBounds(count, 0, count.length(), bounds);

        Rect aux = new Rect();
        aux.left = (getWidth()/2)-(bounds.width()/2);
        aux.top = (getHeight()/2)-(bounds.height()/2)-bounds.height();
        aux.right = bounds.width() + aux.left;
        aux.bottom = bounds.height() + aux.top;

        canvas.drawRect(aux , mPaint);
        canvas.drawText(count, (getWidth()/2)-(bounds.width()/2), (getHeight()/2)-(bounds.height()/2), mTextPaint);

        mHandler.postDelayed(runnable, 1000);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        Log.e(TAG, "onMeasure");
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e(TAG, "onTouchEvent");
        return mGestureDetector.onTouchEvent(event);
    }

    class CustomGesture extends GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onDown(MotionEvent e) {
            Log.e("CustomGesture", "onDown");
            return true;
        }

        @Override
        public boolean onSingleTapUp(MotionEvent e) {
            Log.e("CustomGesture", "onSingleTapUp");
            mHandler.removeCallbacksAndMessages(null);
            mCount = 10000;
            invalidate();
            return true;
        }
    }
}
