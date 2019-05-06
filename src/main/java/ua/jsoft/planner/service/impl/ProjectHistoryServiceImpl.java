package ua.jsoft.planner.service.impl;

import ua.jsoft.planner.repository.search.ProjectHistorySearchRepository;
import ua.jsoft.planner.service.ProjectHistoryService;
import ua.jsoft.planner.domain.ProjectHistory;
import ua.jsoft.planner.repository.ProjectHistoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.elasticsearch.index.query.QueryBuilders.*;

/**
 * Service Implementation for managing ProjectHistory.
 */
@Service
@Transactional
public class ProjectHistoryServiceImpl implements ProjectHistoryService {

    private final Logger log = LoggerFactory.getLogger(ProjectHistoryServiceImpl.class);

    private final ProjectHistoryRepository projectHistoryRepository;

    private final ProjectHistorySearchRepository projectHistorySearchRepository;

    public ProjectHistoryServiceImpl(ProjectHistoryRepository projectHistoryRepository, ProjectHistorySearchRepository projectHistorySearchRepository) {
        this.projectHistoryRepository = projectHistoryRepository;
        this.projectHistorySearchRepository = projectHistorySearchRepository;
    }

    /**
     * Save a projectHistory.
     *
     * @param projectHistory the entity to save
     * @return the persisted entity
     */
    @Override
    public ProjectHistory save(ProjectHistory projectHistory) {
        log.debug("Request to save ProjectHistory : {}", projectHistory);
        ProjectHistory result = projectHistoryRepository.save(projectHistory);
        projectHistorySearchRepository.save(result);
        return result;
    }

    /**
     * Get all the projectHistories.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<ProjectHistory> findAll(Pageable pageable) {
        log.debug("Request to get all ProjectHistories");
        return projectHistoryRepository.findAll(pageable);
    }


    /**
     * Get one projectHistory by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<ProjectHistory> findOne(Long id) {
        log.debug("Request to get ProjectHistory : {}", id);
        return projectHistoryRepository.findById(id);
    }

    /**
     * Delete the projectHistory by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete ProjectHistory : {}", id);
        projectHistoryRepository.deleteById(id);
        projectHistorySearchRepository.deleteById(id);
    }

    /**
     * Search for the projectHistory corresponding to the query.
     *
     * @param query the query of the search
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<ProjectHistory> search(String query, Pageable pageable) {
        log.debug("Request to search for a page of ProjectHistories for query {}", query);
        return projectHistorySearchRepository.search(queryStringQuery(query), pageable);    }
}
