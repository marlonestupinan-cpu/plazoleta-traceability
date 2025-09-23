package com.pragma.traceability.infrastructure.input.rest;

import com.pragma.traceability.application.dto.request.SaveLogRequestDto;
import com.pragma.traceability.application.dto.response.EmployeeResumeDto;
import com.pragma.traceability.application.dto.response.LogResponseDto;
import com.pragma.traceability.application.dto.response.OrderResumeDto;
import com.pragma.traceability.application.handler.ILogHandler;
import com.pragma.traceability.infrastructure.configuration.security.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/log")
@RequiredArgsConstructor
public class LogRestController {
    private final ILogHandler logHandler;

    @PostMapping
    @PreAuthorize("hasAnyRole('CLIENTE', 'EMPLEADO')")
    public ResponseEntity<Void> log(@RequestBody @Valid SaveLogRequestDto log) {
        logHandler.saveLog(log);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    @PreAuthorize("hasRole('CLIENTE')")
    public ResponseEntity<List<LogResponseDto>> getOrderLogs(
            @RequestParam Long idOrder,
            @AuthenticationPrincipal CustomUserDetails user
    ) {
        return ResponseEntity.ok(logHandler.getOrderLogs(idOrder, user.getId()));
    }

    @GetMapping("/orders/resume")
    @PreAuthorize("hasRole('PROPIETARIO')")
    public ResponseEntity<List<OrderResumeDto>> getOrdersResume(
            @RequestParam Long idRestaurant) {
        return ResponseEntity.ok(logHandler.getOrderResume(idRestaurant));
    }

    @GetMapping("/employees/resume")
    @PreAuthorize("hasRole('PROPIETARIO')")
    public ResponseEntity<List<EmployeeResumeDto>> getEmployeesResume(
            @RequestParam Long idRestaurant) {
        return ResponseEntity.ok(logHandler.getEmployeeResume(idRestaurant));
    }

}
