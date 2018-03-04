package BJSSAPI.Tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.Before;
import org.junit.Test;
import BJSSAPI.payload.payLoad;
import BJSSAPI.resources.resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static io.restassured.RestAssured.when;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class ReqresAPI {

    Properties prop=new Properties();

    @Before
    public void getData() throws IOException
    {
        FileInputStream fis=new FileInputStream("//Users//manojpathi//IdeaProjects//BJSS_API_Automation//src//main//resources//env.properties");
        prop.load(fis);

        RestAssured.baseURI= prop.getProperty("HOST");

    }

    @Test
    public void GetSingleUserData(){

        when().get(resources.getSingleUserData()).
                then().assertThat().statusCode(200).
                body("data.id", equalTo("2")).and().
                body("data.first_name", equalTo("Janet")).and().
                body("data.last_name", equalTo("Weaver")).and().
                body("data.avatar", equalTo("https://s3.amazonaws.com/uifaces/faces/twitter/josephstein/128.jpg") );

        }

    @Test
    public void PostCreateUser(){

        given().
                body(payLoad.postCreateUser()).
                when().
                post(resources.postCreateUser()).
                then().assertThat().statusCode(201).and().contentType(ContentType.JSON).and().
                body("id", notNullValue()).and().body("createdAt", notNullValue());

    }

    @Test
    public void PutUpdateUser(){

      given().
                body(payLoad.putUpdateUser()).
                when().
                post(resources.putUpdateUser()).
                then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and().
                body("updatedAt", notNullValue());


    }

    @Test
    public void PatchUpdateUser() {

        given().
                body(payLoad.patchUpdateUser()).
                when().
                post(resources.patchUpdateUser()).
                then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and().
                body("updatedAt", notNullValue());

    }

    @Test
    public void DeleteUser(){

        when().delete(resources.deleteUser()).
                then().assertThat().statusCode(204).and().contentType(ContentType.JSON);

    }
}
