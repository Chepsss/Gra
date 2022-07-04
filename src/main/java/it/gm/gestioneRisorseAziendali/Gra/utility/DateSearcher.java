package it.gm.gestioneRisorseAziendali.Gra.utility;







import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

import org.springframework.stereotype.Component;



import lombok.Data;


@Component
@Data
public class DateSearcher {
	
	private String startDate;
	private String endDate;
	
	
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	@Override
	public int hashCode() {
		return Objects.hash(endDate, startDate);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DateSearcher other = (DateSearcher) obj;
		return Objects.equals(endDate, other.endDate) && Objects.equals(startDate, other.startDate);
	}
	
	
	
	
	


	
    
    
    

}
