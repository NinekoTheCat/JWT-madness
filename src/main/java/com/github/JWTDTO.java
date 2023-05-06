package com.github;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;


@EqualsAndHashCode
@Getter
@Builder
public class JWTDTO {
  @NonNull String username;
  @NonNull String opid;
}
