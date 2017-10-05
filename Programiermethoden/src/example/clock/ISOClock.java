package example.clock;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ISOClock implements Clock{

	@Override
	public String getTime() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss.SSS");
		return sdf.format(cal.getTime());
	}

}
