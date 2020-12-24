package com.sy.hr.dg.email.service;

import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.model.AmazonSimpleEmailServiceException;
import com.amazonaws.services.simpleemail.model.SendEmailResult;
import com.sy.hr.dg.email.dto.SendEmail;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Component
@RequiredArgsConstructor
public class EmailService {

    private final AmazonSimpleEmailService amazonSimpleEmailService;

    public Map<String, String> sendEmail(String toEmail, String fromEmail, String title, String content) {
        Map<String, String> resultMap = new HashMap<>();

        try {
            SendEmail sendEmail = SendEmail.builder().to( toEmail ).from( fromEmail ).subject( title ).content( content ).build();
            SendEmailResult sendEmailResult = amazonSimpleEmailService.sendEmail(sendEmail.toSendRequestDto());

            if(sendEmailResult.getSdkHttpMetadata().getHttpStatusCode() == 200) {
                log.info("[AWS SES] 메일전송완료 => " + sendEmail.getTo());

                resultMap.put( "status", "success" );
            }else {
                log.error("[AWS SES] 메일 전송 중 에러가 발생했습니다. : {}", sendEmailResult.getSdkResponseMetadata().toString());
                log.error("발송 실패 대상자: " + sendEmail.getTo() + " / subject: " + sendEmail.getSubject());

                resultMap.put( "status", "fail" );
                resultMap.put( "errorMessage", sendEmailResult.getSdkResponseMetadata().toString() );
            }
        } catch ( AmazonSimpleEmailServiceException e ) {

        }
        return resultMap;
    }
}
