package com.psx.service.thread.simpleTread.noReturn;

class runableClass implements Runnable {
    String name;

    runableClass(String name) {
        this.name = name;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("线程" + this.name + "执行" + i);
        }
    }
}
//首次提交

public class runableStudy {
    public static void main(String[] args) {
        runableClass a = new runableClass("hello");
        Thread t1 = new Thread(a);
        t1.start();
    }
}
