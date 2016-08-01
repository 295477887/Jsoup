package com.chen.util;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

/**
 * 解析html
 * */
public class JsoupUtil 
{
	//@Test
	public void parseString()
	{
		String html = "<html><head><script type=\"text/javascript\">var date = new Date();alert(date);function sub(u){var token = document.getElementById(\"token\").value;var durl = u + \"token=\" + encodeURIComponent(token);window.open(durl);}</script></head><body><br/><br/>token:<input type=\"text\" name=\"token\" id=\"token\" style=\"width:500\" value=\"uGyUoJ8A6+ETMgIVYAHTpt/l/cY=\"/></input> <br/><br/><input class='butt' type=\"button\" value=\"打开本地\" name=\"sub\" onclick=\"sub('http://localhost:8080/mapbar-fieldwork/setting/setting!index.action?')\" style=\"left:200\"></input><input type=\"button\" value=\"打开44\" name=\"sub\" onclick=\"sub('http://10.30.20.44:8181/mapbar-fieldwork/setting/setting!index.action?')\" style=\"left:200\"></input><input type=\"button\" value=\"获取权限接口\" name=\"sub\" onclick=\"sub('http://localhost:8080/mapbar-fieldwork/newaccount/newaccount!queryUserPermissions.action?projectId=666&')\" style=\"left:200\"></input><input type=\"button\" value=\"获取权限接口\" name=\"sub\" onclick=\"sub('http://localhost:8080/mapbar-fieldwork/newaccount/newaccount!queryProjectPermissions.action?projectId=666&')\" style=\"left:200\"></input></body></html>";
		
		//Jsoup解析html
		Document doc =Jsoup.parse(html,"utf-8");
		
		//根据id获取元素
		Element e1 = doc.getElementById("token");
		
		//根据属性获取元素s
		Elements e2s = doc.getElementsByAttribute("onclick");
		
		//根据属性+属性值
		Elements e3s = doc.getElementsByAttributeValue("type", "text");
		
		//根据class
		Elements e4s = doc.getElementsByClass("butt");
		
		//根据 标签
		Elements e5s = doc.getElementsByTag("head");
		
		Elements e6s = doc.select("input[type]");
		
		p(e6s); 
		
	}
	
	//@Test
	public void parseUrl()
	{
		try 
		{
			URL url = new URL("http://www.baidu.com");
			Document doc = Jsoup.parse(url, 1000);
			Elements e1s = doc.select("a[href=http://news.baidu.com]");
			p(e1s);
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	@Test
	public void parseFile()
	{
		File file = new File("C:/Users/Administrator/Desktop/测试页面.html");
		try {
			Document doc = Jsoup.parse(file, "GBK");
			p(doc);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void p(Object o)
	{
		System.out.println(o);
	}
}
