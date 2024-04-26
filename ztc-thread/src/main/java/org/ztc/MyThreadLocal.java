package org.ztc;


import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName MyThreadLocal
 * @Description TODO
 * @Author ztc
 * @Date 2024/4/25 19:36
 */
public class MyThreadLocal<T> {
    private Map<Thread,T> container = new ConcurrentHashMap<Thread,T>();

    public void set(T value){
        container.put(Thread.currentThread(),value);
    }

    public T get(){
        Thread thread = Thread.currentThread();
        T value = container.get(thread);
        if(Objects.isNull(value) && !container.containsKey(thread)){
            value = initialValue();
            container.put(thread,value);
        }
        return value;
    }

    public void remove(){
        container.remove(Thread.currentThread());
    }

    protected T initialValue(){
        return null;
    }

}
