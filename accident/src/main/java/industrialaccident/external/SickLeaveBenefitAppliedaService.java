package industrialaccident.external;

import java.util.Date;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "accident", url = "${api.url.accident}")
public interface SickLeaveBenefitAppliedaService {
    @GetMapping(path = "/sickLeaveBenefitAppliedas")
    public List<SickLeaveBenefitApplieda> getSickLeaveBenefitApplieda();

    @GetMapping(path = "/sickLeaveBenefitAppliedas/{id}")
    public SickLeaveBenefitApplieda getSickLeaveBenefitApplieda(
        @PathVariable("id") Long id
    );
}
