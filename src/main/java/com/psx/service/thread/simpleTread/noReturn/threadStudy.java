package com.psx.service.thread.simpleTread.noReturn;


class threadClass extends Thread {
    String name;
    threadClass(String name) {
        this.name = name;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("线程" + this.name + "执行" + i);
        }
    }
}
public class threadStudy {
    public static void main(String[] args) {
        threadClass t = new threadClass("hello");
        t.start();
    }
}
