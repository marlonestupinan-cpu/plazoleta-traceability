package com.pragma.traceability.infrastructure.out.mongo.entity;

import com.pragma.traceability.domain.model.State;
import lombok.AllArgsConstructor;
import lombok.Data;
import nonapi.io.github.classgraph.json.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document(collection = "trazabilidad")
@AllArgsConstructor
public class LogEntity {
    @Id
    private String id;
    @Field("estado_anterior")
    private State oldState;
    @Field("estado_nuevo")
    private State newState;
    @Field("id_cliente")
    private Long idClient;
    @Field("id_empleado")
    private Long idEmployee;
    @Field("id_pedido")
    private Long idOrder;
    @Field("id_restaurante")
    private Long idRestaurant;
    @Field("fecha")
    private Long datetime;
    @Field("correo_empleado")
    private String employeeEmail;
}
