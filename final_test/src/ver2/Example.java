package ver2;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
public class Example{
    public static void main(String[] args) throws Exception{
        ArrayList<Teacher> teachers= new ArrayList<Teacher>();  //学生列表
        ArrayList<Student> students= new ArrayList<Student>();  //教师列表
        int sum=0;  //1000份试卷的总分
        int max=0;  //1000份试卷的最高分
        int min=0;  //1000份试卷的最低分
        String path="D:/Work/CODE/git/Java-Learning/final_test/src/ver2/result.csv";  //csv文件导出路径
        BufferedWriter bw= new BufferedWriter(new FileWriter(path));
        //随机生成1000名不重复的学生，并将学生加入学生列表中
        for(int i=0; i<1000 ; i++){
            if(i==0){
                Student stu=new Student();
                students.add(stu);
            }else{
                Student stu=new Student();
                int rep=0;
                while(rep<i){
                    if(stu.equals(students.get(rep))){
                        stu=new Student();
                    }else{
                        rep++;
                    }
                }
                students.add(stu);
            }
        }
        //随机生成5名不重复的教师，并将教师加入教师列表中
        for(int j=0; j<5; j++){
            if(j==0){
                Teacher tea=new Teacher();
                teachers.add(tea);
            }else{
                Teacher tea=new Teacher();
                int rep=0;
                while(rep<j){
                    if(tea.equals(teachers.get(rep))){
                        tea=new Teacher();
                    }else{
                        rep++;
                    }
                }
                teachers.add(tea);
            }
        }
        Countthread countthread= new Countthread(students,teachers);  //定义改卷线程对象
        Summarizethread summarizethread= new Summarizethread(students, teachers);  //定义统分线程对象

        //多线程改卷+多线程统分
        for(int k=0; k<5; k++){
            new Thread(countthread, "老师"+(teachers.get(k).name)).start();
            new Thread(summarizethread, "老师"+teachers.get(k).name).start();
        }
        //计算1000份试卷的平均分、最高分和最低分，然后控制台输出结果
        System.out.println("教师阅卷统计\n教师姓名\t教师阅卷份数\t最高分\t最低分\t总分");
        for(int h=0; h<5; h++){
            System.out.println(teachers.get(h).getName()+"\t\t"+teachers.get(h).getNum()+"\t\t"+
            teachers.get(h).getMax()+"\t"+teachers.get(h).getMin()+"\t"+teachers.get(h).getSum());
            sum+=teachers.get(h).getSum();
            if(max < teachers.get(h).getMax())
                max=teachers.get(h).getMax();
            if(min > teachers.get(h).getMin())
                min=teachers.get(h).getMin();
        }
        System.out.println();
        System.out.println("全班统计:");
        System.out.println("平均分："+sum/1000+"\t最高分："+max+"\t最低分"+min);
        //将结果保存在csv文件中
        bw.write("教师阅卷统计");
        bw.newLine();
        bw.write("教师姓名,教师阅卷份数,最高分,最低分,总分");
        bw.newLine();
        for(int g=0; g<5; g++){
            bw.write(teachers.get(g).getName()+","+teachers.get(g).getNum()+","+
            teachers.get(g).getMax()+","+teachers.get(g).getMin()+","+teachers.get(g).getSum());
            bw.newLine();
        }
        bw.newLine();
        bw.write("全班统计");
        bw.newLine();
        bw.write("平均分,最高分,最低分");
        bw.newLine();
        bw.write((sum/1000)+","+max+","+min);
        bw.close();
    }
}