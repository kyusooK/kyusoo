
package industrialaccident.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Date;
import java.util.List;


@FeignClient(name = "assessment", url = "${api.url.assessment}")
 
public interface RequestSickLeaveBenefitService {
    @GetMapping(path="/requestSickLeaveBenefits")
    public List<RequestSickLeaveBenefit> getRequestSickLeaveBenefit();

    @GetMapping(path="/requestSickLeaveBenefits/{id}")
    public RequestSickLeaveBenefit getRequestSickLeaveBenefit(@PathVariable("id")  id);
}


