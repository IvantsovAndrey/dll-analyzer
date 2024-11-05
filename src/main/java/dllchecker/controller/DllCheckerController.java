package dllchecker.controller;

import dllchecker.service.DllCheckerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/dll")
public class DllCheckerController {

    @Autowired
    private DllCheckerService dllCheckerService;

    // Метод для обработки одного пути к файлу DLL
    @PostMapping("/component")
    public String getComponentForDll(@RequestParam String dllPath) {
        return dllCheckerService.findComponentForDll(dllPath);
    }

    // Метод для обработки списка путей к файлам DLL
    @PostMapping("/components")
    public List<String> getComponentsForDlls(@RequestBody List<String> dllPaths) {
        return dllPaths.stream()
                .map(dllCheckerService::findComponentForDll)
                .collect(Collectors.toList());
    }
}
