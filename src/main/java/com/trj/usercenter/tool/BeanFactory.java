package com.trj.usercenter.tool;

/**
 *反射实现工厂模式
 * Created by xierongli on 17/6/16.
 */
public class BeanFactory {



    /***
     * 获取对象方法
     * @param className
     * @return
     */
    @SuppressWarnings("unchecked")
    public static  <T> T getBean(String className){
        Object obj=null;
        try {
            obj= Class.forName(className).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (T)obj;
    }

    /***
     * 获取对象方法
     * @param clz
     * @return
     */
    @SuppressWarnings("unchecked")
    public static  <T> T  getBean(Class<?> clz ){
        Object obj=null;
        try {
            obj= clz.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (T)obj;
    }
}
