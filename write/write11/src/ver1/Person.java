package ver1;
import java.text.*;
import java.time.*;
import java.time.format.*;
import java.util.*;

public class Person {
	protected String name= new String();  
	protected LocalDateTime birthday=LocalDateTime.now();  
		
	public Person(){
		this.birthday= randomDate();
		this.name= randomName();
	}

	protected LocalDateTime randomDate() {
		//思路：直接修改当前时间，天数用随机数去加即可忽略闰年的影响
		Random r= new Random();  
		int day= 1+r.nextInt(30);
		birthday=birthday.of(1990+r.nextInt(2008-1990), 1+r.nextInt(11), 1, 
							r.nextInt(24), r.nextInt(60));  
		return birthday.plusDays(day);  
	}

	protected String randomName() {  
		//根据Acill码随机生成姓名
		Random r= new Random();  
		for(int i=0; i<5; i++) 
			if(i==0)  //首字母大写
				name+=(char)(65+r.nextInt(25));
			else	//其余字母小写
				name+=(char)(97+r.nextInt(25));
		return name;
	}
	
	public void introduce() {
		DateTimeFormatter sdf= DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm");  
		System.out.print(String.format("我是%s，我出生日期是", name)); 
		System.out.println(sdf.format(birthday)); 
	}

	public int hashCode(){
		return name.hashCode();
	}

	public boolean equals(Object obj){
		Person p2= (Person)obj;
		//判断(姓名是否相同  同时  出生年份是否相同)
		return (this.hashCode()==p2.hashCode()  &&  
				this.birthday.getYear()==p2.birthday.getYear());
	}
}
