package com.trj.usercenter.annotation;

import java.lang.annotation.*;

/**
 * Created by xierongli on 17/6/20.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.PARAMETER})
@Documented
public @interface Validate {

}
