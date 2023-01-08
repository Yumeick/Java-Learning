package write9;

public class Example {

	public static void main(String[] args) {
		String stri="HelloWorld";  
		StringBuffer stri_add=new StringBuffer();
		char[] strin=stri.toCharArray();  //将字符串转化为一个字符串数组，用于检索特定字符
		for (int i=stri.length()-1; i>=0; i--)   // i的初值是字符串长度-1，为什么要-1是因为数组从0开始遍历
			if(   stri.valueOf(strin[i]).equals(  (stri.valueOf( strin[i]).toUpperCase() )  )   )   
				//“字符串".valueOf("字符")将括号中的字符转为字符串，然后再用equals方法比较是否与 括号内的转变为大写的字符串 相等。
				//相等则将小写的结果添加到StringBuffer对象中
				stri_add.append(  stri.valueOf(strin[i]).toLowerCase()  );
			else
				//不相等则将大写的结果添加到StringBuffer对象中
				stri_add.append(  stri.valueOf(strin[i]).toUpperCase()  );
		System.out.println(stri_add.toString());
	}
}
