package com.tj.test;

import java.util.Arrays;
import java.util.List;

public class MyTest {

    public static void main(String[] args) {
        String fileName = "asdfg.gif";

        String suffixName = fileName.substring(fileName.lastIndexOf("."));

        List<String> suffixList = Arrays.asList(".png",".jpg",".jpeg");

        if(!suffixList.contains(suffixName)){
            System.out.println("不存在！！");
        }else {
            System.out.println("存在！！");
        }
    }

}
