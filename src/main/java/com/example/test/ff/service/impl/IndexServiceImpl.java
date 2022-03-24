package com.example.test.ff.service.impl;

import com.example.test.ff.config.ThreadLocalConfig;
import com.example.test.ff.dto.MemoryDto;
import com.example.test.ff.dto.MyTask;
import com.example.test.ff.service.IndexService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

@Service
public class IndexServiceImpl implements IndexService {

    @Autowired
    ThreadLocalConfig threadLocalConfig;

    /**占用cpu,新建核数*0.3，向上取整 个线程
     */
    @Override
    public void index() {
//        int b = 3;
//        long start = System.currentTimeMillis();
//        long end = start + b * 1000;

        int nThreads = Runtime.getRuntime().availableProcessors();
        System.out.println(nThreads);

        BigDecimal a = new BigDecimal(Double.valueOf(nThreads));
        BigDecimal b = new BigDecimal(0.3);
        int c = (int)Math.ceil(a.multiply(b).doubleValue());
        for(int i = 0; i< c; i++){
            new Thread(new Runnable() {
                int a;

                @Override
                public void run() {
                    while (true) {
                        a++;
                    }

                }
            }).start();
        }

    }

    /**占用内存,启动参数为 nohup java -Xms8g -Xmx8g -jar ff-0.0.1-SNAPSHOT.jar &
     */
    @SneakyThrows
    @Override
    public void home() {
        Runtime rt = Runtime.getRuntime();
        long free = rt.freeMemory();
        long total = rt.totalMemory();
        long max = rt.maxMemory();
        MemoryDto memoryDto = new MemoryDto();
        memoryDto.setFree(free);
        memoryDto.setTotal(total);
        memoryDto.setMax(max);
        int nThreads = Runtime.getRuntime().availableProcessors();

        for(int i = 0;i < nThreads; i++){
            new Thread(() -> {
                threadLocalConfig.set(new HashMap<String, MyTask>());
                while (true){
                    threadLocalConfig.get().put(UUID.randomUUID(), new MyTask());
                }
            }).start();
        }

    }


//        long size = 10;
//        int num = Integer.parseInt(String.valueOf(max/size));

//        HashMap map = new HashMap();

//        for(int i = 0; i<= num; i++){
//            Object ob = new Object();
//            map.put(i++,ob);
//        }
//        while (true){
//            Thread.sleep(10000);
//        }


//        System.out.println(rt.freeMemory());
//        map.clear();
//        map = null;
//        System.gc();
//        System.runFinalization();
//        System.out.println("finished");

}


