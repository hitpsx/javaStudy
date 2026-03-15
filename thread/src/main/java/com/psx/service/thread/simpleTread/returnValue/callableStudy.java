package com.psx.service.thread.simpleTread.returnValue;

import java.util.concurrent.*;

public class callableStudy {
    public static void main(String[] args) {
        callableIml callableIml = new callableIml();
        ExecutorService executorService = new ThreadPoolExecutor(5,10,0L, TimeUnit.MILLISECONDS,new LinkedBlockingQueue<Runnable>(1000));
        Future<String> resultresult = executorService.submit(callableIml);
        try {
            System.out.println(resultresult.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        executorService.shutdown();
    }
}

class callableIml implements Callable<String> {

    @Override
    public String  call() throws Exception {
        return  "heelo";
    }
}