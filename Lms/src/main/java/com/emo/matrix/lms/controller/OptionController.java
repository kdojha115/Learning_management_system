package com.emo.matrix.lms.controller;

import com.emo.matrix.lms.models.Option;
import com.emo.matrix.lms.service.OptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/options")
public class OptionController {

    @Autowired
    private OptionService optionService;

    // Create a new option
    @PostMapping("/")
    public ResponseEntity<Option> createOption(@RequestBody Option option) {
        Option createdOption = optionService.createOption(option);
        return ResponseEntity.ok(createdOption);
    }

    // Get an option by ID
    @GetMapping("/{optionId}")
    public ResponseEntity<Option> getOptionById(@PathVariable Long optionId) {
        Optional<Option> option = optionService.getOptionById(optionId);
        return option.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Get all options by question ID
    @GetMapping("/question/{questionId}")
    public ResponseEntity<List<Option>> getOptionsByQuestionId(@PathVariable Long questionId) {
        List<Option> options = optionService.getOptionsByQuestionId(questionId);
        return ResponseEntity.ok(options);
    }

    // Update an existing option
    @PutMapping("/{optionId}")
    public ResponseEntity<Option> updateOption(@PathVariable Long optionId, @RequestBody Option updatedOption) {
        Option option = optionService.updateOption(optionId, updatedOption);
        return ResponseEntity.ok(option);
    }

    // Delete an option by ID
    @DeleteMapping("/{optionId}")
    public ResponseEntity<Void> deleteOption(@PathVariable Long optionId) {
        optionService.deleteOption(optionId);
        return ResponseEntity.noContent().build();
    }
}
