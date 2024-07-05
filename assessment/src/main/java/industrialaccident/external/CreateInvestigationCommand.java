package industrialaccident.external;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Data
public class CreateInvestigationCommand {

    private Long accidentId;
    private String businessCode;
    private String employeeId;
    private String hospitalCode;
    private String doctorNote;
    private String accidentType;
}
