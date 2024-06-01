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

public data class TwitterInput(
  public val twitterId: String,
  public val twitterHandle: String,
  public val displayName: String,
  public val avatar: Any,
  public val title: String,
  public val description: String,
  public val followersCount: Optional<Int?> = Optional.Absent,
  public val headlineType: Optional<HeadlineType?> = Optional.Absent,
)