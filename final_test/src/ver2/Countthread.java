package ver2;
import java.util.ArrayList;
import java.util.Random;
public class Countthread implements Runnable{
    Object lock= new Object();  //锁对象
    private int num_student=0;  //学生代号
    protected ArrayList<Student> students= new ArrayList<Student>();  //学生列表
    protected ArrayList<Teacher> teachers= new ArrayList<Teacher>();  //教师列表
    public Countthread(ArrayList<Student> students, ArrayList<Teacher>teachers){
        this.students= students;
        this.teachers= teachers;
    }
    public void run(){
        Random r=new Random();
        //同步代码块
        while(true){
            synchronized(lock){
                if(num_student<1000){
                    int num_random=r.nextInt(5);
                    //试卷分配给随机教师（等价于试卷随机分配给教师），教师随机给学生一个分数
                    students.get(num_student).grade=teachers.get(num_random).mark();
                    teachers.get(num_random).num_testpaper++;  //计算当前教师阅卷份数
                    num_student++;
                }else{
                    break;
                }
            }
        }
    }
}