package com.rdstudio.myviewmodel;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;

public class MyButton extends androidx.appcompat.widget.AppCompatButton {
    public MyButton(Context context) {
        super(context);
    }

    public MyButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    // Use onDraw from View class to change Button shape
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
}
