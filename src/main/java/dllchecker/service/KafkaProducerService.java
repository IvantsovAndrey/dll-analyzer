/*package dllchecker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
/* Добавим интеграцию с Kafka, чтобы отправлять сообщения о проверке DLL-файлов.
 Когда внешний сервис запрашивает проверку DLL-файла,
 наш микросервис может отправлять информацию в Kafka для последующей обработки. */
/*@Service
public class KafkaProducerService {

    private static final String TOPIC = "dll-check-topic";

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message) {
        kafkaTemplate.send(TOPIC, message);
    }
}*/