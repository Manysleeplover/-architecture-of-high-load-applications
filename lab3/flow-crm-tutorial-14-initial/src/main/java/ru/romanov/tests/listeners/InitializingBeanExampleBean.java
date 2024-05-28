package ru.romanov.tests.listeners;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;
import ru.romanov.tests.services.ImageDataService;

@Component
public class InitializingBeanExampleBean implements InitializingBean {

    private final ImageDataService imageDataService;

    public InitializingBeanExampleBean(ImageDataService imageDataService) {
        this.imageDataService = imageDataService;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        imageDataService.uploadImage();
    }
}