//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.2'.
//
package com.cyberconnect.link3.type

import com.apollographql.apollo3.api.Optional
import kotlin.Boolean
import kotlin.Int
import kotlin.String

public data class SearchProfilesInput(
  public val query: String,
  public val limit: Int,
  public val after: Optional<String?> = Optional.Absent,
  public val includeMember: Optional<Boolean?> = Optional.Absent,
)