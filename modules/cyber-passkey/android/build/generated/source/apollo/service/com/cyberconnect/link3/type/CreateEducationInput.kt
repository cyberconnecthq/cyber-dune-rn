//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.2'.
//
package com.cyberconnect.link3.type

import com.apollographql.apollo3.api.Optional
import kotlin.Any
import kotlin.Int
import kotlin.String

public data class CreateEducationInput(
  public val profileId: String,
  public val title: String,
  public val orgName: String,
  public val orgTwitterId: String,
  public val orgTwitterHandle: String,
  public val orgAvatar: Any,
  public val startDate: Int,
  public val endDate: Optional<Int?> = Optional.Absent,
  public val description: String,
  public val degree: Optional<String?> = Optional.Absent,
  public val fieldOfStudy: Optional<String?> = Optional.Absent,
)