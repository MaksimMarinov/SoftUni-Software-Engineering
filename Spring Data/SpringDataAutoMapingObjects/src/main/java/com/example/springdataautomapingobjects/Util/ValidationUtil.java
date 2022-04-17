package com.example.springdataautomapingobjects.Util;

import javax.validation.ConstraintViolation;
import java.util.Set;

public interface ValidationUtil {

   <E> boolean isValid(E entity);

   <E> Set<ConstraintViolation<E>> violation(E entity);
}
