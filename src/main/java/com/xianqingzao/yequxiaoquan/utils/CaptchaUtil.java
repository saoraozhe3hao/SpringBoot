package com.xianqingzao.yequxiaoquan.utils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class CaptchaUtil {
    private static char mapTable[] = { '1', '2', '3', '4', '5', '6', '7', '8', '9', '0',
            'A', 'B', 'C', 'D', 'E', 'F','G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };

    // 获取随机颜色
    static Color getRandColor(int fc, int bc) {
        Random random = new Random();
        if (fc > 255)
            fc = 255;
        if (bc > 255)
            bc = 255;
        int r = fc + random.nextInt(bc - fc);
        int g = fc + random.nextInt(bc - fc);
        int b = fc + random.nextInt(bc - fc);
        return new Color(r, g, b);
    }

    public static Map<String, Object> getImageCode(int width, int height) {
        Map<String, Object> returnMap = new HashMap<String, Object>();
        if (width <= 0) width = 60;
        if (height <= 0) height = 20;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();
        Random random = new Random();
        g.setColor(getRandColor(200, 250));
        g.fillRect(0, 0, width, height);
        g.setFont(new Font("Times New Roman", Font.PLAIN, 18));

        g.setColor(getRandColor(160, 200));
        for (int i = 0; i < 146; i++) {
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            int x1 = random.nextInt(12);
            int y1 = random.nextInt(12);
            g.drawLine(x, y, x + x1, y + y1);         // 干扰线
        }

        String captchaCode = "";  // 验证码
        for (int i = 0; i < 4; ++i) {
            captchaCode += mapTable[(int) (mapTable.length * Math.random())];
            g.setColor(new Color(20 + random.nextInt(110), 20 + random.nextInt(110), 20 + random.nextInt(110)));
            String str = captchaCode.substring(i, i + 1);
            g.drawString(str, 13 * i + 6, 16);
        }

        g.dispose();
        returnMap.put("image", image);
        returnMap.put("value", captchaCode);
        return returnMap;
    }
}
