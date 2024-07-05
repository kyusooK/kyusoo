package industrialaccident.external;

import java.util.Date;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "assessment", url = "${api.url.assessment}")
public interface InvestigationCreatedService {
    @GetMapping(path = "/investigationCreateds")
    public List<InvestigationCreated> getInvestigationCreated();

    @GetMapping(path = "/investigationCreateds/{id}")
    public InvestigationCreated getInvestigationCreated(
        @PathVariable("id") Long id
    );
}
