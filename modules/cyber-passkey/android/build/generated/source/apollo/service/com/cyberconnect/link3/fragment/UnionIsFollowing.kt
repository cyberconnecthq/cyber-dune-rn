//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.2'.
//
package com.cyberconnect.link3.fragment

import com.apollographql.apollo3.api.Fragment
import kotlin.Boolean
import kotlin.String

public data class UnionIsFollowing(
  public val __typename: String,
  /**
   * Synthetic field for inline fragment on OrgProfile
   */
  public val onOrgProfile: OnOrgProfile?,
  /**
   * Synthetic field for inline fragment on PerProfile
   */
  public val onPerProfile: OnPerProfile?,
) : Fragment.Data {
  public data class OnOrgProfile(
    public val isFollowing: Boolean,
  )

  public data class OnPerProfile(
    public val isFollowing: Boolean,
  )
}
