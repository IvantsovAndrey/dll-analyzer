package dllchecker.service;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class DllCheckerService {

    private final Map<String, String> dllToComponentMap = new HashMap<>();

    public DllCheckerService() {
        loadDllComponentMapping("src/main/resources/dlls.txt");
    }

    // Метод для загрузки DLL и их соответствующих компонентов из текстового файла
    private void loadDllComponentMapping(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" ", 2); // Разделяем на dll и компонент
                if (parts.length >= 2 && parts[0].endsWith(".dll")) {
                    dllToComponentMap.put(parts[0], parts[1].trim());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String findComponentForDll(String dllPath) {
        String dllName = extractDllNameFromPath(dllPath);
        return dllToComponentMap.getOrDefault(dllName, "unknown_component");
    }

    private String extractDllNameFromPath(String dllPath) {
        String normalizedPath = dllPath.replace("\\", "/");
        return normalizedPath.substring(normalizedPath.lastIndexOf("/") + 1);
    }

}
