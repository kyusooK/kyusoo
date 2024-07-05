package industrialaccident.external;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Data
public class InvestigationDisapprovedCommand {

    @Id
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
