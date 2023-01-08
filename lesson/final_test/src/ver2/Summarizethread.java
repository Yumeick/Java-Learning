package ver2;
import java.util.ArrayList;
import java.util.Random;
public class Summarizethread implements Runnable{
    Object lock= new Object();  //锁对象
    private int num_student=0;  //学生代号
    protected ArrayList<Student> students= new ArrayList<Student>();  //学生列表
    protected ArrayList<Teacher> teachers= new ArrayList<Teacher>();  //学生列表
    public Summarizethread(ArrayList<Student> students, ArrayList<Teacher>teachers){
        this.students= students;
        this.teachers= teachers;
    }
    public void run(){
        Random r= new Random();
        int num_random=0;
        //同步代码块
        while(true){
            synchronized(lock){
                if(num_student<1000){
                    //已定分数的试卷再随机分配给教师计算
                    num_random=r.nextInt(5);  //随机选中一名教师
                    teachers.get(num_random).max= teachers.get(num_random).max(teachers.get(num_random).max, students.get(num_student).grade);  //计算当前教师所改试卷的最高分
                    teachers.get(num_random).min= teachers.get(num_random).min(teachers.get(num_random).min, students.get(num_student).grade);  //计算当前教师所改试卷的最低分
                    teachers.get(num_random).sum= teachers.get(num_random).sum(teachers.get(num_random).sum, students.get(num_student).grade);  //计算当前教师所改试卷的总分
                    num_student++;
                }else{
                    break;
                }
            }
        }
    }
}
