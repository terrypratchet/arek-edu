package timerService;

import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Singleton
@Startup
public class AutoSchedule {
	final static Logger logger = LoggerFactory.getLogger(AutoSchedule.class);

	@Schedule(second = "1,30", minute = "*", hour = "*")
	public void someMethod() {
		logger.info("Automatic timeout occurred.");
	}

}
