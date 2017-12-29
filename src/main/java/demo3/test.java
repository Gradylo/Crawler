package demo3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class test {
	public static String getAjaxCotnent(String url) throws IOException {     
        Runtime rt = Runtime.getRuntime();     
        Process p = rt.exec("phantomjs.exe D:/Java/phantomjs/phantomjs/requestjs/test2.js "+url);//这里我的codes.js是保存在c盘下面的phantomjs目录     
        InputStream is = p.getInputStream();     
        BufferedReader br = new BufferedReader(new InputStreamReader(is));     
        StringBuffer sbf = new StringBuffer();     
        String tmp = "";     
        while((tmp = br.readLine())!=null){     
            sbf.append(tmp);
            sbf.append("\n");
        }     
        System.out.println(sbf.toString()); 
        return sbf.toString();     
    }     
	
	public static void main(String[] args) throws IOException {
		getAjaxCotnent("http://music.163.com/#/playlist?id=2005048744");
	}
}




