package br.com.reactiveapi.reactiveapi.events;

import br.com.reactiveapi.reactiveapi.model.Car;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarEvents {

    private Car model;
    private Date when;

}
