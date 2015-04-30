package timerService;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
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
public class ProgrammaticSchedule {
	final static Logger logger = LoggerFactory.getLogger(ProgrammaticSchedule.class);

	@Resource
	private TimerService timerService;



	@Timeout // or ejbTimeout() method
	public void myTimeout(Timer timer) {
		logger.info("programmatic timer expired, so container called this method. " );
	}

	@PostConstruct
	public void init() {

		ScheduleExpression schedule = new ScheduleExpression();
		schedule.hour("*");
		schedule.minute("*");
		schedule.second("15,45");
		schedule.dayOfMonth(3);

		timerService.createCalendarTimer(schedule);
		logger.info("manual timer inited");

		for (Timer timer : timerService.getTimers()) {
			logger.info("timer: " + timer.getNextTimeout());
			timer.cancel();
		}

	}
}
