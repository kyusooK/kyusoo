package industrialaccident.external;

import java.util.Date;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "statistics", url = "${api.url.statistics}")
public interface DataAggregatedService {
    @GetMapping(path = "/dataAggregateds")
    public List<DataAggregated> getDataAggregated();

    @GetMapping(path = "/dataAggregateds/{id}")
    public DataAggregated getDataAggregated(@PathVariable("id") Long id);
}
