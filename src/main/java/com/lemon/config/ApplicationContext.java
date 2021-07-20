package com.lemon.config;

import com.lemon.annotation.MyAutoWired;
import com.lemon.annotation.MyBean;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * @author lbk
 * @create 2021-03-14 14:04
 */
public class ApplicationContext {

    // 存放对象容器
    private Map<Class, Object> beanFactory = new HashMap<>();

    private String filePath;

    /**
     * 从容器中获取指定对象
     *
     * @param c 指定的对象
     * @return
     */
    public <T> T getBean(Class<T> c) {
        return (T) beanFactory.get(c);
    }

    /**
     * 初始化容器
     */
    public void init() {
        // 获取配置文件
        InputStream resourceAsStream = ApplicationContext.class.getClassLoader().getResourceAsStream("config.properties");

        Properties properties = new Properties();

        try {
            properties.load(resourceAsStream);

            Set<Object> keys = properties.keySet();

            for (Object key : keys) {
                beanFactory.put(Class.forName(key.toString()), Class.forName(properties.getProperty(key.toString())).newInstance());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 通过注解形式，初始化容器
     */
    public void initAnnotation() {
        filePath = ApplicationContext.class.getClassLoader().getResource("").getFile();

        // 扫描所有组件
        loadOne(new File(filePath));

        //自动注入属性
        assembleObject();
    }

    /**
     * 根据 @MyAutoWired 自动注入对象
     */
    private void assembleObject() {
        for (Map.Entry<Class, Object> bean : beanFactory.entrySet()) {
            Class<?> aClass = bean.getValue().getClass();
            // 获取所有类属性
            Field[] declaredFields = aClass.getDeclaredFields();

            for (Field declaredField : declaredFields) {
                if (declaredField.getAnnotation(MyAutoWired.class) != null) {
                    // 开启暴力注入
                    declaredField.setAccessible(true);
                    try {
                        declaredField.set(bean.getValue(), beanFactory.get(declaredField.getType()));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    /**
     * 加载一个文件夹的类
     *
     * @param fileParent
     */
    private void loadOne(File fileParent) {
        // 判断这个是一个文件夹
        if (fileParent.isDirectory()) {
            File[] childrenFiles = fileParent.listFiles();
            if (childrenFiles == null || childrenFiles.length == 0) {
                return;
            }
            for (File child : childrenFiles) {
                //如果是个文件夹就继续调用该方法
                if (child.isDirectory()) {
                    loadOne(child);
                } else {
                    //通过文件路径转变成全类名,第一步把绝对路径部分去掉
                    String pathWithClass = child.getAbsolutePath().substring(filePath.length() - 1);
                    //选中class文件
                    if (pathWithClass.contains(".class")) {
                        //去掉.class后缀，并且把 \ 替换成 .
                        String fullName = pathWithClass.replaceAll("\\\\", ".").replace(".class", "");
                        try {
                            Class<?> aClass = Class.forName(fullName);

                            //把非接口的类实例化放在map中
                            if (!aClass.isInterface()) {
                                // 获取类上的 @MyBean，判断是否标注了 @MyBean
                                if (aClass.getAnnotation(MyBean.class) != null) {
                                    // 创建对象
                                    Object newObject = aClass.newInstance();

                                    // 判断继承了接口
                                    if (aClass.getInterfaces().length > 0) {
                                        beanFactory.put(aClass.getInterfaces()[0], newObject);
                                    }
                                    beanFactory.put(aClass, newObject);
                                }
                            }
                        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}
