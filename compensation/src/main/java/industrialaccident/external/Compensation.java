package industrialaccident.external;

import java.util.Date;
import lombok.Data;

@Data
public class Compensation {

    private Long id;
    private Long sickLeaveId;
    private Long assessmentId;
    private Long accidentId;
    private String employeeId;
    private Float amount;
    private String method;
    private Date date;
    private String status;
}
