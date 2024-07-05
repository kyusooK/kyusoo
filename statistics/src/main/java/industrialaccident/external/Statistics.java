package industrialaccident.external;

import java.util.Date;
import lombok.Data;

@Data
public class Statistics {

    private Long id;
    private Long accidentId;
    private String hospitalCode;
    private String businessCode;
    private String results;
    private Date date;
}
