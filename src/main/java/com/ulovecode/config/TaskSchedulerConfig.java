package com.ulovecode.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
/*������ʱ����*/
@ComponentScan("com.ulovecode.common.scheduled")
@EnableScheduling //1
public class TaskSchedulerConfig {

}
