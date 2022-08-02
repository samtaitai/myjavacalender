import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * 
 * @author samta
 *
 */
public class EventItem {

	public Date eventDate;
	public String eventTitle;
	public String eventDetail;
	
	public EventItem() {
		eventDate = null;
		eventTitle = "dummy title";
		eventDetail = "dummy detail";
	}
	
	public Date convertStrToDate(String eventDateStr) {
		
		try {
			eventDate = new SimpleDateFormat("yyyy-mm-dd").parse(eventDateStr);
			
		} catch (ParseException e) {
			System.out.println(e.toString());
		}
		return eventDate;
	}
}
