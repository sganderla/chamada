package br.com.uniamerica.chamada.infraestrutura;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.AnnotationAwareOrderComparator;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Eduardo Sganderla
 *
 * @version 1.0.0, 28/02/2023
 * @since 1.0.0
 */
@Slf4j
@Service
public class ApplicationInitializer {

    private List<InitialTask> tasks;

    /**
     *
     *
     * @param tasks
     */
    public ApplicationInitializer(final List<InitialTask> tasks) {
        this.tasks = tasks;
    }

    /**
     *
     */
    @PostConstruct
    public void orderTasks() {
        this.tasks.sort(AnnotationAwareOrderComparator.INSTANCE);
    }

    /**
     *
     * @param event
     */
    @EventListener
    public void onApplicationStart(final ContextRefreshedEvent event) {
        this.tasks.forEach(InitialTask::perform);
    }
}