package industrialaccident.external;

import java.util.Date;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "assessment", url = "${api.url.assessment}")
public interface InvestigationDisapprovedService {
    @GetMapping(path = "/investigationDisapproveds")
    public List<InvestigationDisapproved> getInvestigationDisapproved();

    @GetMapping(path = "/investigationDisapproveds/{id}")
    public InvestigationDisapproved getInvestigationDisapproved(
        @PathVariable("id") Long id
    );
}
