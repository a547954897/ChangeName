import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Change {
    ArrayList filesName = new ArrayList();
    static String path = "D:\\电影\\秦时明月\\新建文件夹\\";
    static String suffix = "";


    public static void main(String[] args) {
        ArrayList<File> files = getFile(path);
        String num;

        Scanner scanner = new Scanner(System.in);
        System.out.println("输入主名字");
        String mainName = scanner.nextLine();

        for (File file : files) {
            num = getNum(files, file);
            reName(files, mainName,num);

        }


    }


    public static void reName(ArrayList<File> files, String mainName, String num) {
        String suffix;

        for (File file : files) {
            suffix = getSuffix(file.getName());
            file.renameTo(new File(path+mainName + " " + num + '.' + suffix));
        }
    }

    /**
     * @param files
     * @return
     */
    public static String getNum(ArrayList<File> files, File file) {

        Queue name1 = new LinkedList<>();
        for (char i : files.get(0).getName().toCharArray()) {
            name1.offer(i);
        }
        String s = "";
        String different = "";
        char c;
        for (char i : files.get(files.size()-1).getName().toCharArray()) {
            c = (char) name1.poll();
            if (i == c) {
                s += i;
            } else {
                different += i;
            }
        }
        int start = files.get(files.size()-1).getName().lastIndexOf(different);
        int end = start +different.getBytes().length;
        System.out.println(different);
        System.out.println(different.getBytes().length);
        String num = file.getName().substring(start,end );
        return num;
    }

    /**
     * 根据传入文件名获取后缀名
     *
     * @param fileName 文件名
     * @return 后缀名
     */
    public static String getSuffix(String fileName) {
        int pos = fileName.lastIndexOf('.');
        String suffix = fileName.substring(pos + 1);
        return suffix;
    }

    /**
     * 传入目录，获取其中所有文件
     *
     * @param path 目录
     * @return 所有文件集合
     */
    public static ArrayList<File> getFile(String path) {

        File dir = new File(path);
        File[] listFiles = dir.listFiles();

        ArrayList<File> files = new ArrayList<>();

        for (File file : listFiles) {
            if (file.isFile()) {
                files.add(file);
            } else if (file.isDirectory()) {
                getFile(file.getPath());
            }
        }

        for (File file : files) {
            System.out.println(file.getName());
        }
        return files;
    }


}
