package industrialaccident.external;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Data
public class CreateCompensationCommand {

    private Long sickLeaveId;
    private Long assessmentId;
    private Long accidentId;
    private String employeeId;
    private Float averageSalary;
    private Integer period;
}
