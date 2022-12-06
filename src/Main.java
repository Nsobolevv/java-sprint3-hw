package src;
import src.controller.Manager;
import src.model.Epic;
import src.model.SubTask;
import src.model.Task;
import java.util.ArrayList;
import static src.model.StatusTrecker.*;

public class Main {
    public static void main(String[] args) {

        System.out.println("Начинаем тестирование ");
        Manager manager = new Manager();
        System.out.println("Метод createTask(task).");
        final Task task = new Task("Задача", "Описание", -1, NEW);
        final Task task2 = new Task("Задача 2", "Описание", -1, NEW);
        System.out.println("Создаем 2 задачи");
        final Task createdTask = manager.createTask(task);
        final Task createdTask1 = manager.createTask(task2);
        System.out.println("Печатаем содержание 2х задач");
        System.out.println(createdTask);
        System.out.println(createdTask1);
        if (!task.equals(createdTask) && !createdTask.equals(createdTask1)) {
            System.out.println("Метод createTask(task) работает штатно");
        }else {
            System.out.println("Метод createTask(task) работает неправильно");
        }

        System.out.println("Метод findAllTask().");
        ArrayList<Task> taskArrayList = manager.findAllTasks();
        System.out.println("Метод findAllTask(). Печатаем весь список задач:");
        for (Task value : taskArrayList) {
            System.out.println(value);
        }
        if (taskArrayList.isEmpty()) {
            System.out.println("Метод findAllTask() не возвращает список задач");
        } else {
            System.out.println("Метод findAllTask() работает правильно");
        }

        System.out.println("Метод findTaskById().");
        Task foundTask = manager.findTaskById(2);
        System.out.println("Печатаем найденную задачу");
        System.out.println(foundTask);
        if (foundTask.getId() != null) {
            System.out.println("Метод findById() работает");
        }else {
            System.out.println("Метод findById() задачу не нашел");
        }

        System.out.println("Метод updateTaskById().");
        final Task createdTask2 = manager.updateTaskByID(createdTask1);
        System.out.println("Печатам переданную в метод и обновленную задачу:");
        System.out.println(createdTask1);
        System.out.println(createdTask2);
        if (createdTask2.equals(createdTask1)) {
            System.out.println("Метод updateTaskById() работает");
        }else {
            System.out.println("Метод updateTaskById() не работает");
        }

        System.out.println("Метод deleteTaskById().");
        System.out.println("Печатам удаляемую задачу:");
        System.out.println(manager.findTaskById(1));
        manager.deleteTaskById(1);
        if (manager.findTaskById(1) == null) {
            System.out.println("Задача удалена. Метод deleteTaskById() работает правильно.");
        }else {
            System.out.println("Метод deleteTaskById() не работает");
        }

        System.out.println("Метод deleteAllTask().");
        manager.deleteAllTask();
        if (manager.findAllTasks().isEmpty()) {
            System.out.println("Метод deleteAllTask() работает правильно");
        } else {
            System.out.println("Метод deleteAllTask() не работает");
        }

        System.out.println("Метод findEpic(id).");
        final Epic epic = new Epic("Эпик", "descriptionOfEpic", -1);
        System.out.println("Создаем 2 эпика");
        final Epic createdEpic = manager.createEpic(epic);
        final Epic createdEpic1 = manager.createEpic(epic);
        System.out.println("Печатаем содержание 2х задач");
        System.out.println(createdEpic);
        System.out.println(createdEpic1);
        if (!epic.equals(createdEpic) && !createdEpic.equals(createdEpic1)) {
            System.out.println("Метод createEpic(task) работает штатно");
        }else {
            System.out.println("Метод createEpic(task) работает неправильно");
        }

        System.out.println("Метод findAllEpics().");
        ArrayList<Epic> epicArrayList = manager.findAllEpics();
        System.out.println("Метод findAllEpics(). Печатаем весь список задач:");
        for (Task value : epicArrayList) {
            System.out.println(value);
        }
        if (epicArrayList.isEmpty()) {
            System.out.println("Метод findAllEpics() не возвращает список задач");
        } else {
            System.out.println("Метод findAllEpics() работает правильно");
        }

        System.out.println("Метод createSubTask(subtask, epic).");
        final SubTask subTask = new SubTask("Подзадача", "Описание", -1, 1);
        System.out.println("Создаем и печатаем 2 подзадачи одного эпика");
        final SubTask subTask1 = manager.createSubTask(subTask, createdEpic);
        final SubTask subTask2 = manager.createSubTask(subTask, createdEpic);
        System.out.println(subTask1);
        System.out.println(subTask2);
        System.out.println("Создаем и печатаем 2 подзадачи другого эпика");
        final SubTask subTask3 = manager.createSubTask(subTask, createdEpic1);
        final SubTask subTask4 = manager.createSubTask(subTask, createdEpic1);
        System.out.println(subTask3);
        System.out.println(subTask4);
        if (subTask1.getEpicID().equals(subTask2.getEpicID()) && subTask3.getEpicID().equals(subTask4.getEpicID())) {
            System.out.println("Метод createSubTask(subtask, epic) работает штатно");
        }else {
            System.out.println("Метод createSubTask(subtask, epic) работает неправильно");
        }

        System.out.println("Метод findSubTaskById().");
        SubTask foundSubTask = manager.findSubTaskById(2);
        System.out.println("Печатаем найденную задачу");
        System.out.println(foundSubTask);
        if (foundTask.getId() != null) {
            System.out.println("Метод findSubTaskById() работает");
        }else {
            System.out.println("Метод findSubTaskById() задачу не нашел");
        }

        System.out.println("Метод updateSubTaskById().");
        System.out.println("Печатаем задачу до обновления");
        System.out.println(subTask1);
        subTask1.setStatus(DONE);
        manager.updateSubTaskByID(subTask1);
        System.out.println("Печатаем задачу после обновления");
        System.out.println(subTask1);
        System.out.println("Проверяем статус эпика");
        System.out.println(manager.findEpicById(1));
        System.out.println("Получение всех подзадач эпика");
        ArrayList<SubTask> listEpics = manager.findAllSubTasksOfEpic(manager.findEpicById(2));
        System.out.println(listEpics);
        System.out.println("Проверка обновления статуса и удаления подзадач.");
        SubTask subTask5 = new SubTask("Подзадача 5", "Описание", 3, 2);
        SubTask subTask6 = new SubTask("Подзадача 6", "Описание", 4, 2);
        subTask5.setStatus(DONE);
        subTask6.setStatus(DONE);
        manager.updateSubTaskByID(subTask5);
        manager.updateSubTaskByID(subTask6);
        System.out.println(listEpics);
        System.out.println(manager.findEpicById(2));
        System.out.println(manager.findAllSubTasksOfEpic(manager.findEpicById(2)));
        manager.deleteSubTaskById(3);
        System.out.println(manager.findAllSubTasksOfEpic(manager.findEpicById(2)));

        System.out.println("Метод findEpic(epic).");
        Epic findEpic = manager.findEpicById(1);
        System.out.println("Печатаем найденный эпик");
        System.out.println(findEpic);
        if (1 == findEpic.getId()) {
            System.out.println("Метод createEpic(epic) работает штатно");
        } else {
            System.out.println("Метод createEpic(epic) не работает");
        }

        System.out.println("Метод deleteAllEpics().");
        manager.deleteAllEpics();
        if (manager.findAllEpics().isEmpty()) {
            System.out.println("Метод deleteAllEpics() работает правильно");
        } else {
            System.out.println("Метод deleteAllEpics() не работает");
        }


    }
}
