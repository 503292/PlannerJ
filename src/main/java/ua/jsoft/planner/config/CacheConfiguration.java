package ua.jsoft.planner.config;

import java.time.Duration;

import org.ehcache.config.builders.*;
import org.ehcache.jsr107.Eh107Configuration;

import io.github.jhipster.config.jcache.BeanClassLoaderAwareJCacheRegionFactory;
import io.github.jhipster.config.JHipsterProperties;

import org.springframework.boot.autoconfigure.cache.JCacheManagerCustomizer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.*;
import ua.jsoft.planner.domain.ProjectHistory;

@Configuration
@EnableCaching
public class CacheConfiguration {

    private final javax.cache.configuration.Configuration<Object, Object> jcacheConfiguration;

    public CacheConfiguration(JHipsterProperties jHipsterProperties) {
        BeanClassLoaderAwareJCacheRegionFactory.setBeanClassLoader(this.getClass().getClassLoader());
        JHipsterProperties.Cache.Ehcache ehcache =
            jHipsterProperties.getCache().getEhcache();

        jcacheConfiguration = Eh107Configuration.fromEhcacheCacheConfiguration(
            CacheConfigurationBuilder.newCacheConfigurationBuilder(Object.class, Object.class,
                ResourcePoolsBuilder.heap(ehcache.getMaxEntries()))
                .withExpiry(ExpiryPolicyBuilder.timeToLiveExpiration(Duration.ofSeconds(ehcache.getTimeToLiveSeconds())))
                .build());
    }

    @Bean
    public JCacheManagerCustomizer cacheManagerCustomizer() {
        return cm -> {
            cm.createCache(ua.jsoft.planner.repository.UserRepository.USERS_BY_LOGIN_CACHE, jcacheConfiguration);
            cm.createCache(ua.jsoft.planner.repository.UserRepository.USERS_BY_EMAIL_CACHE, jcacheConfiguration);
            cm.createCache(ua.jsoft.planner.domain.User.class.getName(), jcacheConfiguration);
            cm.createCache(ua.jsoft.planner.domain.Authority.class.getName(), jcacheConfiguration);
            cm.createCache(ua.jsoft.planner.domain.User.class.getName() + ".authorities", jcacheConfiguration);
            cm.createCache(ua.jsoft.planner.domain.Region.class.getName(), jcacheConfiguration);
            cm.createCache(ua.jsoft.planner.domain.Country.class.getName(), jcacheConfiguration);
            cm.createCache(ua.jsoft.planner.domain.Location.class.getName(), jcacheConfiguration);
            cm.createCache(ua.jsoft.planner.domain.Department.class.getName(), jcacheConfiguration);
            cm.createCache(ua.jsoft.planner.domain.Department.class.getName() + ".employees", jcacheConfiguration);
            cm.createCache(ua.jsoft.planner.domain.Task.class.getName(), jcacheConfiguration);
            cm.createCache(ua.jsoft.planner.domain.Task.class.getName() + ".projects", jcacheConfiguration);
            cm.createCache(ua.jsoft.planner.domain.Employee.class.getName(), jcacheConfiguration);
            cm.createCache(ua.jsoft.planner.domain.Employee.class.getName() + ".projects", jcacheConfiguration);
            cm.createCache(ua.jsoft.planner.domain.Project.class.getName(), jcacheConfiguration);
            cm.createCache(ua.jsoft.planner.domain.Project.class.getName() + ".tasks", jcacheConfiguration);
            cm.createCache(ProjectHistory.class.getName(), jcacheConfiguration);
            // jhipster-needle-ehcache-add-entry
        };
    }
}
