package com.rdstudio.myviewmodel;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.core.content.res.ResourcesCompat;

public class MyEditText extends androidx.appcompat.widget.AppCompatEditText {

    Drawable mClerButtonImage;

    public MyEditText(Context context) {
        super(context);
        init();
    }

    public MyEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MyEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        setHint("Masukkan Nama Anda: ");
        setTextAlignment(TEXT_ALIGNMENT_VIEW_START);
    }

    private void init() {

        mClerButtonImage = ResourcesCompat.getDrawable(getResources(), R.drawable.ic_close, null);

        setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if ((getCompoundDrawablesRelative()[2] != null)) {
                    float clearButtonStart;
                    float clearButtonEnd;
                    boolean isClearButtonClicked = false;

                    if (getLayoutDirection() == LAYOUT_DIRECTION_RTL) {
                        clearButtonEnd = mClerButtonImage.getIntrinsicWidth() + getPaddingStart();

                        if (motionEvent.getX() < clearButtonEnd) {
                            isClearButtonClicked = true;
                        }

                    } else {
                        clearButtonStart = (getWidth() - getPaddingEnd() - mClerButtonImage.getIntrinsicWidth());

                        if (motionEvent.getX() > clearButtonStart) {
                            isClearButtonClicked = true;
                        }

                    }

                    if (isClearButtonClicked) {
                        if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                            mClerButtonImage = ResourcesCompat.getDrawable(getResources(), R.drawable.ic_close, null);
                            showClearButton();
                            return true;
                        } else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                            mClerButtonImage = ResourcesCompat.getDrawable(getResources(), R.drawable.ic_close, null);
                            if (getText() != null) {
                                getText().clear();
                            }
                            hideClearButton();
                            return true;
                        } else {
                            return false;
                        }

                    } else {
                        return false;
                    }
                }
                return false;
            }
        });

        addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
                if (!charSequence.toString().isEmpty()) {
                    showClearButton();
                }
            }

            @Override
            public void afterTextChanged(Editable charSequence) {

            }
        });

    }

    private void showClearButton() {
        setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, mClerButtonImage, null);
    }

    private void hideClearButton() {
        setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, null, null);
    }
}
