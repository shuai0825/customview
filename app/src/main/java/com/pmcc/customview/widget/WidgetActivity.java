package com.pmcc.customview.widget;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Parcel;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.UnderlineSpan;
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
            case 2:
                setUnderlineText();
                break;
            case 3:
                setHtmlSpanned();
                break;
        }

    }


    /**
     * 自定义样式的edittext
     */
    private void setUnderlineText() {
        DeleteEditText deleteEditText = findViewById(R.id.widget_dlt_et);
        deleteEditText.setVisibility(View.VISIBLE);
    }

    /**
     * 输入金额格式
     */
    private void setMoneyEdit() {
        MoneyEditText moneyEditText = findViewById(R.id.widget_mev);
        moneyEditText.setVisibility(View.VISIBLE);
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

    /**
     * 虽不属于自定义控件，用的地方不少，就加上了
     */
    private void setHtmlSpanned() {
        TextView htmlSptv = findViewById(R.id.widget_htmlsp_tv);
        htmlSptv.setVisibility(View.VISIBLE);
        String st = "TextView内容:";
        st = st + "<u>下划线</u>";
        st = st + "<i>斜体字</i>";
        st = st + "<font color='#ff0000'>设置字体颜色为红色</font>";
        st = st + "<strong>加粗</strong>";
        st = st + "<a href='https://www.baidu.com'>百度链接</a>";

        //指定字符串（可以用字符分隔符等一些列操作，然后添加上面的标记）
        Spanned fromHtml;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            fromHtml = Html.fromHtml(st, Html.FROM_HTML_MODE_LEGACY);
        } else {
            fromHtml = Html.fromHtml(st);
        }

        htmlSptv.setText(fromHtml);//在该处字符不可以拼接
        htmlSptv.setMovementMethod(LinkMovementMethod.getInstance());//链接跳转

    }


}
