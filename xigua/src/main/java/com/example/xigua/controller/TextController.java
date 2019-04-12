package com.example.xigua.controller;

import com.example.xigua.entity.Item;
import com.example.xigua.service.ItemService;
import com.example.xigua.until.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;


@RestController
public class TextController {

    @Autowired
    private ItemService itemService;

    //输入⻓链，可以生成短链
    @RequestMapping("/short")
    public String getShort(String url){
        if (url.isEmpty()){
            return "请输入网址";
        }else {
            Item item1 = itemService.selectByUrl(url);//判断地址是否存在
            if (item1!= null){
                item1.setCount(item1.getCount()+1);
                itemService.updateByKey(item1);
                return item1.getKey();
            }else {
                Item item = new Item();
                String[] aResult = MD5.shortUrl(url);
                Random random=new Random();
                int j=random.nextInt(4);//产成4以内随机数
                System.out.println("短链接:"+aResult[j]);//随机取一个作为短链
                String key =aResult[j];
                item.setKey(key);
                item.setCount(1);
                item.setUrl(url);
                itemService.insert(item);
                return key;
            }
        }
    }

    //访问短链，跳转到⻓链
    @RequestMapping("/long")
    public String getLong(String url){
        if (url.isEmpty()){
            return "请输入网址";
        }else {
            Item item = itemService.selectByPrimaryKey(url);//查询短链是否存在
            if (item!= null){
                item.setCount(item.getCount()+1);
                itemService.updateByKey(item);
                return item.getKey();
            }else {
                return "短链错误";
            }
        }
    }
    //支持访问计数
    @RequestMapping("/count")
    public Object getCount(String url){
        if (url.isEmpty()){
            return "请输入网址";
        }else {
            Item item = itemService.selectByPrimaryKey(url);//查询短链是否存在
            if (item!= null){
                return item.getCount();
            }else {
                return "短链错误";
            }
        }
    }

    //支持自定义短链，可以指定字符串作为短链的key
    @RequestMapping("/custom")
    public Object getCustom(String url,String key){
        if (url.isEmpty()){
            return "请输入网址";
        }else if (key.isEmpty()){
            return "请输入指定字符串作为短链的key";
        } else {
            Item item = itemService.selectByPrimaryKey(url);//查询短链是否存在
            if (item!= null){
                return "指定字符串存在，请重新输入！";
            }else {
                Item item1 = new Item();
                item1.setKey(key);
                item1.setCount(1);
                item1.setUrl(url);
                itemService.insert(item1);
                return key;
            }

        }
    }
}
