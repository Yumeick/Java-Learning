package write10;
import java.text.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Person {
	Random r= new Random();  //定义一个随机数对象
	LocalDateTime localTime=LocalDateTime.now();  //定义一个当前日期对象
	LocalDateTime time=localTime.minusYears(14+r.nextInt(2008-1990))  //当前年份2022年减去14得到给定范围的最大年份2008年，再减去一个随机数得到随机年份
			.minusMonths(r.nextInt(12))  //减去一个随机数得到随机月份，下面操作同理
			.minusDays(r.nextInt(31))  
			//天数的随机数取0到31都可以。对于LocalDateTime对象，超出当前月份的最大天数的部分会自动跳转其他月份。比如2022年2月1日加31天则跳转到3月4日
			.minusHours(r.nextInt(24))
			.minusMinutes(r.nextInt(60));
	DateTimeFormatter sdf= DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm");  //设置日期格式
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
		System.out.println(sdf.format(time)); 
	}
}
