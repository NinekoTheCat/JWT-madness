package com.github;

import static io.restassured.RestAssured.when;

import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.security.TestSecurity;
import io.quarkus.test.security.jwt.Claim;
import io.quarkus.test.security.jwt.JwtSecurity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@QuarkusTest
@TestHTTPEndpoint(JWTMadnessResource.class)
public class JWTMadnessResourceTests {
  @Test
  @TestSecurity(user = "john", roles = {"user"})
  @JwtSecurity(claims = {
      @Claim(key = "sub", value = "test-id"),
      @Claim(key = "upn", value = "john")
  })
  public void ShouldReturnOK() {
    JWTDTO dto = when().get("/").then().statusCode(200).extract().as(JWTDTO.class);
    Assertions.assertEquals(dto, JWTDTO.builder()
        .opid("test-id")
        .username("john")
        .build()
    );
  }
}
