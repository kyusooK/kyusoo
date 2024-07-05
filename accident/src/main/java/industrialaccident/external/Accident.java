package industrialaccident.external;

import java.util.Date;
import lombok.Data;

@Data
public class Accident {

    private Long id;
    private String businessCode;
    private String employeeId;
    private String name;
    private String hospitalCode;
    private Integer period;
    private String doctorNote;
    private String accidentType;
    private String status;
    private Date applyDt;
}
