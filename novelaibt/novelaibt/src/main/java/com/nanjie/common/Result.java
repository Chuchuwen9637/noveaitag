package com.nanjie.common;

public  class Result {
    private int code;
    private String  message;
    private  Object data;
    public Result(){};
    public Result(int  code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static  Result ok(int  code, String message, Object data) {
        Result result=new Result(code,message,data);
         return result;
     }
     public static Result err(int code,String message){
         Result result=Result.err(code,message);
        return result;
     }
    public static Result Result(){
      return Result();
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public Object getData() {
        return data;
    }
}




