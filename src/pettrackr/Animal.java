package pettrackr;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Animal {

    private String name;
    private LocalDate dateOfBirth;
    private Gender gender;
    private List<String> commands;

    public Animal(String name, LocalDate dateOfBirth, Gender gender) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.commands = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void listCommands() {
        System.out.println(commands.isEmpty() ? "Нет доступных команд." : commands.toString());
    }

    public void addCommand(String command) {
        commands.add(command);
    }


    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public List<String> getCommands() {
        return commands;
    }

    public void setCommands(List<String> commands) {
        this.commands = commands;
    }
    
}
