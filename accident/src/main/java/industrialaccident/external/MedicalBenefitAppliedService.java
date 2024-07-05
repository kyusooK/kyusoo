package industrialaccident.external;

import java.util.Date;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "accident", url = "${api.url.accident}")
public interface MedicalBenefitAppliedService {
    @GetMapping(path = "/medicalBenefitApplieds")
    public List<MedicalBenefitApplied> getMedicalBenefitApplied();

    @GetMapping(path = "/medicalBenefitApplieds/{id}")
    public MedicalBenefitApplied getMedicalBenefitApplied(
        @PathVariable("id") Long id
    );
}
