package thisiscomedy.nodamnodam.server.domain.rank.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import thisiscomedy.nodamnodam.server.domain.rank.presentation.dto.response.RankResponse;
import thisiscomedy.nodamnodam.server.domain.stats.application.StatsGetService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RankGetService {

    private final StatsGetService statsGetService;

    public List<RankResponse> execute() {
        return statsGetService.getRank();
    }
}
