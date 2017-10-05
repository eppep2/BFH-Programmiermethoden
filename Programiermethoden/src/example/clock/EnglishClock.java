package example.clock;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class EnglishClock implements Clock {

	@Override
	public String getTime() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("hh:mm a");
		return sdf.format(cal.getTime());
	}

}
