package com.pmcc.customview.utils;

import java.text.DecimalFormat;

/**
 * Created by ${zhangshuai} on 2018/11/16.
 * 2751157603@qq.com
 */
public class MoneyFormat {

    /**
     * 资金格式（科学计数、加小数点后两位（四舍五入））
     * @param inputMoney
     * @return
     */
    public static String getMoneyFormat2(double inputMoney) {
        DecimalFormat decimalFormat = new DecimalFormat("#,###.##");
        return decimalFormat.format(inputMoney);
    }

}
