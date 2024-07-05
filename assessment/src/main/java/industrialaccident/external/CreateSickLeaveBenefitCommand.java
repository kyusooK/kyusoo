package industrialaccident.external;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Data
public class CreateSickLeaveBenefitCommand {

    private Long accessmentId;
    private Long accidentId;
    private String businessCode;
    private String employeeId;
}
