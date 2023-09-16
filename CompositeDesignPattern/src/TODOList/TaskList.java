package TODOList;

import java.util.ArrayList;
import java.util.List;

// TO DO List Task
// The Composite for each task
// Note: Composite is like the Parent of each LEAF (in this case, the subtasks)
public class TaskList implements TDLComponents {
    private String name;
    private List<TDLComponents> tasks = new ArrayList<>();

    public TaskList(String name) {
        this.name = name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public List<TDLComponents> getTDLItem() {
        return tasks;
    }

    public void setTDLItem(List<TDLComponents> TDLItem) {
        this.tasks = TDLItem;
    }

    public void addItem(TDLComponents item) {
        tasks.add(item);
    }

    public void removeItem(TDLComponents item) {
        tasks.remove(item);
    }

    @Override
    public void displayTDL() {
        System.out.println("Task List: " + name);
        for (TDLComponents item : tasks) {
            item.displayTDL();
        }
    }

    @Override
    public void addTask(Tasks task) {
        tasks.add(task);
    }

    @Override
    public void removeTask(Tasks task) {
        tasks.remove(task);
    }

    public String getName() {
        return name;
    }

    public List<TDLComponents> getItems() {
        return tasks;
    }
}
