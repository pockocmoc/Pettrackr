package pettrackr;

import java.time.LocalDate;

public class DomesticAnimal extends Animal {

    public DomesticAnimal(String name, LocalDate dateOfBirth, Gender gender) {
        super(name, dateOfBirth, gender);
    }

    @Override
    public String toString() {
        return "Домашнее животное{" +
                "имя='" + getName() + '\'' +
                ", дата рождения=" + getDateOfBirth() +
                ", пол=" + getGender() +
                '}';
    }
}

