package com.adeneo.tp_android.app_film.custom_controls;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.adeneo.tp_android.app_film.R;

public class CustomAppBar extends RelativeLayout {

    Button backButtonChevron;
    TextView mainTitleTextView;
    Button closeButton;
    RelativeLayout mainLayout;


    public CustomAppBar(Context context) {
        super(context);
        initialize(context);
    }

    public CustomAppBar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initialize(context, attrs);
    }

    public CustomAppBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initialize(context, attrs);
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public CustomAppBar(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    private void initialize(Context context) {
        inflate(context, R.layout.appbar_layout, this);
        this.backButtonChevron = findViewById(R.id.appbar_layout_backButton);
        this.mainTitleTextView = findViewById(R.id.appbar_layout_mainTitle);
        this.closeButton = findViewById(R.id.appbar_layout_closeButton);
    }

    private void initialize(Context context, AttributeSet attrs) {
        inflate(context, R.layout.appbar_layout, this);
        this.backButtonChevron = findViewById(R.id.appbar_layout_backButton);
        this.mainTitleTextView = findViewById(R.id.appbar_layout_mainTitle);
        this.closeButton = findViewById(R.id.appbar_layout_closeButton);
        this.mainLayout = findViewById(R.id.appbar_layout_mainLayout);

        if (attrs != null) {
            TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.CustomAppBar, 0, 0);

            String mainTitle = array.getString(R.styleable.CustomAppBar_textMainTitle);
            if (this.mainTitleTextView != null) {
                this.mainTitleTextView.setText(mainTitle);
            }

            String backButtonChevron = array.getString(R.styleable.CustomAppBar_textBackButton);
            if (this.backButtonChevron != null) {
                this.backButtonChevron.setText(backButtonChevron);
            }

            int layout = array.getResourceId(R.styleable.CustomAppBar_mainLayoutColor, 0);
            if (this.mainLayout != null) {
                this.mainLayout.setBackgroundColor(getResources().getColor(layout));
            }

            array.recycle();

        }

    }

}
