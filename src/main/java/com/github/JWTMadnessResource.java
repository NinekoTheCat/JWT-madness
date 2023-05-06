package com.github;

import io.quarkus.security.Authenticated;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.jwt.Claim;
import org.eclipse.microprofile.jwt.Claims;

@Path("jwt")
@RequestScoped
public class JWTMadnessResource {
  @Inject
  @Claim(standard = Claims.sub)
  String openUserId;
  @Inject
  @Claim(standard = Claims.upn)
  String userName;

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Authenticated
  public Uni<JWTDTO> getInfo() {
    // this should be ok
    final JWTDTO jwtdto = JWTDTO.builder()
        .opid(openUserId)
        .username(userName)
        .build();
    return Uni.createFrom().item(jwtdto);
  }
}
