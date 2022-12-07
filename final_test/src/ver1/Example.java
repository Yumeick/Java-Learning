package ver1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;

public class Example{
    public static void main(String[] args) throws Exception{
        ArrayList<Teacher> teachers= new ArrayList<Teacher>();  //学生列表
        ArrayList<Student> students= new ArrayList<Student>();  //教师列表
        String path="D:/Work/CODE/git/Java-Learning/final_test/src/ver1/result.csv";  //csv文件导出路径
        BufferedWriter bw= new BufferedWriter(new FileWriter(path));

        //随机生成1000名学生，并将学生加入学生列表中
        for(int i=0; i<1000; i++){
            Student stu=new Student();
            students.add(stu);
        }

        //随机生成5名教师，并将教师加入教师列表中
        for(int j=0; j<5; j++){
            Teacher tea=new Teacher();
            teachers.add(tea);
        }
        
        Countthread countthread= new Countthread(students,teachers);  //定义改卷线程对象
        Summarizethread summarizethread= new Summarizethread(students, teachers);  //定义统分线程对象

        //多线程改卷+多线程统分
        for(int k=0; k<5; k++){
            new Thread(countthread, "老师"+(teachers.get(k).name)).start();
            new Thread(summarizethread, "老师"+teachers.get(k).name).start();
        }

        //将结果保存在csv文件中
        bw.write("max"+","+summarizethread.getMax());
        bw.newLine();
        bw.write("min"+","+summarizethread.getMin());
        bw.newLine();
        bw.write("mean"+","+(summarizethread.getSum()/students.size()));

        bw.close();
    }
}