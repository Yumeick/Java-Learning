package ver1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.*;


public class Example {
    public static void main(String[] args) {
        //Part 2  产生10个Person，用List保存，然后遍历输出。  
        //Part 3  增加Person的判重复规则，如果姓名相同，且是同一年出生，则认为是同一人。
        System.out.println("第二、三题：");
        ArrayList list= new ArrayList();
        int i3=0;
        while(i3<10){
            Person p=new Person();
            int num=0;  //计数变量
            //实现类似于python里的list的not in
            //遍历list，如果出现重复值，计数变量num会少加1次，以此作为是否重复的判断标准
            for(int j=0; j<i3; j++){
                if((list.get(j).equals(p)))
                    break;
                else
                    num++;
            }
            //判断是否重复
            if(num==i3){
                list.add(p);
                i3++;
            }
        }

        //遍历输出List
        for(Object per:list){
            Person p=(Person)per;
            p.introduce();
        }
        System.out.println();  //分隔
        


        //Part 4  针对2中产生的10个Person，随机挑选4个进行修改，使其产生重复元素。
        System.out.println("第四题：");
        Random r=new Random();
        int ratio= 2;  //生成重复元素的个数
        ArrayList listr= new ArrayList();  //定义一个存放随机数的列表
        //不考虑随机挑选后再次出现重复元素的情况
        for (int i4=0; i4<4; i4++){
            int rand= r.nextInt(list.size());  //生成随机数
            listr.add(list.get(rand));  //将随机数加入随机列表中
        }
        for(int i4=0; i4< listr.size(); i4++){
            for (int j=0; j< ratio; j++){
                Person p= (Person)listr.get(i4);
                p.introduce();
            }
        }
        System.out.println();  //分隔

        //Part 5  遍历2中的List，并将元素加入到一个集合Set。
        System.out.println("第五题：");
        HashSet<Person> set=new HashSet<Person>();  //定义一个集合set
        //遍历2中的List
        for (int i5=0; i5<list.size(); i5++){
            Person p=(Person)list.get(i5);
            p.introduce();
            set.add(p);  //将List中的元素加入到集合set中
        }
        System.out.println();  //分隔

        //Part 6  遍历Set输出，观察Set中是否存在重复元素。
        System.out.println("第六题：");
        for (Object obj:set){
            ((Person)obj).introduce();
        }
        /*
        //输出集合当前元素是否存在重复元素
        int num=0;
        int i6=0;
        for(i6=0; i6<list.size(); i6++){
            if(((Person)obj).equals(list.get(i6)))
                break;
            else
                num++;
        }
        if(num==i6)
            System.out.println("第"+(i6+1)+"个元素不存在重复元素");
         */
    }
}
