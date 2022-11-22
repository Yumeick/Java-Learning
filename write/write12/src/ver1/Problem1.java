package ver1;
import java.io.*;
public class Problem1 {
    public static void main(String[] args) throws Exception{
        String rpath="D:/Work/CODE/git/Java-Learning/write/write12/src/ver1/Problem1.txt";
        //字节流拷贝
        String wpath1="D:/Work/CODE/git/Java-Learning/write/write12/src/ver1/Problem1_out1.txt";
        FileInputStream in= new FileInputStream(rpath);
        FileOutputStream out= new FileOutputStream(wpath1);
        byte[] buf1= new byte[1024];
        int len1;
        while((len1= in.read(buf1)) != -1){
            out.write(buf1, 0, len1);
        }
        in.close();
        out.close();

        //FileReader FileWriter
        String wpath2="D:/Work/CODE/git/Java-Learning/write/write12/src/ver1/Problem1_out2.txt";
        FileReader fr= new FileReader(rpath);
        FileWriter fw= new FileWriter(wpath2);
        char[] buf2= new char[1024];
        int len2= 0;
        while((len2= fr.read(buf2)) != -1){
            fw.write(buf2,0,len2);
        }
        fr.close();
        fw.close();
        
        //字符流拷贝
        String wpath3="D:/Work/CODE/git/Java-Learning/write/write12/src/ver1/Problem1_out3.txt";
        BufferedReader bf= new BufferedReader(new FileReader(rpath));
        BufferedWriter bw= new BufferedWriter(new FileWriter(wpath3));
        String str;
        while((str= bf.readLine()) != null){
            bw.write(str);
            bw.newLine();
        }
        bf.close();
        bw.close();
    }
}
