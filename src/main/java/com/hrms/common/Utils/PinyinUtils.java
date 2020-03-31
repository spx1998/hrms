package com.hrms.common.Utils;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
import org.springframework.stereotype.Component;

@Component
public class PinyinUtils {

    //获取中文的拼音
    public String castToPinyin(String name) throws BadHanyuPinyinOutputFormatCombination {
        char[] charArray = name.toCharArray();
        StringBuilder pinyin = new StringBuilder();
        HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
        //设置大小写格式
        defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE );
        //设置声调格式：
        defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        for (char c : charArray) {
            //匹配中文,非中文转换会转换成null
            if (Character.toString(c).matches("[\\u4E00-\\u9FA5]+")) {
                String[] hanyuPinyinStringArray = PinyinHelper.toHanyuPinyinStringArray(c, defaultFormat);
                String string = hanyuPinyinStringArray[0];
                pinyin.append(string);
            } else {
                pinyin.append(c);
            }
        }
        return String.valueOf(pinyin);
    }
}
