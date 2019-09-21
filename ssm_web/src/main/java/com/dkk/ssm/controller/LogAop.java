package com.dkk.ssm.controller;

import com.dkk.ssm.domain.SysLog;
import com.dkk.ssm.service.SysLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * @author: ldk
 * @program: ssm_dk
 * @create: 2019-08-10 21:00
 * @description:
 **/
@Aspect
@Component
public class LogAop {

    //HttpServletRequest的bean对象通过web.xml中的ContextLoaderListener来创建
    @Autowired
    private HttpServletRequest request;

    @Autowired
    private SysLogService sysLogService;

    private Date startTime;
    private Class executionClass;
    private Method executionMethod;

    @Before("execution(* com.dkk.ssm.controller.*.*(..))")
    public void doBefore(JoinPoint jp) throws NoSuchMethodException {

        startTime=new Date(); //方法开始执行的时间
        executionClass=jp.getTarget().getClass(); //方法所在的类
        String methodName=jp.getSignature().getName();// 方法名
        Object[] args=jp.getArgs();  // 方法参数

        if(args==null||args.length==0){
            executionMethod=executionClass.getMethod(methodName); //无参数方法
        }else{
            Class[] argsClass=new Class[args.length];
            for (int i=0;i<args.length;i++){
                argsClass[i]=args[i].getClass();
            }
            executionMethod=executionClass.getMethod(methodName,argsClass); //含参数方法
        }
    }

    @After("execution(* com.dkk.ssm.controller.*.*(..))")
    public void After() throws Exception {
        if(executionClass!=SysLogController.class){

            RequestMapping classAnnotation=(RequestMapping)executionClass.getAnnotation(RequestMapping.class);
            if(classAnnotation!=null){
                RequestMapping methodAnnotation=executionMethod.getAnnotation(RequestMapping.class);
                if(methodAnnotation!=null){

                    //封装方法访问日志数据的对象
                    SysLog sysLog=new SysLog();

                    //被访问方法名称
                    sysLog.setMethod("[类名]"+executionClass.getName()+"[方法名]"+executionMethod.getName());
                    //被访问方法url
                    String url=classAnnotation.value()[0]+methodAnnotation.value()[0];
                    sysLog.setUrl(url);

                    //访问起始时间
                    sysLog.setVisitTime(startTime);
                    //访问持续时间
                    sysLog.setExecutionTime(new Date().getTime()-startTime.getTime());

                    //访问用户客户主机的ip
                    String ip=request.getRemoteAddr();
                    sysLog.setIp(ip);
                    //获取访问用户的用户名
                    SecurityContext context= SecurityContextHolder.getContext();
                    String username=((User) context.getAuthentication().getPrincipal()).getUsername();
                    sysLog.setUsername(username);

                    //保存日志数据到数据库
                    sysLogService.save(sysLog);
                }
            }

        }
    }

}
