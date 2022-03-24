package com.example.test.ff.config;

import com.example.test.ff.dto.MyTask;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class ThreadLocalConfig {

    private static ThreadLocal<Map<String ,MyTask>> threadLocal = new ThreadLocal<>();

    public Map get() {
        return threadLocal.get();
    }

    //设置当前线程的存的变量
    public void set(Map map) {
        this.threadLocal.set(map);
    }

    //移除当前线程的存的变量
    public void remove() {
        this.threadLocal.remove();
    }
}
