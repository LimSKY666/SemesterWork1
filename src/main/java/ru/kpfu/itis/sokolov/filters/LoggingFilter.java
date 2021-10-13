//package ru.kpfu.itis.sokolov.filters;
//
//import javax.servlet.*;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import java.io.IOException;
//import java.util.Arrays;
//import java.util.Map;
//
//@WebFilter(filterName = "loggingFilter", urlPatterns = "/*")
//public class LoggingFilter implements Filter {
//
//    private ServletContext context;
//
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//        this.context = filterConfig.getServletContext();
//        this.context.log("LoggingFilter initialized");
//    }
//
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException, IOException {
//        HttpServletRequest request = (HttpServletRequest) servletRequest;
//        Map<String, String[]> requestParamMap = request.getParameterMap();
//
//        if (requestParamMap != null) {
//            requestParamMap.forEach((k, v) -> this.context.log(request.getRemoteAddr() +
//                    " : Request params: {" + k + "=" + Arrays.toString(v) + "}")
//            );
//        }
//
//        filterChain.doFilter(servletRequest, servletResponse);
//    }
//
//    @Override
//    public void destroy() {
//
//    }
//}
