//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.2'.
//
package com.cyberconnect.link3.fragment

import com.apollographql.apollo3.api.Fragment
import kotlin.String

public data class TargetUserInfo(
  public val id: String,
  public val lightInfo: LightInfo,
  public val profile: Profile?,
) : Fragment.Data {
  public data class LightInfo(
    public val handle: String,
    public val avatar: String,
    public val displayName: String,
    public val formattedAddress: String,
    public val attestation: Attestation?,
    public val remark: String,
  )

  public data class Profile(
    public val __typename: String,
    /**
     * Synthetic field for 'TargetUserProfile'
     */
    public val targetUserProfile: TargetUserProfile?,
  )

  public data class Attestation(
    public val uid: String,
  )
}
