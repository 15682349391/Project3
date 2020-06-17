package com.wangli.utils;

import com.wangli.pojo.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @ProjectName: Project2
 * @Package: com.wangli.utils
 * @ClassName: WebUtils
 * @Author: 38272
 * @Description:
 * @Date: 2020/5/3 18:07
 * @Version: 1.0
 */
public class WebUtils {
    public static <T> T copyParamToBean(Map value, T bean){
        try {
            System.out.println("注入之前"+bean);
            BeanUtils.populate(bean, value);
            System.out.println("注入之后"+bean);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }

    public static int parseInt(String strInt,int defaultValue){
        try {
            return Integer.parseInt(strInt);
        } catch (Exception e) {
//            e.printStackTrace();
        }
        return defaultValue;
    }
}
