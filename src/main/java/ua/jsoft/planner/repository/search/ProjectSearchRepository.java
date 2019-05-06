package ua.jsoft.planner.repository.search;


import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import ua.jsoft.planner.domain.Project;

/**
 * Spring Data Elasticsearch repository for the Project entity.
 */
public interface ProjectSearchRepository extends ElasticsearchRepository<Project, Long> {
}
