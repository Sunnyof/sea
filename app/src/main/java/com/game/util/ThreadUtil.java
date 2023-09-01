package com.game.util;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadUtil {

    private static ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1,3,3000, TimeUnit.MILLISECONDS,new LinkedBlockingDeque<>());

    public static void executeThread(Runnable runnable){
        threadPoolExecutor.execute(runnable);
    }
}
