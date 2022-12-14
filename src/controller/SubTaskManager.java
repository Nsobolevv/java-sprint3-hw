package src.controller;
import src.model.Epic;
import src.model.SubTask;
import java.util.ArrayList;
import java.util.HashMap;
import static src.model.StatusTrecker.*;


public class SubTaskManager {
    protected Integer counterIDSubTasks = 0;
    protected HashMap<Integer, SubTask> subTasks = new HashMap<>();
    protected EpicManager epicManager;

    public SubTaskManager(EpicManager epicManager) {
        this.epicManager = epicManager;
    }

    // Получение списка всех подзадач определённого эпика.
    public ArrayList<SubTask> findAllOfEpic(Epic epic) {
        return epicManager.epics.get(epic.getId()).getSubTasks();
    }

    // Удаление всех задач.
    public void deleteAll() {
        subTasks.clear();
    }

    // Получить подзадачу по ID

    public SubTask findById(Integer id) {
        return subTasks.get(id);
    }
    // Обновление подзадачи по ID
    public SubTask updateSubTask(SubTask task) {
        final SubTask originalTask = subTasks.get(task.getId());
        if (originalTask == null) {
            System.out.println("Задачи с таким ID не существует.");
            return null;
        }
        originalTask.setDescription(task.getDescription());
        originalTask.setName(task.getName());
        originalTask.setStatus(task.getStatus());
        epicManager.epics.get(task.getEpicID()).getSubTasks().remove(originalTask);
        epicManager.epics.get(task.getEpicID()).getSubTasks().add(task);
        refreshStatus(task);
        return originalTask;
    }

    // Создать подзадачу.
    public SubTask create(SubTask subTask, Epic epic) {
        final SubTask newSubTask = new SubTask(subTask.getName(), subTask.getDescription(), ++counterIDSubTasks, epic.getId());
        if (!subTasks.containsKey(newSubTask.getId())) {
            subTasks.put(newSubTask.getId(), newSubTask);
            epicManager.epics.get(epic.getId()).getSubTasks().add(/*newSubTask.getId(),*/ newSubTask);
        } else {
            System.out.println("Задача с таким ID уже существует");
            return null;
        }
        return newSubTask;
    }

    // Обновление статуса эпика в зависимости от статуса подзадач
    public void refreshStatus(SubTask task) {
        ArrayList<SubTask> subTasksOfEpic = epicManager.epics.get(task.getEpicID()).getSubTasks();
        int counterNew = 0;
        int counterDone = 0;
        for (SubTask subTask : subTasksOfEpic) {
            if (subTask.getStatus().equals(NEW)) {
                counterNew++;
            } else if (subTask.getStatus().equals(DONE)) {
                counterDone++;
            }
        }
        if (counterNew == subTasksOfEpic.size()) {
            epicManager.epics.get(task.getEpicID()).setStatus(NEW);
        } else if (counterDone == subTasksOfEpic.size()) {
            epicManager.epics.get(task.getEpicID()).setStatus(DONE);
        } else {
            epicManager.epics.get(task.getEpicID()).setStatus(IN_PROGRESS);
        }
    }

    // Удаление задачи по идентификатору.
    public SubTask deleteById(Integer id) {
        final SubTask deletedTask = subTasks.get(id);
        epicManager.epics.get(deletedTask.getEpicID()).getSubTasks().remove(deletedTask);
        subTasks.remove(id);
        return deletedTask;
    }
}