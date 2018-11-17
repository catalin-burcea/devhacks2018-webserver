package ro.cburcea.hackathon.webapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.cburcea.hackathon.webapp.entities.Tag;
import ro.cburcea.hackathon.webapp.repositories.TagRepository;

import java.util.List;

@RestController
public class TagsController {

    @Autowired
    TagRepository tagRepository;

    @GetMapping(path = "/tags", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Tag> getTags() {
        return tagRepository.findAll();
    }

}
