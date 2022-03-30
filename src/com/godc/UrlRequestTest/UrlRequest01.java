package com.godc.UrlRequestTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class UrlRequest01 {
    public static String ConverToString(InputStream inputStream){
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        StringBuilder stringResult = new StringBuilder();
        String line = null;
        try {
            // 按行获取结果，json转为json字符串，返回的是所有结果
            // 如：[{"id":1,"name":"yueshao","age":0},{"id":2,"name":"mage","age":0},{"id":3,"name":"aaa","age":0}]
            while ((line = bufferedReader.readLine()) != null){
                stringResult.append(line).append("\n");
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                inputStreamReader.close();
                bufferedReader.close();
                inputStream.close();
            }catch (IOException e) {
                e.printStackTrace();
            }
        }

//        返回字符串结果
        return stringResult.toString();
    }

    public static void main(String[] args){
        try {
            // POST 与 get 在拼接url时是相同的，在传输时会得到封装，参数部分封装到body里面
            String urlHost = "http://localhost:8081";
//            请求参数： /car; /muchPerson?start=1&stop=3; /Person?id=1
            String urlPage = "/muchPerson?start=1&stop=3";

            URL url = new URL(urlHost + urlPage);

            HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();
            // 模拟 GET 请求,使用post请求时改为 POST 即可
            urlConnection.setRequestMethod("GET");

            urlConnection.connect();
            System.out.println("Connection Response From car");
            InputStream inputStream = urlConnection.getInputStream();
//            System.out.println(inputStream);

            String s = ConverToString(inputStream);
            System.out.println(s);

        }catch (IOException e){
            System.out.println("访问失败,无效的url地址-404");
        }
    }
}
