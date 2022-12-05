package src.controller;
import src.model.Task;
import java.util.ArrayList;
import java.util.HashMap;


public class TaskManager {
    private HashMap<Integer, Task> tasks = new HashMap<>();
    private Integer counterIDTasks = 0;

    // Получение списка всех задач
    public ArrayList<Task> findAll() {
        return new ArrayList<>(tasks.values());
    }

    // Удаление всех задач.
    public void deleteAll() {
        tasks.clear();
    }

    // Получение задачи по ID
    public Task findById(Integer id) {
        return tasks.get(id);
    }

    //    Создание новой задачи
    public Task create(Task task) {
        final Task newTask = new Task(task.getName(), task.getDescription(), ++counterIDTasks);
        if (!tasks.containsKey(newTask.getId()))
            tasks.put(newTask.getId(), newTask);
        else {
            System.out.println("Задача с таким ID уже существует");
            return null;
        }
        return newTask;
    }
    // Обновление задачи по ID
    public Task updateTask(Task task) {
        final Task originalTask = tasks.get(task.getId());
        if (originalTask == null) {
            System.out.println("Задачи с таким ID не существует.");
            return null;
        }
        originalTask.setDescription(task.getDescription());
        originalTask.setName(task.getName());
        originalTask.setStatus(task.getStatus());
        return originalTask;
    }

    // Удаление задачи по идентификатору.
    public Task deleteById(Integer id) {
        final Task deletedTask = tasks.get(id);
        tasks.remove(id);
        return deletedTask;
    }
}
