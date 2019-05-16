package com.xianqingzao.yequxiaoquan.admin.common;

import com.xianqingzao.yequxiaoquan.utils.CaptchaUtil;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.util.Date;
import java.util.Map;

@Controller  // 注明本类是Controller Bean, Spring 容器相关注解来自org.springframework.stereotype
public class CaptchaController {

    // 获取验证码图片
    @RequestMapping("/captcha")
    public void captchaImage(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map<String, Object> map = CaptchaUtil.getImageCode(60, 20);
        request.getSession().setAttribute( "captchaCode", map.get("value").toString().toLowerCase());
        request.getSession().setAttribute("captchaTime", new Date().getTime());
        ImageIO.write((BufferedImage) map.get("image"), "JPG", response.getOutputStream());
    }
}
