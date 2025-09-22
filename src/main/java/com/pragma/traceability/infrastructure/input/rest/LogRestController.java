package com.pragma.traceability.infrastructure.input.rest;

import com.pragma.traceability.application.dto.request.SaveLogRequestDto;
import com.pragma.traceability.application.handler.ILogHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/log")
@RequiredArgsConstructor
public class LogRestController {
    private final ILogHandler  logHandler;

    @PostMapping
    @PreAuthorize("hasAnyRole('CLIENTE', 'EMPLEADO')")
    public ResponseEntity<Void> log(@RequestBody @Valid SaveLogRequestDto log) {
        logHandler.saveLog(log);
        return ResponseEntity.ok().build();
    }
}
