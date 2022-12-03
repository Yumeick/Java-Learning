package lesson;

class Add extends Thread{
    protected int begin;
    protected int end;
    static public int sum=0;
    
    public Add(int begin){
        this.begin= begin;
        this.end= begin+10;
    }

    protected int Sum(){
        int sum_s=0;
        for (int i=begin; i<end; i++){
            sum_s+=i;
        } 
        sum+=sum_s;
        return sum;
    }
}

public class Problem2{
    public static void main(String[] args) {
    Object lock=new Object();
    for(int j=0; j<10; j++){
        Add add=new Add(j*10+1);
        synchronized(lock){
            try{
                Thread.sleep(100);
                add.Sum();
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }
        System.out.println("进程"+(j+1)+": "+add.sum);
    }
    
    }
}