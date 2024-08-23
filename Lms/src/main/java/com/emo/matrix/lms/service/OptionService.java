package com.emo.matrix.lms.service;

import com.emo.matrix.lms.models.Option;
import com.emo.matrix.lms.repository.OptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OptionService {

    @Autowired
    private OptionRepository optionRepository;

    public Option createOption(Option option) {
        return optionRepository.save(option);
    }

    public List<Option> getOptionsByQuestionId(Long questionId) {
        return optionRepository.findByQuestionId(questionId);
    }

    public Optional<Option> getOptionById(Long optionId) {
        return optionRepository.findById(optionId);
    }

    public Option updateOption(Long optionId, Option updatedOption) {
        return optionRepository.findById(optionId).map(option -> {
            option.setText(updatedOption.getText());
            option.setIsCorrect(updatedOption.getIsCorrect());
            return optionRepository.save(option);
        }).orElseThrow(() -> new RuntimeException("Option not found with id: " + optionId));
    }

    public void deleteOption(Long optionId) {
        optionRepository.deleteById(optionId);
    }
}
