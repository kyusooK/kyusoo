package industrialaccident.external;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Data
public class MedicalBenefitAppliedCommand {

    @Id
    private Long id;

    private String businessCode;
    private String employeeId;
    private String name;
    private String hospitalCode;
    private String doctorNote;
    private String accidentType;
    private String status;
    private Date applyDt;
}
