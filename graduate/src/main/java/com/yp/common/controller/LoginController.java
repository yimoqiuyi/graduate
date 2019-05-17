package com.yp.common.controller;


import com.google.code.kaptcha.Producer;
import com.yp.common.pojo.User;
import com.yp.common.service.UserService;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;

import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

@Controller
public class LoginController {
    @Autowired
    private UserService userService;
    @Autowired
    private Producer captchaProducer = null;
     @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(
            @RequestParam(value = "userName", required = false) String userName,
            @RequestParam(value = "userPassword", required = false) String userPassword,
            @RequestParam(value = "remember", required = false) String remember,
             Model model) {
         System.out.println("登陆用户输入的用户名：" + userName + "，密码：" + userPassword);
        String error = null;
        User user = userService.selectOneUserByName(userName);
        System.out.println(user.getUserName());
        if (userName != null && userPassword != null) {
            //初始化
            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(userName, userPassword);

            if (remember != null) {
                if (remember.equals("on")) {
                    //说明选择了记住我
                    token.setRememberMe(true);
                } else {
                    token.setRememberMe(false);
                }
            } else {
                token.setRememberMe(false);
            }

            try {
                //登录，即身份校验，由通过Spring注入的UserRealm会自动校验输入的用户名和密码在数据库中是否有对应的值
                subject.login(token);
                System.out.println("用户是否登录：" + subject.isAuthenticated());
                return "redirect:index.do";
            } catch (UnknownAccountException e) {
                e.printStackTrace();
                error = "用户账户不存在，错误信息：" + e.getMessage();
//                 JSONObject jsStr = JSONObject.parseObject(error);
            } catch (IncorrectCredentialsException e) {
                e.printStackTrace();
                error = "用户名或密码错误，错误信息：" + e.getMessage();
            } catch (LockedAccountException e) {
                e.printStackTrace();
                error = "该账号已锁定，错误信息：" + e.getMessage();
                return error;
            } catch (DisabledAccountException e) {
                e.printStackTrace();
                error = "该账号已禁用，错误信息：" + e.getMessage();
            } catch (ExcessiveAttemptsException e) {
                e.printStackTrace();
                error = "该账号登录失败次数过多，错误信息：" + e.getMessage();
            } catch (Exception e) {
                e.printStackTrace();
                error = "未知错误，错误信息：" + e.getMessage();
            }
        } else {
            error = "请输入用户名和密码";
        }
        //登录失败，跳转到login页面
        model.addAttribute("error", error);
        return "login";
    }

    @RequestMapping(value = "index")
    public ModelAndView index(ModelAndView modelAndView) {
        Subject subject = SecurityUtils.getSubject();
        Session session = (Session) subject.getSession();
        String name = (String) subject.getPrincipal();
        User user = userService.selectOneUserByName(name);
        int state=user.getState();
        if(state==0){
            modelAndView.setViewName("login");
            return  modelAndView;
        }
        session.setAttribute("user", user); //保存会话用户
        modelAndView.addObject("user", user);
        if (subject.hasRole("user")) {
            modelAndView.setViewName("view/user/index");
            return modelAndView;
        } else if (subject.hasRole("group")) {
            modelAndView.setViewName("view/group/index");
            return modelAndView;
        } else if (subject.hasRole("subpark")) {
            modelAndView.setViewName("view/subpark/index");
            return modelAndView;
        } else if (subject.hasRole("general")) {
            modelAndView.setViewName("view/general/index");
            return modelAndView;
        } else if (subject.hasRole("admin")) {
            modelAndView.setViewName("view/admin/index");
            return modelAndView;
        } else {
            modelAndView.setViewName("view/common/index");
            return modelAndView;
        }
    }

    @RequestMapping("code")
    public void getGifCode(HttpServletResponse response, HttpServletRequest request, Model model) throws IOException {
         String text = captchaProducer.createText();
        BufferedImage image = captchaProducer.createImage(text);
        request.getSession().setAttribute("kaptcha", text);
        //VerifyCode.output(image, resp.getOutputStream());// 把图片写到指定流中
        ImageIO.write(image, "JPEG", response.getOutputStream());
     }

    @RequestMapping("logout")
    public String loginOut() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "redirect:login.jsp";
    }
}

