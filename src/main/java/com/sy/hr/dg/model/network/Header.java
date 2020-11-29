package com.sy.hr.dg.model.network;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Header<T> {

    // api 통신시간
    private LocalDateTime responseTime;

    // api 응답 코드
    private String resultCode;

    // api 부가 설명
    private String responseMessage;

    private T data;

    // pagination
    // private Pagination pagination;

    // OK
    public static <T> Header<T> OK(){
        return (Header<T>)Header.builder()
                .responseTime(LocalDateTime.now())
                .resultCode("OK")
                .responseMessage("OK")
                .build();
    }

    // DATA OK
    public static <T> Header<T> OK(T data){
        return (Header<T>)Header.builder()
                .responseTime(LocalDateTime.now())
                .resultCode("OK")
                .responseMessage("OK")
                .data(data)
                .build();
    }

   /* public static <T> Header<T> OK(T data, Pagination pagination){
        return (Header<T>)Header.builder()
                .transactionTime(LocalDateTime.now())
                .resultCode("OK")
                .responseMessage("OK")
                .data(data)
                .pagination(pagination)
                .build();
    }*/

    // ERROR
    public static <T> Header<T> ERROR(String responseMessage){
        return (Header<T>)Header.builder()
                .responseTime(LocalDateTime.now())
                .resultCode("ERROR")
                .responseMessage(responseMessage)
                .build();
    }
}
