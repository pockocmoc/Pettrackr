package pettrackr;

import java.time.LocalDate;

public class DraftAnimal extends Animal{

    public DraftAnimal(String name, LocalDate dateOfBirth, Gender gender) {
        super(name, dateOfBirth, gender);
    }
    @Override
    public String toString() {
        return "Вьючное животное{" +
                "имя='" + getName() + '\'' +
                ", дата рождения=" + getDateOfBirth() +
                ", пол=" + getGender() +
                '}';
    }
}
