import java.io.Serializable;

public class UserStory implements Serializable {
    private static int idCounter = 1;
    private int id;
    private String title;
    private String acceptanceCriteria;
    private String project;
    private int value, effort, risk, dependency;
    private double priority;

    public UserStory(String title, String acceptanceCriteria, String project, int value, int effort, int risk, int dependency) {
        this.id = idCounter++;
        this.title = title;
        this.acceptanceCriteria = acceptanceCriteria;
        this.project = project;
        setValue(value);
        setEffort(effort);
        setRisk(risk);
        setDependency(dependency);
        calculatePriority();
    }

    public void calculatePriority() {
        this.priority = (double) value / (effort + risk + dependency);
    }

    // Setter-Methoden mit Validierung
    public void setValue(int value) { if (value >= 0) this.value = value; }
    public void setEffort(int effort) { if (effort >= 0) this.effort = effort; }
    public void setRisk(int risk) { if (risk >= 0) this.risk = risk; }
    public void setDependency(int dependency) { if (dependency >= 0) this.dependency = dependency; }

    @Override
    public String toString() {
        return String.format("ID: %d, Title: %s, Priority: %.2f", id, title, priority);
    }

    // Getter für tabellarische Übersicht
    public int getId() { return id; }
    public String getTitle() { return title; }
    public double getPriority() { return priority; }
}
