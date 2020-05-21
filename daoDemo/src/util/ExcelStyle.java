package util;

import jxl.format.Border;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;

import static jxl.format.Alignment.CENTRE;
import static jxl.format.BorderLineStyle.DASHED;
import static jxl.format.Colour.VIOLET;
import static jxl.format.Pattern.GRAY_75;

public class ExcelStyle {
    public static WritableCellFormat setTitleStyle() throws Exception {   //设置excel的标题的函数
        /*Time字体，大小12，加粗，对齐方式居中，背景颜色紫罗兰，背景样式GRAY_75,边框虚线完全*/
        WritableFont font = new WritableFont(WritableFont.TIMES, 12, WritableFont.BOLD);
        WritableCellFormat wcf = new WritableCellFormat(font);
        wcf.setAlignment(CENTRE);
        wcf.setBackground(VIOLET, GRAY_75);
        wcf.setBorder(Border.ALL, DASHED);
        return wcf;
    }

    public static WritableCellFormat setNormalStyle() throws Exception {  //设置普通单元格的函数
        /*字体TAHOMA，字号8，对齐方式居中*/
        WritableFont font = new WritableFont(WritableFont.TAHOMA, 8);
        WritableCellFormat wcf = new WritableCellFormat(font);
        wcf.setAlignment(CENTRE);
        return wcf;
    }
}
