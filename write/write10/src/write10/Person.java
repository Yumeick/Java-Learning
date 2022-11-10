package write10;
import java.text.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

@SuppressWarnings("unused")
public class Person {
	Random r= new Random();  //定义一个随机数对象
	LocalDateTime localTime=LocalDateTime.now();  //定义一个当前日期对象
	DateTimeFormatter sdf= DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm");  //设置日期格式
	protected LocalDateTime setTime() {
		//思路：直接修改当前时间，天数用随机数去减即可忽略闰年的影响
		int day= 1+r.nextInt(30);
		LocalDateTime time=localTime.of(1990+r.nextInt(2008-1990), 1+r.nextInt(11), 1, r.nextInt(24), r.nextInt(60));  //修改天数以外的所有时间量
		return time.minusDays(day);  //修改后的日期减去一个随机的天数
	}
	protected String setName() {  //根据Acill码随机生成姓名
		String name= new String();
		for(int i=0; i<5; i++) 
			if(i==0)  //首字母大写
				name+=(char)(65+r.nextInt(25));
			else		//其余字母小写
				name+=(char)(97+r.nextInt(25));
		return name;
	}
	
	public void introduce() {
		System.out.print(String.format("我是%s，我出生日期是", setName())); 
		System.out.println(sdf.format(setTime())); 
	}
}
