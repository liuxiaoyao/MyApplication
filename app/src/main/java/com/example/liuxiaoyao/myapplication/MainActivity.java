package com.example.liuxiaoyao.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private RelativeLayout mLayout;
    private Button mButton;
    private GestureDetector mGestureDetector = new GestureDetector(new GestureDetector.OnGestureListener() {
        @Override
        public boolean onDown(MotionEvent motionEvent) {
            Log.d(TAG,"onDown");
            return false;
        }

        @Override
        public void onShowPress(MotionEvent motionEvent) {
            Log.d(TAG,"onShowPress");
        }

        @Override
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            Log.d(TAG,"onSingleTapUp:这是单击行为");
            return false;
        }

        @Override
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
            Log.d(TAG,"onScroll:这是拖动行为");
            return false;
        }

        @Override
        public void onLongPress(MotionEvent motionEvent) {
            Log.d(TAG,"onLongPress:");
        }

        @Override
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
            Log.d(TAG,"onFling:快速滑动");
            return false;
        }
    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mGestureDetector.setOnDoubleTapListener(new GestureDetector.OnDoubleTapListener() {
            @Override
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                Log.d(TAG,"onSingleTapConfirmed:严格的单击");
                return false;
            }

            @Override
            public boolean onDoubleTap(MotionEvent motionEvent) {
                Log.d(TAG,"onDoubleTap:双击,连续的两次单击");
                return false;
            }

            @Override
            public boolean onDoubleTapEvent(MotionEvent motionEvent) {
                Log.d(TAG,"onDoubleTapEvent:双击,发生了双击行为");
                return false;
            }
        });
        mLayout = (RelativeLayout) this.findViewById(R.id.root);
        mButton = (Button) this.findViewById(R.id.btn);
        mButton.setOnTouchListener(new View.OnTouchListener() {
            private float mLastX;

            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                boolean consume = mGestureDetector.onTouchEvent(motionEvent);
                return consume;

//                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
//                    Log.d(TAG, "mButton onTouch");
//                    mLastX = motionEvent.getX();
//                    return false;
//                } else if (motionEvent.getAction() == MotionEvent.ACTION_MOVE) {
//                    float currentX = motionEvent.getX();
//                    float dx = currentX - mLastX;
//                    mLayout.scrollBy((int) -dx / 4, 0);
//                    Log.d(TAG, "mButton.getX() = " + mButton.getX() + " getLeft = " + mButton.getLeft() + " getTranslationX = " + mButton.getTranslationX()
//                            + " mButton.getScrollX()= " + mButton.getScrollX() + " mLayout.getScrollX() = " + mLayout.getScrollX());
//                }
//
//                return false;
            }
        });

    }

    public void onclick(View view) {
        //mLayout.scrollBy(50, 50);

    }
}