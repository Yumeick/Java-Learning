package ver2;
import java.util.Random;
import java.util.Date;
import java.util.Calendar;
public class Teacher extends Person{
    protected int max=0;  //该教师所改试卷中的最高分
    protected int min=0;  //该教师所改试卷中的最低分
    protected int sum=0;  //该教师所改试卷的总分
    protected int num_testpaper=0;  //该教师阅卷份数
    public Teacher(){
        super();
        this.birthdate= setBirthday();
    }
    //重构Person类的随机生成出生日期（年份范围修改为1950到2000年）
    private Date setBirthday(){
        Calendar birthday= Calendar.getInstance();
        Random r= new Random();
        birthday.set(1950+r.nextInt(2000-1950), 1+r.nextInt(11), 1+r.nextInt(30));
        birthdate=birthday.getTime();
        return birthdate;
    }
    //随机给学生一个分数
    public int mark(){
        Random r= new Random();
        int grade= r.nextInt(101);
        return grade;
    }
    //计算最高分
    public int max(int x, int y){
        return Math.max(x,y);
    }
    //计算最低分
    public int min(int x, int y){
        return Math.min(x, y);
    }
    //计算总分
    public int sum(int sum, int x){
        return sum+=x;
    }
    //返回教师姓名
    public String getName(){
        return super.name;
    }
    //返回该教师所改试卷中的最高分
    public int getMax(){
        return max;
    }
    //返回该教师所改试卷中的最低分
    public int getMin(){
        return min;
    }
    //返回该教师所改试卷中的总分
    public int getSum(){
        return sum;
    }
    //返回该教师的阅卷份数
    public int getNum(){
        return num_testpaper;
    }
}
