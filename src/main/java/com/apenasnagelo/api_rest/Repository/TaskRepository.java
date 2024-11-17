package com.apenasnagelo.api_rest.Repository;

import com.apenasnagelo.api_rest.Model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Integer> {
    List<Task> findByUserId(Integer userId);
}