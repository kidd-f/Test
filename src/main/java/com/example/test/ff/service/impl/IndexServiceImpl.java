package com.example.test.ff.service.impl;

import com.example.test.ff.dto.MemoryDto;
import com.example.test.ff.service.IndexService;
import org.springframework.stereotype.Service;

import java.util.WeakHashMap;

@Service
public class IndexServiceImpl implements IndexService {

    @Override
    public void index() {
//        int b = 3;
//        long start = System.currentTimeMillis();
//        long end = start + b * 1000;

        int nThreads = Runtime.getRuntime().availableProcessors();
        System.out.println(nThreads);

        for(int i = 0; i < nThreads; i++){
            new Thread(new Runnable() {
                int a;
                @Override
                public void run() {
                    while (true){
                        a++;
                    }

                }
            }).start();

        }

    }

    @Override
    public String home() {
        Runtime rt = Runtime.getRuntime();
        long free = rt.freeMemory();
        long total = rt.totalMemory();
        long max = rt.maxMemory();
        MemoryDto memoryDto = new MemoryDto();
        memoryDto.setFree(free);
        memoryDto.setTotal(total);
        memoryDto.setMax(max);

        WeakHashMap map = new WeakHashMap();
        long size = 35;
        int num = Integer.parseInt(String.valueOf(max/size));

        for(int i = 0; i<= num; i++){
            Object ob = new Object();
            map.put(i++,ob);
        }
//        System.out.println(rt.freeMemory());
//        map.clear();
//        map = null;
//        System.gc();
//        System.runFinalization();
        System.out.println("finished");
        return memoryDto.toString();

    }
}
