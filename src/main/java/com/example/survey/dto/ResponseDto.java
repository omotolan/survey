package com.example.survey.dto;

import com.example.survey.enums.ResponseStatus;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ResponseDto<T> {
    private ResponseStatus status;
    private T data;
    private String message;

    public static <T> ResponseDto<T> wrapSuccessResult(T data, String message) {
        ResponseDto<T> response = new ResponseDto<>();
        response.setData(data);
        response.setMessage(message);
        response.setStatus(ResponseStatus.SUCCESS);
        return response;
    }

    public static <T> ResponseDto<T> wrapErrorResult(String message) {
        ResponseDto<T> response = new ResponseDto<>();
        response.setStatus(ResponseStatus.ERROR);
        response.setMessage(message);
        return response;
    }
}
