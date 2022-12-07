package ver1;

import java.util.Random;
import java.util.Date;
import java.util.Calendar;

public class Student extends Person {
    

    public int grade=0;  //学生成绩

    public Student(){
        super();
        this.birthdate= setBirthday();
    }

    //重构Person类的随机生成出生日期（年份范围修改为2000到2003年）
    private Date setBirthday(){
        Calendar birthday= Calendar.getInstance();
        Random r= new Random();
        birthday.set(2000+r.nextInt(2004-2000), 1+r.nextInt(11), 1+r.nextInt(30));
        birthdate=birthday.getTime();
        return birthdate;
    }
}
