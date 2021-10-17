package com.manage_clients_testwork.exceptionhandler;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "JSON response for api calls")
public class Response {
    @ApiModelProperty(notes = "Response type. True - success call and false - fails")
    private boolean success;
    @ApiModelProperty(notes = "In case of api call fails: is it fatal error or not (can be managed in front)")
    private boolean fatal;
    @ApiModelProperty(notes = "Error message")
    private String message;

    public Response() {
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public boolean isFatal() {
        return fatal;
    }

    public void setFatal(boolean fatal) {
        this.fatal = fatal;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
