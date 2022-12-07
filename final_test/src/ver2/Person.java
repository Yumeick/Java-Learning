package ver2;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class Person {
    protected String name= new String();
    protected Date birthdate= new Date();
    public Person(){
        this.name= setName();
        this.birthdate= setBirthdate();
    }
    //随机生成姓名
    private String setName(){
        Random r= new Random();
        for(int i=0; i<5; i++) 
        if(i==0)  //首字母大写
            name+=(char)(65+r.nextInt(25));
        else		//其余字母小写
            name+=(char)(97+r.nextInt(25));
        return name;
    }
    //随机生成出生日期
    private Date setBirthdate(){
        Calendar birthday= Calendar.getInstance();
        Random r= new Random();
        birthday.set(1990+r.nextInt(2008-1990), 1+r.nextInt(11), 1+r.nextInt(30));
        birthdate=birthday.getTime();
        return birthdate;
    }
    //返回姓名的哈希值
    public int hashCode(){
		return name.hashCode();
	}
    //判断两个人是否是同一人
	public boolean equals(Object obj){
		Person p2= (Person)obj;
		//判断(姓名是否相同  同时  出生年份是否相同)
		return (this.hashCode()==p2.hashCode()  &&  
				this.birthdate==p2.birthdate);
	}
}
