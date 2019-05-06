package ua.jsoft.planner.repository.search;

import ua.jsoft.planner.domain.ProjectHistory;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Spring Data Elasticsearch repository for the ProjectHistory entity.
 */
public interface ProjectHistorySearchRepository extends ElasticsearchRepository<ProjectHistory, Long> {
}
