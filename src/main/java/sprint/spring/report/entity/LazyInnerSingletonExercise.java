package sprint.spring.report.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class LazyInnerSingletonExercise {
    @Id
    private Integer id;
    private String exercise;

    private LazyInnerSingletonExercise(Integer id, String exercise) {
        this.id = id;
        this.exercise = exercise;
    }

    private static class SingletonHelper {
        private static final LazyInnerSingletonExercise INSTANCE
                = new LazyInnerSingletonExercise(1, "Ex1: сделать упр с Шульте 10шт; ex2: читать S2 30мин; ex3: решить 50 задачек");
    }

    public static LazyInnerSingletonExercise getInstance() {
        return SingletonHelper.INSTANCE;
    }

    @Override
    public String toString() {
        return exercise;
    }
}