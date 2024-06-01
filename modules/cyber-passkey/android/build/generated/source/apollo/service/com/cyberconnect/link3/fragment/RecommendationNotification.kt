//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.2'.
//
package com.cyberconnect.link3.fragment

import com.apollographql.apollo3.api.Fragment
import com.cyberconnect.link3.type.NotificationType
import kotlin.Any
import kotlin.Boolean
import kotlin.String

public data class RecommendationNotification(
  public val __typename: String,
  public val hasRead: Boolean,
  public val id: String,
  public val timestamp: Any,
  public val type: NotificationType,
  public val content: Content,
  public val from: From,
) : Fragment.Data {
  public data class Content(
    public val content: String,
    public val hidden: Boolean,
  )

  public data class From(
    public val lightInfo: LightInfo,
  )

  public data class LightInfo(
    public val avatar: String,
    public val displayName: String,
    public val handle: String,
    public val profileId: String,
  )
}
