package TODOList;

// TO DO List Item
// Basically the SUB Task for each Tasks ( LEAF )
public class Tasks implements TDLComponents {
    private String name;

    public Tasks(String name) {
        this.name = name;
    }
    @Override
    public void displayTDL() {
        System.out.println("    " + "Task: " + name);
    }

    @Override
    public void addTask(Tasks task) {

    }

    @Override
    public void removeTask(Tasks task) {

    }

    public String getName() {
        return name;
    }
}
