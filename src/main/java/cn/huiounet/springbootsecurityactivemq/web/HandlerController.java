package cn.huiounet.springbootsecurityactivemq.web;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.nio.file.AccessDeniedException;

/**
 * 作者 ：冷瑞阳
 * 首次编辑时间 ：2021/2/4 12:29
 */
@ControllerAdvice
public class HandlerController {

    //权限不足异常：403
    @ExceptionHandler({AccessDeniedException.class})
    public String handlerException(){
        return "redirect:/403.html";
    }

    //请求异常500页面
    @ExceptionHandler(RuntimeException.class)
    public String runtimeHandlerException(){
        return "redirect:/500.html";
    }
}
