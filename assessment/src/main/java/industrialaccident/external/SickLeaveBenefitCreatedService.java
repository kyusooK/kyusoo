package industrialaccident.external;

import java.util.Date;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "assessment", url = "${api.url.assessment}")
public interface SickLeaveBenefitCreatedService {
    @GetMapping(path = "/sickLeaveBenefitCreateds")
    public List<SickLeaveBenefitCreated> getSickLeaveBenefitCreated();

    @GetMapping(path = "/sickLeaveBenefitCreateds/{id}")
    public SickLeaveBenefitCreated getSickLeaveBenefitCreated(
        @PathVariable("id") Long id
    );
}
