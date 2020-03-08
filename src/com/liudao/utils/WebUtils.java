package com.liudao.utils;

import com.sun.org.apache.regexp.internal.RE;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @author:liudao
 * @company:null
 * @date: 2020/3/3 - 17:00
 */
public class WebUtils {
    public  static <T> T copyParamByBean(T bean, Map value) {
        try {
            BeanUtils.populate(bean, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }
    public static int parseInt(String strInt,int defaultValue) {
        try {
            return Integer.parseInt(strInt);
        } catch (Exception e) {
//            e.printStackTrace();
        }
        return defaultValue;
    }

}
