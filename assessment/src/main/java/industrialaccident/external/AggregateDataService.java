package industrialaccident.external;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.Date;
import java.util.List;
@FeignClient(name = "statistics", url = "${api.url.statistics}")
public interface AggregateDataService {
    @GetMapping(path="/aggregateData")
    public List<AggregateData> getAggregateData();
    @GetMapping(path="/aggregateData/{id}")
    public AggregateData getAggregateData(@PathVariable("id")  id);
    @GetMapping(path="/aggregateData")
    public List<AggregateData> getAggregateData();
    @GetMapping(path="/aggregateData/{id}")
    public AggregateData getAggregateData(@PathVariable("id")  id);
}