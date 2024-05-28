package ru.romanov.tests.services;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.romanov.tests.dto.Question;
import ru.romanov.tests.entity.ImageData;
import ru.romanov.tests.repository.ImageDataRepository;


import org.springframework.web.multipart.MultipartFile;
import ru.romanov.tests.util.ImageUtil;

import javax.transaction.Transactional;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static ru.romanov.tests.utils.JsonUtils.getJson;


@Service
public class ImageDataService {

    private final ImageDataRepository imageDataRepository;

    public ImageDataService(ImageDataRepository imageDataRepository) {
        this.imageDataRepository = imageDataRepository;
    }


    public void uploadImage() throws IOException {
        List<String> list = new ArrayList<>();
        JSONObject mainJson = new JSONObject(getJson("src/main/resources/test.json"));
        JSONArray jsonArray = mainJson.getJSONArray("questions");
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonQuestObject = jsonArray.getJSONObject(i);
            list.add(jsonQuestObject.getString("image_path"));
        }

        List<ImageData> imageData = new ArrayList<>();
        for (String s : list) {
            if(s.isEmpty() || s.isBlank())
                continue;
            File file = new File("D:\\guid\\-architecture-of-high-load-applications\\lab3\\flow-crm-tutorial-14-initial\\src\\main\\resources\\META-INF\\resources\\" + s);
            ImageData build = ImageData.builder().name(file.getName().split("\\.")[0])
                    .type(file.toString().split("\\.")[1])
                    .imageData(ImageUtil.compressImage(Files.readAllBytes(file.toPath()))).build();
            imageData.add(build);
        }


        imageDataRepository.saveAll(imageData);
    }

    @Transactional
    public ImageData getInfoByImageByName(String name) {
        Optional<ImageData> dbImage = imageDataRepository.findByName(name);

        return ImageData.builder()
                .name(dbImage.get().getName())
                .type(dbImage.get().getType())
                .imageData(ImageUtil.decompressImage(dbImage.get().getImageData())).build();

    }

    @Transactional
    public byte[] getImage(String name) {
        Optional<ImageData> dbImage = imageDataRepository.findByName(name);
        byte[] image = ImageUtil.decompressImage(dbImage.get().getImageData());
        return image;
    }
}
