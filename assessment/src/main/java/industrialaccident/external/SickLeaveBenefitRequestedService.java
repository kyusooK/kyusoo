package industrialaccident.external;

import java.util.Date;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "assessment", url = "${api.url.assessment}")
public interface SickLeaveBenefitRequestedService {
    @GetMapping(path = "/sickLeaveBenefitRequesteds")
    public List<SickLeaveBenefitRequested> getSickLeaveBenefitRequested();

    @GetMapping(path = "/sickLeaveBenefitRequesteds/{id}")
    public SickLeaveBenefitRequested getSickLeaveBenefitRequested(
        @PathVariable("id") Long id
    );
}
