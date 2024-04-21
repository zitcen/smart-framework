package com.ztc.smart.farmework.helper;

import com.ztc.smart.farmework.annotation.Action;
import com.ztc.smart.farmework.annotation.Inject;
import com.ztc.smart.farmework.bean.Handler;
import com.ztc.smart.farmework.bean.Request;
import com.ztc.smart.farmework.util.ArrayUtil;
import com.ztc.smart.farmework.util.CollectionUtil;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName ControllerHelper
 * @Description 控制器助手
 * @Author ztc
 * @Date 2024/4/21 11:12
 */
public final class ControllerHelper {

    /***
     * @Author ztc
     * @Description 用于存放请求与处理器的映射关系
     * @Date 2024/4/21
     * @param null
     * @return null
     *
    **/
    private static final Map<Request, Handler> ACTION_MAP = new HashMap<>();

    static {
        //获取所有的 controller 类
        Set<Class<?>> controllerClassSet = ClassHelper.getControllerClass();
        if (CollectionUtil.collectionIsNotEmpty(controllerClassSet)) {
            //遍历这些 Controller 类
            for (Class<?> controllerClass : controllerClassSet) {
                Method[] methods = controllerClass.getDeclaredMethods();
                if (ArrayUtil.isNotEmpty(methods)) {
                    //遍历这些 Controller 类中的方法
                    for (Method method : methods) {
                        // 判断当前方法是否带有 Action 注解
                        if (method.isAnnotationPresent(Action.class)) {
                            //从 Action 注解中获取 URL 映射关系
                            Action action = method.getAnnotation(Action.class);
                            String mapping = action.value();
                            //验证 URL 映射关系
                            if (mapping.matches("\\w+:/\\w*")) {
                                String[] split = mapping.split(":");
                                if(ArrayUtil.isNotEmpty(split) && split.length == 2){
                                    //获取请求方法与路径
                                    String requestMethod = split[0];
                                    String requestPath = split[1];
                                    Request request = new Request(requestMethod, requestPath);
                                    Handler handler = new Handler(Request.class, method);
                                    //初始化 Action Map
                                    ACTION_MAP.put(request,handler);
                                }
                            }
                        }
                    }
                }

            }
        }
    }

    /***
     * @Author ztc
     * @Description 获取 Handler
     * @Date 2024/4/21
     * @param requestMethod
     * @param requestPath 
     * @return com.ztc.smart.farmework.bean.Handler
     * 
    **/
    public static Handler getHandler(String requestMethod, String requestPath){
        Request request = new Request(requestMethod, requestPath);
        return ACTION_MAP.get(request);
    }
}
