// src/main/java/org/example/service/TaskServiceImpl.java

package org.example.service;

import org.example.dto.TaskDTO;
import org.example.entity.Task;
import org.example.entity.User;
import org.example.exception.ResourceNotFoundException;
import org.example.repository.TaskRepository;
import org.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository, UserRepository userRepository) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
    }

    @Override
    public TaskDTO createTask(TaskDTO taskDTO) {
        Task task = convertToEntity(taskDTO);
        Task savedTask = taskRepository.save(task);
        return convertToDTO(savedTask);
    }

    @Override
    public TaskDTO updateTask(Long id, TaskDTO taskDTO) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found with id: " + id));
        updateTaskFromDTO(task, taskDTO);
        Task updatedTask = taskRepository.save(task);
        return convertToDTO(updatedTask);
    }

    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    @Override
    public TaskDTO getTaskById(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found with id: " + id));
        return convertToDTO(task);
    }

    @Override
    public List<TaskDTO> getAllTasks() {
        return taskRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<TaskDTO> getTasksByUserId(Long userId) {
        return taskRepository.findByAssignedUserId(userId).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private Task convertToEntity(TaskDTO taskDTO) {
        Task task = new Task();
        updateTaskFromDTO(task, taskDTO);
        return task;
    }

    private void updateTaskFromDTO(Task task, TaskDTO taskDTO) {
        task.setTitle(taskDTO.getTitle());
        task.setDescription(taskDTO.getDescription());
        task.setDueDate(taskDTO.getDueDate());
        task.setStatus(Task.TaskStatus.valueOf(taskDTO.getStatus()));
        User assignedUser = userRepository.findById(taskDTO.getAssignedUserId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + taskDTO.getAssignedUserId()));
        task.setAssignedUser(assignedUser);
    }

    private TaskDTO convertToDTO(Task task) {
        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setId(task.getId());
        taskDTO.setTitle(task.getTitle());
        taskDTO.setDescription(task.getDescription());
        taskDTO.setDueDate(task.getDueDate());
        taskDTO.setStatus(task.getStatus().name());
        taskDTO.setAssignedUserId(task.getAssignedUser().getId());
        return taskDTO;
    }
}