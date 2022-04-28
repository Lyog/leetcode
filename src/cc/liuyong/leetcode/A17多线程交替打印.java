package cc.liuyong.leetcode;

public class A17多线程交替打印 {

    static final Object obj = new Object();
    static Integer i = 1;

    public static void main(String[] args) {

        new Thread(() -> {
            synchronized (obj) {
                for (int j = 0; j < 50; j++) {
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("a:" + i++);
                    obj.notify();
                }
            }
        }).start();
        new Thread(() -> {
            synchronized (obj) {
                for (int j = 0; j < 50; j++) {
                    System.out.println("b:" + i++);
                    obj.notify();
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
