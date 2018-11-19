package com.pmcc.customview.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.text.Editable;
import android.text.InputType;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.EditText;

import java.lang.ref.WeakReference;

/**
 * Created by ${zhangshuai} on 2018/11/16.
 * 2751157603@qq.com
 * 输入资金的editext，保留两位小数,
 * 获取输入内容时，用getMoneyEditText（），
 * 如用getText(),注意用Double.parse()转化下避免出现类似（.23）的情况
 */
public class MoneyEditText extends android.support.v7.widget.AppCompatEditText {
    public MoneyEditText(Context context) {
        super(context);
        initLister();
    }

    public MoneyEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        initLister();
    }

    public MoneyEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initLister();
    }

    private void initLister() {
        //只可以输入小数跟"."
        setInputType(InputType.TYPE_NUMBER_FLAG_DECIMAL | InputType.TYPE_CLASS_NUMBER);
        addTextChangedListener(new MyTextWatcher(this));

    }

    public String getMoneyEditText() {
        String moneyInput = getText().toString().trim();
        if ("".equals(moneyInput)) {
            return "";
        } else {
            return String.valueOf(Double.parseDouble(moneyInput));
        }
    }

    static class MyTextWatcher implements TextWatcher {

        private final WeakReference<EditText> reference;

        public MyTextWatcher(EditText editText) {
            reference = new WeakReference<>(editText);
        }

        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence s, int i, int i1, int i2) {
            EditText editText = reference.get();
            if (editText != null) {
                if (TextUtils.isEmpty(s)) {
                    return;
                }
                //第一个字符为小数点
                if (s.toString().equals(".")) {
                    editText.setText("0.");
                    editText.setSelection(editText.getText().toString().length());
                }
                //去除01、00等首数字为0
                if (s.length() > 1 && "0".equals("" + s.charAt(0)) && !".".equals("" + s.charAt(1))) {
                    editText.setText(s.subSequence(1, s.length()));
                }
                //只能输入两位小数
                if (s.toString().contains(".")) {
                    int lastPosition = s.toString().lastIndexOf(".");
                    if (s.toString().substring(lastPosition, s.toString().length()).length() > 3) {
                        editText.setText(s.subSequence(0, lastPosition + 3));
                        editText.setSelection(editText.getText().toString().length());
                    }

                }

            }
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    }


}
