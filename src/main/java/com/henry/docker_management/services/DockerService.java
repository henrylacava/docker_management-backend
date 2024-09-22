package com.henry.docker_management.services;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.model.Container;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DockerService {
    private final DockerClient dockerClient;

    public DockerService (DockerClient dockerClient) {
        this.dockerClient = dockerClient;
    }

    public List<Container> listContainers() {
        return dockerClient.listContainersCmd().exec();
    }

    public void createContainer(String image) {
        dockerClient.createContainerCmd(image).exec();
    }

    public void startContainer(String containerId) {
        dockerClient.startContainerCmd(containerId).exec();
    }

    public void stopContainer(String containerId) {
        dockerClient.stopContainerCmd(containerId).exec();
    }

    public void deleteContainer(String containerId) {
        dockerClient.removeContainerCmd(containerId).exec();
    }
}
