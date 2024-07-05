
package industrialaccident.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Date;
import java.util.List;


@FeignClient(name = "assessment", url = "${api.url.assessment}")
 
public interface CreateInvestigationService {
    @GetMapping(path="/createInvestigations")
    public List<CreateInvestigation> getCreateInvestigation();

    @GetMapping(path="/createInvestigations/{id}")
    public CreateInvestigation getCreateInvestigation(@PathVariable("id")  id);
}


