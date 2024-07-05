package industrialaccident.external;

import java.util.Date;
import lombok.Data;

@Data
public class Assessment {

    private Long id;
    private Long accidentId;
    private String businessCode;
    private String employeeId;
    private Long assessorId;
    private String hospitalCode;
    private String doctorNote;
    private String results;
    private Date date;
    private String comments;
}
