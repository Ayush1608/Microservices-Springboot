package com.self.netflixzuulapigatewayserver.filter;


import javax.servlet.http.HttpServletRequest;

import java.util.logging.Logger;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


@Component
@Slf4j
public class ZuulLoggingFilter extends ZuulFilter {

  @Override public String filterType() {
    return "pre"; // before the request has executed.
//    return "post"; // after the request has executed.
//    return "error"; // at the time of error requests.
  }

  @Override public int filterOrder() {
    return 1;
  }

  @Override public boolean shouldFilter() {
    return true;
  }

  @Override public Object run() throws ZuulException {
    HttpServletRequest httpServletRequest = RequestContext.getCurrentContext().getRequest();
    log.info("request -> {} request uri -> {}", httpServletRequest, httpServletRequest.getRequestURI());
    return null;
  }
}
