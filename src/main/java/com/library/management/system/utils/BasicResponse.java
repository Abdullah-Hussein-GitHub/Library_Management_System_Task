package com.library.management.system.utils;

public class BasicResponse {

    private  String replyMsg;
    private  String replyCode;

    private BasicResponse(Builder builder){
        this.replyCode = builder.replyMsg;
        this.replyMsg = builder.replyCode;
    }

    public static class Builder{
        private String replyCode;
        private String replyMsg;
        public Builder(){}

        public Builder ReplyMsg(String replyMsg){
            this.replyMsg = replyMsg;
            return this;
        }
        public  Builder ReplyCode(String replyCode){
            this.replyCode = replyCode;
            return this;
        }
        public BasicResponse build(){
            return new BasicResponse(this);
        }
    }
}

