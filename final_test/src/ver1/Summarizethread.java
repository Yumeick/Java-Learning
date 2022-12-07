package ver1;

import java.util.ArrayList;
import java.util.Random;

public class Summarizethread implements Runnable{
    //别叫，这些变量我也不想放在这里
    Object lock= new Object();  //锁对象
    protected int max=0;  //最大值
    protected int min=0;  //最小值
    protected int sum=0;  //总和
    protected int i=0;  //计数
    protected ArrayList<Student> students= new ArrayList<Student>();  //学生列表
    protected ArrayList<Teacher> teachers= new ArrayList<Teacher>();  //学生列表

    public Summarizethread(ArrayList<Student> students, ArrayList<Teacher>teachers){
        this.students= students;
        this.teachers= teachers;
    }

    public void run(){
        Random r= new Random();

        //同步代码块
        while(true){
            synchronized(lock){
                if(i<1000){
                    //已定分数的试卷再随机分配给教师计算
                    max= teachers.get(r.nextInt(4)).max(max, students.get(i).grade);  //计算最大值
                    min= teachers.get(r.nextInt(4)).min(min, students.get(i).grade);  //计算最小值
                    sum= teachers.get(r.nextInt(4)).sum(sum, students.get(i).grade);  //计算总分
                    i++;
                }else{
                    break;
                }
            }
        }
        
    }

    //返回最大值
    public int getMax(){
        return max;
    }

    //返回最小值
    public int getMin(){
        return min;
    }

    //返回总分
    public int getSum(){
        return sum;
    }

}
