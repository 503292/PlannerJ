package ua.jsoft.planner.repository;

import ua.jsoft.planner.domain.ProjectHistory;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the ProjectHistory entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ProjectHistoryRepository extends JpaRepository<ProjectHistory, Long> {

}
