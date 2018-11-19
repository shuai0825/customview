package com.pmcc.customview.widget;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.pmcc.customview.R;
import com.pmcc.customview.utils.MoneyFormat;

/**
 * 自定义view
 */
public class WidgetActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_widget);
        switchImage();
    }

    private void switchImage() {
        switch (getIntent().getIntExtra("type", 0)) {
            case 0:
                setRatioImage();
                break;
            case 1:
                setMoneyEdit();
                break;
        }

    }

    /**
     * 输入金额格式
     */
    private void setMoneyEdit() {
        MoneyEditText moneyEditText = findViewById(R.id.widget_mev);
        moneyEditText.setText(MoneyFormat.getMoneyFormat2(.987));

    }

    /**
     * 自定义宽高比的image
     */
    private void setRatioImage() {
        RatioImage ratioImage = findViewById(R.id.widget_rt);
        ratioImage.setVisibility(View.VISIBLE);
        ratioImage.setRatioSize(0.5);
    }
}
