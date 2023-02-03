package com.rookie.bigdata;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Classname WorkTest
 * @Description
 * @Author rookie
 * @Date 2022/11/9 11:57
 * @Version 1.0
 */
public class WorkTest {


    @Test
    public void test1() throws Exception {


        String line = "";
        BufferedReader br = new BufferedReader(new FileReader("C:\\work\\IDEAWorkSpace\\15位转18位\\会员.txt"));
        //读取文件

//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\work\\IDEAWorkSpace\\15位转18位\\15.txt"));



        List<String> list = new ArrayList<>();
        Set<String> stringSet = new HashSet<>();
        while ((line = br.readLine()) != null) {
            line = line.trim();

            list.add(line);




        }

        String line1 = "";
        BufferedReader br1 = new BufferedReader(new FileReader("C:\\work\\IDEAWorkSpace\\15位转18位\\map.txt"));
        //读取文件

//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\work\\IDEAWorkSpace\\15位转18位\\15.txt"));


Set<String> sets=new HashSet<>();
        while ((line1 = br1.readLine()) != null) {
            line1 = line1.trim();

            sets.add(line1);




        }






        for (String memberCode : list) {

        if(sets.contains(memberCode)){

        }else {
            System.out.println(memberCode);
        }



        }

        br.close();


    }

}
