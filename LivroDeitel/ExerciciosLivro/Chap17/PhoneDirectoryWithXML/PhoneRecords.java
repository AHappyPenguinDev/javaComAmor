import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;

public class PhoneRecords {
  @XmlElement(name = "phoneRecord")
  private List<PhoneRecord> phoneRecords = new ArrayList<>();

  public List<PhoneRecord> getPhoneRecords() {
    return phoneRecords;
  }
}
