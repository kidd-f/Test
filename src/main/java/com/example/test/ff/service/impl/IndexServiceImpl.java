package com.example.test.ff.service.impl;

import com.example.test.ff.service.IndexService;
import org.springframework.stereotype.Service;

@Service
public class IndexServiceImpl implements IndexService {

    @Override
    public void index() {
        int b = 3;
        long start = System.currentTimeMillis();
        long end = start + b * 1000;

        int nThreads = Runtime.getRuntime().availableProcessors();
        System.out.println(nThreads);

        for(int i = 0; i < nThreads; i++){
            new Thread(new Runnable() {
                int a;
                @Override
                public void run() {
                    while (true){
                        a++;
                        if(System.currentTimeMillis() >= end){
                            break;
                        }
                    }

                }
            }).start();
            if(System.currentTimeMillis() >= end){
                break;
            }
        }

    }
}
