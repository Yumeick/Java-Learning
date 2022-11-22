package ver1;
import java.io.File;
public class Problem3 {
    public static void main(String[] args) {
        File file= new File("D:/Work/CODE/git/Java-Learning/write");
        listFiles(file, "");
    }
    public static void listFiles(File dir, String spance){
        File[] files= dir.listFiles();
        for(File file:files){
            if(file.isFile()){
                System.out.println(spance+ file.getName());
            }else if(file.isDirectory()){
                System.out.println(spance+ file.getName());
                listFiles(file,"|-- "+spance);
            }
        }
    }
}
