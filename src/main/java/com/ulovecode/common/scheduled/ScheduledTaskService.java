package com.ulovecode.common.scheduled;

import com.ulovecode.modules.paper.service.PaperService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Service
@Slf4j
public class ScheduledTaskService {

	private Lock lock = new ReentrantLock();

	@Autowired
	PaperService paperService;

	  @Scheduled(fixedRate = 10000) //1
	  public void changePstatus() {
		  if (lock.tryLock()) {
			  try {
				paperService.ChangePstatus();
			  } catch (Exception e) {
				  e.printStackTrace();
			  } finally {
				  lock.unlock();
			  }
		  }

	   }






/*
1���루0�C59��
2�����ӣ�0�C59��
3��Сʱ��0�C23��
4���·��е����ڣ�1�C31��
5���·ݣ�1�C12��JAN�CDEC��
6�������е����ڣ�1�C7��SUN�CSAT��
7����ݣ�1970�C2099��
*/
//	  @Scheduled(cron = "* 02-30 17 ? 1 *"  ) //2
//	  public void fixTimeExecution(){
//	      System.out.println("��ָ��ʱ�� " + dateFormat.format(new Date())+"ִ��");
//	  }

}
