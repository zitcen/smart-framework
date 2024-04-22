package com.ztc.smart.farmework;

import com.ztc.smart.farmework.bean.Data;
import com.ztc.smart.farmework.bean.Handler;
import com.ztc.smart.farmework.bean.Param;
import com.ztc.smart.farmework.bean.View;
import com.ztc.smart.farmework.helper.BeanHelper;
import com.ztc.smart.farmework.helper.ConfigHelper;
import com.ztc.smart.farmework.helper.ControllerHelper;
import com.ztc.smart.farmework.helper.ReflectionUtil;
import com.ztc.smart.farmework.util.CodeUtil;
import com.ztc.smart.farmework.util.CollectionUtil;
import com.ztc.smart.farmework.util.JsonUtil;
import com.ztc.smart.farmework.util.StreamUtil;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.*;

/**
 * @ClassName DispatcherServlet
 * @Description TODO
 * @Author ztc
 * @Date 2024/4/22 9:01
 */
@WebServlet(urlPatterns = "/*",loadOnStartup = 0)
public class DispatcherServlet extends HttpServlet {
    @Override
    public void init(ServletConfig config) throws ServletException {
//        super.init(config);
        //初始化相关Helper类
        HelperLoader.init();
        //获取ServletContext对象，用于注册Servlet
        ServletContext servletContext = config.getServletContext();
        //注册处理 JSP 的Servlet
        ServletRegistration jspServlet = servletContext.getServletRegistration("jsp");
        jspServlet.addMapping(ConfigHelper.getAppJspPath() + "*");
        //注册处理静态资源的 Servlet
        ServletRegistration defaultServlet = servletContext.getServletRegistration("default");
        defaultServlet.addMapping(ConfigHelper.getAppAssetPath() + "*");

    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        //获取请求方法和路径
        String reqMethod = req.getMethod().toLowerCase();
        String reqPath = req.getPathInfo();
        //获取 Action 处理器
        Handler handler = ControllerHelper.getHandler(reqMethod, reqPath);

        if(!Objects.isNull(handler)){
            //获取Controller以及Bean实例
            Class<?> controllerClass = handler.getControllerClass();
            Object controllerBean = BeanHelper.getBean(controllerClass);
            Enumeration<String> parameterNames = req.getParameterNames();
            //创建请求参数对象
            Map<String,Object> paramMap = new HashMap<>();
            while (parameterNames.hasMoreElements()){
                String paramName = parameterNames.nextElement();
                String paramValue = req.getParameter(paramName);
                paramMap.put(paramName, paramValue);
            }
            String body = CodeUtil.encodeUrl(StreamUtil.getString(req.getInputStream()));
            if (StringUtils.isNotBlank(body)) {
                String[] params = body.split("&");
                if (ArrayUtils.isNotEmpty(params)) {
                    for (String param : params) {
                        String[] array = param.split("=");
                        if(ArrayUtils.isNotEmpty(array) && array.length == 2){
                            String paramName = array[0];
                            String paramValue = array[1];
                            paramMap.put(paramName, paramValue);
                        }
                    }
                }
            }
            Param param = new Param(paramMap);
            Method actionMethod = handler.getActionMethod();
            Object[] objs;

            Parameter[] parameters = actionMethod.getParameters();
            if (ArrayUtils.isEmpty(parameters)) {
                objs = new Object[]{};
            }else{
                ArrayList<Object> paramList = new ArrayList<>();
                for (Parameter parameter : parameters) {
                    String paramName = parameter.getName();
                    if (paramMap.containsKey(paramName)) {
                        paramList.add(paramMap.get(paramName));
                    }
                }
                objs = paramList.toArray();
            }
            //调用Action方法
            Object result = ReflectionUtil.invokeMethod(controllerBean, actionMethod, objs);
            //处理 Action 方法返回值
            if (result instanceof View) {
                View view = (View) result;
                String path = view.getPath();
                if(StringUtils.isNotBlank(path)){
                    if(path.startsWith("/")){
                        resp.sendRedirect(req.getContextPath() + path);
                    }else{
                        Map<String, Object> model = view.getModel();
                        for (Map.Entry<String, Object> entry : model.entrySet()) {
                            req.setAttribute(entry.getKey(), entry.getValue());
                        }
                        req.getRequestDispatcher(ConfigHelper.getAppJspPath() + path)
                                .forward(req,resp);
                    }
                }
            }else if(result instanceof Data){
                Data data = (Data) result;
                Object model = data.getModel();
                if (!Objects.isNull(model)) {
                    resp.setContentType("application/json");
                    resp.setCharacterEncoding("UTF-8");
                    PrintWriter writer = resp.getWriter();
                    String json = JsonUtil.toJson(model);
                    writer.write(json);
                    writer.flush();
                    writer.close();
                }
            }

        }
    }
}
