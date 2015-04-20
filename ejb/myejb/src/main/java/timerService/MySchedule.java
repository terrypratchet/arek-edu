package timerService;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.Schedule;
import javax.ejb.ScheduleExpression;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Singleton
@Startup
public class MySchedule {
	final static Logger logger = LoggerFactory.getLogger(MySchedule.class);

	@Resource
	private TimerService timerService;

	@Schedule(second = "1,30", minute = "*", hour = "*")
	public void someMethod() {
		logger.info("Automatic timeout occurred.");
	}

	//@Timeout
	public void myTimeout(Timer timer) {
		logger.info("programmatic timer expired, so container called this method. " );
	}

	@PostConstruct
	public void init() {
		
		
		if(false){
			ScheduleExpression schedule = new ScheduleExpression();
			schedule.hour("*");
			schedule.minute("*");
			schedule.second("15,45");
			
			Timer timer = timerService.createCalendarTimer(schedule);
			logger.info("manual timer inited");
		}
		
		for(Timer timer : timerService.getTimers()){
			logger.info("timer: " + timer.getNextTimeout());
			//timer.cancel();
		}

	}
}
