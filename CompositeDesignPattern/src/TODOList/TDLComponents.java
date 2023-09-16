package TODOList;

// Interface Class
// This is where the "blueprints" of each TO DO Task and Sub-tasks are held
// All the methods of the Tasks and Task Lists are applicable to each other

// However, since Tasks are leaves and not the composites,
// the Tasks might not be able to use those methods in this case
public interface TDLComponents {
    void displayTDL();
    void addTask(Tasks task);
    void removeTask(Tasks task);

}
