package com.dongfu.util;

import java.io.UnsupportedEncodingException;

/**
 * Created by Fordring on 2016/8/30.
 */
public class BookType {

    public static String getBookTypeName(String bookType) throws UnsupportedEncodingException {
        int i = Integer.valueOf(bookType);
        String bookTypeName = "";
        switch (i) {
            case 0:
                bookTypeName = "其他";
                break;
            case 1:
                bookTypeName = "玄幻魔法";
                break;
            case 2:
                bookTypeName = "武侠修真";
                break;
            case 3:
                bookTypeName = "都市言情";
                break;
            case 4:
                bookTypeName = "历史军事";
                break;
            case 5:
                bookTypeName = "侦探推理";
                break;
            case 6:
                bookTypeName = "网游动漫";
                break;
            case 7:
                bookTypeName = "科幻小说";
                break;
            case 8:
                bookTypeName = "恐怖灵异";
                break;
            case 9:
                bookTypeName = "散文诗词";
                break;
            case 10:
                bookTypeName = "完本小说";
                break;
        }
        return bookTypeName;
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        System.out.println(getBookTypeName("1"));
    }
}
