package com.lp.interceptor;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.Intercepter;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.UnmarshallingContext;
import org.springframework.cglib.transform.impl.InterceptFieldFilter;
import org.springframework.web.servlet.HandlerInterceptor;
import org.xml.sax.SAXException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //1.用户是否存在

        return true;
    }
}
