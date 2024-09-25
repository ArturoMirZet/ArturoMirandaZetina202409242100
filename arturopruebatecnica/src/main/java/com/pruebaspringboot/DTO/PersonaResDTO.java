package com.pruebaspringboot.DTO;

public class PersonaResDTO {
    private String mensaje;

    public PersonaResDTO(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
