package com.godc.FileStreanTest;

import java.io.*;
import java.util.ArrayList;

public class OutputStreamTest {
    public static void main(String[] args) throws IOException {
        readerTest01();
    }

    private static void FileTest() throws IOException {
        File file = new File("data\\input\\a.txt");
//        File file = new File("data\\");
        File absoluteFile = file.getAbsoluteFile();

        System.out.println(file.getName());// 最后的文件或者文件夹的名称
        System.out.println(file);// 获取创建file时填入的路径

        System.out.println(file.getAbsolutePath());// 获取绝对路径
        System.out.println(file.getPath()); // 获取创建file时填入的路径
        System.out.println(file.getCanonicalPath()); // 获取绝对路径. 需要抛出io异常
        System.out.println("字节数：" + file.length()); // 获取文件的大小(字节数)

        System.out.println("判断文件是否存在：" + file.exists());
        System.out.println("是否创建：" + file.createNewFile()); // 当指定的文件不存在时，此方法可以创建指定路径的文件，并返回ture

        File fileOut = new File("data\\out");
        System.out.println("out目录是否存在：" + fileOut.exists());
        System.out.println("out目录是否自动创建：" + fileOut.mkdir()); //当指定的文件夹不存在时，创建文件夹
        System.out.println("再次out目录是否存在：" + fileOut.exists());

        File fileOutDirs = new File("data\\out\\test1\\test2\\test3");
        System.out.println("多级目录是否存在：" + fileOutDirs.exists());
        System.out.println("多级目录是否自动创建：" + fileOutDirs.mkdirs()); // 使用此方法创建多级目录
        System.out.println("再次多级目录是否存在：" + fileOutDirs.exists());
    }

    // 遍历data目录
    private static void FileTest02(){
        File fileDir = new File("data");
        ArrayList<String> allFilePath = new ArrayList<>();
        if (fileDir.exists()){
            getAllFile(fileDir, allFilePath);
            System.out.println("方法外：");
            for (String s : allFilePath) {
                System.out.println(s);
            }
        }
    }

    private static void getAllFile(File dir, ArrayList<String> allFilePath){
    // 递归遍历文件夹下所有的目录与文件
        File[] files = dir.listFiles();
        for (File file : files) {

            allFilePath.add(file.getPath());

            if (file.isDirectory()){
                getAllFile(file, allFilePath);
            }
        }
    }

    // 字符输入
    private static void readerTest01() throws IOException {
        FileReader fileReader = new FileReader("data\\input\\a.txt");

        int read = 0; // 返回读取到的字符的code码，读取为空时返回-1，一次读取一个字符
        while((read = fileReader.read()) != -1) {
            System.out.println((char) read + "" + read);
        }

        // 使用char数组，一次读取多个字符，将字符存在数组中
        // 此时返回的len 代表本次读取的有效字符个数，不是指字符的字节码，为空时值为-1
        FileReader fileReader2 = new FileReader("data\\input\\a.txt");

        FileWriter fileWriter = new FileWriter("data\\input\\b.txt"); // 将a的内容写入到b当中
        char[] chars = new char[1024];
        int len = 0;
        while((len = fileReader2.read(chars)) != -1) {
            System.out.println(new String(chars, 0, len));
            fileWriter.write(chars, 0, len);
        }

        fileWriter.write("\r\nabcdefghijklmn"); // 写入字符串
        fileWriter.write("\r\n啊实打实的大师傅", 0, 5); // 指定写入字符串中的哪部分片段
        fileWriter.flush();

        fileReader.close();
        fileReader2.close();
        fileWriter.close();
    }
}
