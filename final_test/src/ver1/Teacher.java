package ver1;

import java.util.Random;
import java.util.Date;
import java.util.Calendar;

public class Teacher extends Person{


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
}
