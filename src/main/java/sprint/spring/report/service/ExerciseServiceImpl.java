package sprint.spring.report.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import sprint.spring.report.entity.LazyInnerSingletonExercise;

@Service
public class ExerciseServiceImpl implements ExerciseService {

    @Override
    public ResponseEntity<String> getExercise() {
        LazyInnerSingletonExercise singleton = LazyInnerSingletonExercise.getInstance();
        return new ResponseEntity<String>(singleton.toString(), HttpStatus.OK);
    }
}
