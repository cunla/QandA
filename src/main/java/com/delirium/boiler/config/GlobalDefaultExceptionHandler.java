package com.delirium.boiler.config;

import com.delirium.boiler.ExceptionInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Daniel Moran on 11/12/2015.
 */
@ControllerAdvice
class GlobalDefaultExceptionHandler {
    public static final String DEFAULT_ERROR_VIEW = "error";
    private static final Logger log = LoggerFactory.getLogger(DatabaseConfiguration.class);

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(Exception.class)
    @ResponseBody
    ExceptionInfo defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        // If exception is part of the
        if (null != AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class))
            throw e;

        // Otherwise setup and send the user to a default error-view.
        ExceptionInfo exceptionInfo = new ExceptionInfo(req, e);
        log.error("Got exception {}", exceptionInfo);

        return exceptionInfo;
    }
}
