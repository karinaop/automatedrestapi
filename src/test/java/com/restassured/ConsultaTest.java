package com.restassured;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import static io.restassured.RestAssured.*;

public class ConsultaTest {

    @Test
    public void testSucesso()
    {
        //URL
        baseURI = "https://viacep.com.br/";
        basePath = "/ws";

        //consultar CEP válido
        String logradouro = when()
            .get("/08226009/json/")
        .then()
        //.log().all()
            .assertThat()
                .statusCode(200)
                .extract()
                .path("logradouro");
        
        assertEquals("Rua Pássaro Preto", logradouro);        

    }
    @Test
    public void testError()
    {
        //URL
        baseURI = "https://viacep.com.br/";
        basePath = "/ws";

        //consultar CEP inválido
        when()
            .get("/0822600/json/")
        .then()
            //.log().all()
            .assertThat()
                .statusCode(400)
                ;

    }    
}
