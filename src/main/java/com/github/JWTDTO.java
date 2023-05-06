package com.github;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NonNull;


@EqualsAndHashCode
@Builder
public class JWTDTO {
  @NonNull String username;
  @NonNull String opid;
}
