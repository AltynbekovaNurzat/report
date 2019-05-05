package sprint.spring.report.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sprint.spring.report.service.ExerciseService;

@RestController
@RequestMapping("sprint/exercise")
public class ExerciseController {
    @Autowired
    private ExerciseService exerciseService;

    @GetMapping
    public ResponseEntity<String> getExercise(){
        /*ResponseEntity<LazyInnerSingletonExercise> responseEntity = exerciseService.getExercise();
        System.out.println(responseEntity.getBody());
        return responseEntity;*/
        return exerciseService.getExercise();
    }
}
