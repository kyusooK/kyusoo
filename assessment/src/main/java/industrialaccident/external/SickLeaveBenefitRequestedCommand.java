package industrialaccident.external;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Data
public class SickLeaveBenefitRequestedCommand {

    @Id
    private Long id;

    private Long accessmentId;
    private Long accidentId;
    private String businessCode;
    private String employeeId;
    private Float averageSalary;
    private Integer period;
    private String status;
    private Date date;
}
