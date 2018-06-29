package com.demo.service;

import com.demo.bean.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

/**
 * @className: WebSocketService
 * @package: com.demo.service
 * @describe:
 * @auther: liuzhiyong
 * @date: 2018/6/28
 * @time: 上午 11:49
 */
@Service
public class WebSocketService {

    @Autowired
    //向浏览器发送消息
    private SimpMessagingTemplate template;

    public void sendMessage() throws Exception{
        for(int i=0;i<10;i++)
        {
            Thread.sleep(1000);
            template.convertAndSend("/topic/getResponse",new Response("Welcome,yangyibo !"+i));
            System.out.println("----------------------yangyibo"+i);
        }
    }

}
