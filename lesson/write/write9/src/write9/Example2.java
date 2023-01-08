package write9;
import java.util.Random;  //导入Random类
public class Example2 {
	public static void main(String[] args) {
		Random r= new Random();  //定义随机数对象
		for (int i=0; i<5; i++) {  //生成5个随机数 
			System.out.println(20+(r.nextInt(30-20+1)));  //根据题目给的公式输出随机数
		}
	}

}
