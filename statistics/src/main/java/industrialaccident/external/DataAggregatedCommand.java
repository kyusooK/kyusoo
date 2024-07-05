package industrialaccident.external;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Data
public class DataAggregatedCommand {

    @Id
    private Long id;

    private Long accidentId;
    private String hospitalCode;
    private String businessCode;
    private String results;
    private Date date;
}
