package io.asdx.demo.adapter.rest;

import io.asdx.demo.adapter.repository.CountryRepository;
import io.asdx.demo.domain.model.Submission;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class FormController {

    private final CountryRepository repository;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("submission", Submission.builder().build());
        model.addAttribute("countries", repository.getAllCountry());
        return "index";
    }

    @PostMapping("/submitForm")
    public String submitForm(@ModelAttribute Submission submission) {
        return "result";
    }
}
