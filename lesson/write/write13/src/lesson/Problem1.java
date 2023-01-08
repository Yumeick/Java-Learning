package lesson;
class Distribution implements Runnable{
    private int notebooks= 80;
    Object lock= new Object();
    public void run(){
        while(true){
            synchronized(lock){
                if(notebooks > 0){
                    try{
                        Thread.sleep(100);
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()
                    +"正在发放第"+(notebooks--)+"份学习笔记。");
                }
            }
        }
    }
}
public class Problem1{
    public static void main(String[] args) {
        Distribution thread=new Distribution();
        new Thread(thread, "老师1").start();
        new Thread(thread, "老师2").start();
        new Thread(thread, "老师3").start();
    }
}