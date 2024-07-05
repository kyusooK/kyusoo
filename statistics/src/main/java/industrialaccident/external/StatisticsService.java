package industrialaccident.external;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.Date;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;
@FeignClient(name = "statistics", url = "${api.url.statistics}")
public interface StatisticsService {
    @RequestMapping(method= RequestMethod., path="/statistics/{id}")
    public void dataAggregated(@PathVariable("id") Long id, @RequestBody DataAggregatedCommand dataAggregatedCommand );
}