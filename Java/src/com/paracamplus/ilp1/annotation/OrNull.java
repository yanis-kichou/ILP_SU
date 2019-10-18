package com.paracamplus.ilp1.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Target;

@Documented
@Inherited
@Target({ElementType.METHOD,
         ElementType.PARAMETER,
         ElementType.FIELD})
public @interface OrNull {
}
