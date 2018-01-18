/**
 *
 */
package ges.com.genesis.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author gesco
 *
 */
public class AppInterceptor implements HandlerInterceptor {

    private static Logger log = LoggerFactory.getLogger(AppInterceptor.class);

    /**
     *
     */
    public AppInterceptor() {
        // TODO Auto-generated constructor stub
    }

    // Called before handler method invocation
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        String[] parts = request.getServletPath().split("/");

        System.out.println(request.getServletPath());
        modelAndView.addObject("approot", request.getContextPath());
        modelAndView.addObject("controller", parts[1]);
        System.out.println(request.getContextPath() + "/");
        System.out.println("1 : " + parts[1]);
        if (parts.length > 2) {
            modelAndView.addObject("action", parts[2]);
            System.out.println("2 : " + parts[2]);
        } else {
            modelAndView.addObject("action", "index");
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
            Object handler, Exception ex) throws Exception {
    }

}
