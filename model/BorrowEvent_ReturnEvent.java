package model;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
interface BorrowEvent {
	public String tg_muon();
}
interface ReturnEvent {
	public String tg_tra();
}
public class BorrowEvent_ReturnEvent implements BorrowEvent,ReturnEvent{

	private LocalDateTime myDate = LocalDateTime.now();
	private DateTimeFormatter myDateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
	private String thoi_gian_hien_tai = myDate.format(myDateFormatter);

	public String tg_tra() {
		// TODO Auto-generated method stub
		return thoi_gian_hien_tai;
	}

	public String tg_muon() {
		// TODO Auto-generated method stub
		return thoi_gian_hien_tai;
	}
	
}