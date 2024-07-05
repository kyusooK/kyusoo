package industrialaccident.external;

import java.util.Date;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "assessment", url = "${api.url.assessment}")
public interface InvestigationApprovedService {
    @GetMapping(path = "/investigationApproveds")
    public List<InvestigationApproved> getInvestigationApproved();

    @GetMapping(path = "/investigationApproveds/{id}")
    public InvestigationApproved getInvestigationApproved(
        @PathVariable("id") Long id
    );
}
