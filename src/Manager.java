package src;
import src.controller.EpicManager;
import src.controller.SubTaskManager;
import src.controller.TaskManager;
import src.model.Epic;
import src.model.SubTask;
import src.model.Task;

import java.util.ArrayList;

public class Manager {

    TaskManager taskManager = new TaskManager();
    EpicManager epicManager = new EpicManager();
    SubTaskManager subTaskManager = new SubTaskManager(epicManager);


        //    Получение списка всех задач.
        public ArrayList<Task> findAllTasks() {
            return taskManager.findAll();
        }
        //    Получение списка всех эпиков.
        public ArrayList<Epic> findAllEpics() {
            return epicManager.findAll();
        }
        // Получение списка всех подзадач определённого эпика.
        public ArrayList<SubTask> findAllSubTasksOfEpic(Epic epic) {
            return subTaskManager.findAllOfEpic(epic);
        }

        // Удаление всех задач.
        public void deleteAllTask() {
            taskManager.deleteAll();
        }
        // Удаление всех подзадач.
        public void deleteAllSubTasks() {
            subTaskManager.deleteAll();
        }
        // Удаление всех эпиков.
        public void deleteAllEpics() {
            epicManager.deleteAll();
        }

        // Получение подзадачи по идентификатору
        public SubTask findSubTaskById(Integer id) {
            return subTaskManager.findById(id);
        }
        // Получение задачи по идентификатору
        public Task findTaskById(Integer id) {
            return taskManager.findById(id);
        }
        // Получение эпика по идентификатору
        public Epic findEpicById(Integer id) {
            return epicManager.findById(id);
        }
        // Добавление задачи.
        public Task createTask(Task task) {
            return taskManager.create(task);
        }
        // Добавление подзадачи.
        public SubTask createSubTask(SubTask subTask, Epic epic) {
            return subTaskManager.create(subTask, epic);
        }
        // Добавление Эпика.
        public Epic createEpic(Epic epic) {
            return epicManager.createEpic(epic);
        }
        // Обновление задачи.
        public Task updateTaskByID(Task task) {
            return taskManager.updateTask(task);
        }
        // Обновление подзадачи.
        public SubTask updateSubTaskByID(SubTask subTask) {
            return subTaskManager.updateSubTask(subTask);
        }
        // Обновление эпика.
        public Task updateEpicByID(Epic epic) {
            return epicManager.updateEpic(epic);
        }

        // Удаление подзадач по ID.
        public void deleteSubTaskById(Integer id) {
            subTaskManager.deleteById(id);
        }
        // Удаление эпика по ID.
        public void deleteEpicById(Integer id) {
            epicManager.deleteById(id);
        }
        // Удаление задачи по ID.
        public Task deleteTaskById(Integer id) {
            return taskManager.deleteById(id);
        }
    }