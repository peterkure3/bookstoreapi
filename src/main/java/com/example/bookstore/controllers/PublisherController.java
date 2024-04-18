package com.example.bookstore.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookstore.model.Publisher;
import com.example.bookstore.services.PublisherService;

@RestController
@RequestMapping("/publishers")
public class PublisherController {
    @Autowired
    private PublisherService publisherService;

    @GetMapping
    public List<Publisher> getAllPublishers() {
        return publisherService.findAllPublishers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Publisher> getPublisherById(@PathVariable Long id) {
        return publisherService.findPublisherById(id)
            .map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/create")
    public Publisher createPublisher(@RequestBody Publisher publisher) {
        return publisherService.savePublisher(publisher);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Publisher> updatePublisher(@PathVariable Long id, @RequestBody Publisher publisher) {
        return publisherService.findPublisherById(id)
            .map(existingPublisher -> {
                publisher.setId(id);
                return ResponseEntity.ok(publisherService.savePublisher(publisher));
            })
            .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePublisher(@PathVariable Long id) {
        return publisherService.findPublisherById(id)
            .map(publisher -> {
                publisherService.deletePublisher(id);
                return ResponseEntity.ok().<Void>build();
            })
            .orElseGet(() -> ResponseEntity.notFound().build());
    }
}