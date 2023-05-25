package com.fundacio.esplai.hacktahon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 RETO: En esta ocasión, cada equipo deberá desarrollar una aplicativo web que proporcione a los usuarios la capacidad
 de iniciar sesión como un país específico y explorar diversos datos y estadísticas, relacionados con el impacto
 medioambiental de un país sobre la huella de carbono (toneladas de CO2),  al mismo tiempo que les permite realizar comparativas con
 otros países.
 */

@SpringBootApplication
public class HacktahonApplication {

	public static void main(String[] args) {
		SpringApplication.run(HacktahonApplication.class, args);
	}

}
