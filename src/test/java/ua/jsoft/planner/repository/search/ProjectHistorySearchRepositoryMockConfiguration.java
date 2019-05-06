package ua.jsoft.planner.repository.search;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Configuration;

/**
 * Configure a Mock version of ProjectHistorySearchRepository to test the
 * application without starting Elasticsearch.
 */
@Configuration
public class ProjectHistorySearchRepositoryMockConfiguration {

    @MockBean
    private ProjectHistorySearchRepository mockProjectHistorySearchRepository;

}
