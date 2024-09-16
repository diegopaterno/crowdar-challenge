package org.crowdar.apis;

import io.qameta.allure.Step;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class SpecBuilder {

    @Step("Genera las condiciones para consumir el servicio")
    public static RequestSpecification getRequestSpecification(String endpoint) {
        return new RequestSpecBuilder().
                setBaseUri(endpoint).
                setContentType(ContentType.JSON).
                addFilter(new AllureRestAssured()).
                addFilter(ResponseLoggingFilter.responseLogger()).
                build();
    }
    }
