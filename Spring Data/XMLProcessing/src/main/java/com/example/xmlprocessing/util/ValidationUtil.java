package com.example.xmlprocessing.util;

import org.springframework.stereotype.Component;


public interface ValidationUtil {
    <E> boolean isValid(E entity);
}
