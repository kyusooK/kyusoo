
package industrialaccident.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Date;
import java.util.List;


@FeignClient(name = "assessment", url = "${api.url.assessment}")
 
public interface CreateSickLeaveBenefitService {
    @GetMapping(path="/createSickLeaveBenefits")
    public List<CreateSickLeaveBenefit> getCreateSickLeaveBenefit();

    @GetMapping(path="/createSickLeaveBenefits/{id}")
    public CreateSickLeaveBenefit getCreateSickLeaveBenefit(@PathVariable("id")  id);
}


