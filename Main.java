package ru.hw5;

public class Main {

    static final int size = 10000000;
    static final int h = size / 2;

    private static class Threads extends Thread {

        float[] arr;

        Threads(String name, float[] arr) {
            super(name);
            this.arr = arr;
        }

        @Override
        public void run() {
            System.out.println(getName() + " started.");
            for (int i = 0; i < arr.length; i++) {
                arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        }
    }

    private static class Threads2 extends Thread {

        float[] arr;
        float[] arr2;
        int valueOfIndex;

        Threads2(String name, float[] arr, int valueOfIndex) {
            super(name);
            this.arr = arr;
            this.arr2 = new float[arr.length / 2];
            this.valueOfIndex = valueOfIndex;
        }

        @Override
        public void run() {
            System.out.println(getName() + " started.");
            System.arraycopy(arr, valueOfIndex, arr2, 0, arr2.length);
            for (int i = 0; i < arr2.length; i++) {
                arr2[i] = (float)(arr2[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
            System.arraycopy(arr2, 0, arr, valueOfIndex, arr2.length);
        }
    }

    private static long method1 () {
        int size = 10000000;
        float[] arr = new float[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }
        long a = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.currentTimeMillis();
        return System.currentTimeMillis() - a;
    }

    private static long alternativeMethod1 (float[] arr) {
        long a = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.currentTimeMillis();
        return System.currentTimeMillis() - a;
    }

    private static long method2 (float[] arr) {
        long a = System.currentTimeMillis();
        float[] arr1 = new float[h];
        float[] arr2 = new float[h];
        System.arraycopy(arr, 0, arr1, 0, h);
        System.arraycopy(arr, h, arr2, 0, h);
        Threads m0 = new Threads("T01", arr1);
        Threads m1 = new Threads("T02", arr2);
        m0.start();
        m1.start();
        try {
            m0.join();
            System.out.println(m0.getName() + " stopped.");
            System.arraycopy(arr1, 0, arr, 0, h);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            m1.join();
            System.out.println(m1.getName() + " stopped.");
            System.arraycopy(arr2, 0, arr, h, h);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.currentTimeMillis();
        return System.currentTimeMillis() - a;
    }

    private static long alternativeMethod2 (float[] arr) {
        long a = System.currentTimeMillis();
        Threads2 m0 = new Threads2("T01A", arr, 0);
        Threads2 m1 = new Threads2("T02A", arr, arr.length / 2);
        m0.start();
        m1.start();
        try {
            m0.join();
            System.out.println(m0.getName() + " stopped.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            m1.join();
            System.out.println(m1.getName() + " stopped.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.currentTimeMillis();
        return System.currentTimeMillis() - a;
    }

    public static void main (String [] args) {
        System.out.println("Single thread did it a " + method1() + " millis.");
        float[] arr = new float[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }
        System.out.println("Single thread did it a " + alternativeMethod1(arr) + " millis.");
        System.out.println("Two threads did it a " + method2(arr) + " millis.");
        System.out.println("Two another threads did it a " + alternativeMethod2(arr) + " millis");
    }

}
