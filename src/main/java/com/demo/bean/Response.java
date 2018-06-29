package com.demo.bean;

/**
 * @className: Response
 * @package: com.demo.bean
 * @describe: response
 * @auther: liuzhiyong
 * @date: 2018/6/28
 * @time: 上午 11:47
 */
public class Response {
    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    private String responseMessage;
    public Response(String responseMessage){
        this.responseMessage = responseMessage;
    }
    public String getResponseMessage(){
        return responseMessage;
    }
}