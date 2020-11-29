package com.sy.hr.dg.config;

import org.springframework.context.annotation.Configuration;
        import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration //설정파일에 대한 선언
@EnableJpaAuditing //jpa대한 감시 활성화
public class JpaConfig {

}
