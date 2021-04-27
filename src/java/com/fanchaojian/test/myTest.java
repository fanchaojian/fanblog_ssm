package com.fanchaojian.test;

import org.junit.Test;

import java.util.Base64;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author fanchaojian
 * @date 2021-4-20 - 13:58
 */
public class myTest{
    @Test
    public void test1(){
        Map<String,String> dataMap = new LinkedHashMap<String,String>()  ;
        dataMap.put("2021","aaa") ;
        dataMap.put("2020","bbb") ;
        dataMap.put("2013","ccc") ;
        dataMap.put("2015","ddd") ;

        System.out.println(dataMap) ;
    }

    @Test
    public void test2 (){
        try{
            //YWRtaW4mOTk5NTIw
            /*String auth = "admin&999520" ;
            Base64.Encoder encoder = Base64.getEncoder() ;
            byte[] textByte = auth.getBytes("UTF-8") ;
            String accessLoginStr = encoder.encodeToString(textByte);
            System.out.println("编码后的字符串"+accessLoginStr) ;  */

            //bG9jYWxob3N0I2ZhbmNoYW9qaWFuJjE5NDg1NTYwMjRAcXEuY29t
            String auth = "localhost#fanchaojian&1948556024@qq.com" ;
            Base64.Encoder encoder = Base64.getEncoder() ;
            byte[] textByte = auth.getBytes("UTF-8") ;
            String accessLoginStr = encoder.encodeToString(textByte);
            System.out.println("编码后的字符串"+accessLoginStr) ;

            /*String auth = "qq#QQdsfjksdfisfn" ;
            Base64.Encoder encoder = Base64.getEncoder() ;
            byte[] textByte = auth.getBytes("UTF-8") ;
            String accessLoginStr = encoder.encodeToString(textByte);
            System.out.println("编码后的字符串"+accessLoginStr) ;*/

            /**String auth2 = "wechat#WECHATsdfskfshiosdj" ;
            Base64.Encoder encoder2 = Base64.getEncoder() ;
            byte[] textByte = auth2.getBytes("UTF-8") ;
            String accessLoginStr = encoder.encodeToString(textByte);
            System.out.println("编码后的字符串"+accessLoginStr) ; **/
        }catch(Exception e){
            e.printStackTrace();
        }


    }
}
