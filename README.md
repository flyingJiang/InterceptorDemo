# InterceptorDemo
最近基于AOP做了一个拦截并能够返回错误信息到前端的示例程序，目标
1.通过自定义注解所带参数，进入切面判断是否合法
2.合法的继续访问
3.不合法的通过自定义异常向前端返回错误信息

我能想到的有三个思路
1.filter实现
2.基于HttpServletResponse，也可以重定向
3.自定义异常+@ControllerAdvice
第一种方法，类似SpringSecurity，我没那么做。
第二种方法，无法在切面里获取HttpServletResponse对象，或是HttpServletResponse为null，所以我放弃了，我尝试了如下方法
ServletWebRequest servletContainer = (ServletWebRequest)RequestContextHolder.getRequestAttributes();
HttpServletResponse response = servletContainer.getResponse();

HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
ServletWebRequest servletWebRequest=new ServletWebRequest(request);
HttpServletResponse response=servletWebRequest.getResponse();
都不行
第三种方法，调通了，自己还无法评估优劣
