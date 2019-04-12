package com.example.xigua;

import com.example.xigua.controller.TextController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;



@RunWith(SpringRunner.class)
@SpringBootTest
public class XiguaApplicationTests {

    @Autowired
    private TextController textController;

    @Test
    public void getShort() {
        textController.getShort("https://blog.csdn.net/weixin_43700342/article/details/89057471");
    }

    @Test
    public void getLong(){
        textController.getLong("http://c1n.cn/O23oG");
    }

    @Test
    public void getCount(){
        textController.getCount("http://c1n.cn/O23oG");
    }

    @Test
    public void getCustom(){
        textController.getCustom("https://blog.csdn.net/weixin_43700342/article/details/89057471","gundd");
    }
}
