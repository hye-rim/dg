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
                .responseTime( LocalDateTime.now() )
                .resultCode( "00000" )
                .responseMessage( "OK" )
                .build();
    }

    public static <T> Header<T> OK( String responseMessage ){
        return (Header<T>)Header.builder()
                .responseTime( LocalDateTime.now() )
                .resultCode( "00000" )
                .responseMessage( responseMessage )
                .build();
    }

    // DATA OK
    public static <T> Header<T> OK(T data){
        return (Header<T>)Header.builder()
                .responseTime( LocalDateTime.now() )
                .resultCode( "00000" )
                .responseMessage( "OK" )
                .data(data)
                .build();
    }

    public static <T> Header<T> OK(T data, String responseMessage){
        /**
         * @description 성공 시 데이터 및 메세지 리턴
         * @method OK
         * @params [data, responseMessage]
         * @return com.sy.hr.dg.model.network.Header<T>
         *
         * @author sy
         * @since 2020-12-24
        */
        return (Header<T>)Header.builder()
                .responseTime( LocalDateTime.now() )
                .resultCode( "00000" )
                .responseMessage( responseMessage )
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
                .responseTime( LocalDateTime.now() )
                .resultCode( "ERROR" )
                .responseMessage( responseMessage )
                .build();
    }

    public static <T> Header<T> ERROR( String resultCode, String responseMessage){
        return (Header<T>)Header.builder()
                .responseTime( LocalDateTime.now() )
                .resultCode( resultCode )
                .responseMessage( responseMessage )
                .build();
    }
}
