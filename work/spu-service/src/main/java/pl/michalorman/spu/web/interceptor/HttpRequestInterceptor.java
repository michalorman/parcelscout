package pl.michalorman.spu.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class HttpRequestInterceptor extends HandlerInterceptorAdapter {

    private static Logger logger = LoggerFactory.getLogger(HttpRequestInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("Request received [URL: '{}', Accept: '{}', Query String: '{}']",
                new Object[] { request.getRequestURI(), request.getHeader("Accept"), request.getQueryString() });
        //        long startTime = System.currentTimeMillis();
        //        request.setAttribute("startTime", startTime);
        return true;
    }

    //    @Override
    //    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
    //            ModelAndView modelAndView) throws Exception {
    //        long startTime = (Long) request.getAttribute("startTime");
    //        long endTime = System.currentTimeMillis();
    //        logger.info("Response send [Content-Type: '{}', Response Body: '{}']. Generated in {} ms.", new Object[] { "",
    //                "", endTime - startTime });
    //    }
}
