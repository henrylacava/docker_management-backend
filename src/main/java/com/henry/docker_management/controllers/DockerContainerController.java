package com.henry.docker_management.controllers;

import com.github.dockerjava.api.model.Container;
import com.henry.docker_management.services.DockerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/containers")
public class DockerContainerController {
    private final DockerService dockerService;

    public DockerContainerController(DockerService dockerService) {
        this.dockerService = dockerService;
    }

    @GetMapping
    public List<Container> listContainers() {
        return dockerService.listContainers();
    }

    @PostMapping
    public void createContainer(@RequestParam String image) {
        dockerService.createContainer(image);
    }

    @PostMapping("/{id}/start")
    public void startContainer(@PathVariable String containerId) {
        dockerService.startContainer(containerId);
    }

    @PostMapping("/{id}/stop")
    public void stopContainer(@PathVariable String containerId) {
        dockerService.stopContainer(containerId);
    }

    @DeleteMapping("/{containerId}")
    public ResponseEntity<Void> deleteContainer(@PathVariable String containerId) {
        dockerService.deleteContainer(containerId);
        return ResponseEntity.noContent().build();
    }
}
