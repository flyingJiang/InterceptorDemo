package com.flying.aspect;


import com.flying.annotation.Auth;
import com.flying.exception.MyException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class RoleInterceptor {

    private static final Logger LOGGER = LoggerFactory.getLogger(RoleInterceptor.class);

    private static final String NO_AUTH = "没有权限哦！这是一个切面！";

    @Autowired
    ControllerExceptionHandler controllerExceptionHandler;

    @Around("execution(public * com.flying.controller.*.*(..)) && @annotation(auth)")
    public Object checkAuth(ProceedingJoinPoint pjp, Auth auth) throws  Throwable{
        MethodSignature signature = (MethodSignature) pjp.getSignature();
        String authString = auth.value();
        LOGGER.info("checkAuth,method: {}, clientCode={}", signature.getMethod().getName(), authString);
        // Assume that only yes and no permissions are required for authentication
        if (authString.equals("yes")){
            LOGGER.warn("checkAuth,{}", NO_AUTH);
            return controllerExceptionHandler.handleNoAuthException(new MyException(NO_AUTH));
        }else{
            return pjp.proceed();
        }
    }

}
