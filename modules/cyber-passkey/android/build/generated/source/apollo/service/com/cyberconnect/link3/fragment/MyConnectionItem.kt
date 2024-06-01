//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.2'.
//
package com.cyberconnect.link3.fragment

import com.apollographql.apollo3.api.Fragment
import com.cyberconnect.link3.type.ConnectStatus
import kotlin.Boolean
import kotlin.String

public data class MyConnectionItem(
  public val __typename: String,
  public val id: String,
  public val handle: String,
  /**
   * Synthetic field for inline fragment on PerProfile
   */
  public val onPerProfile: OnPerProfile?,
) : Fragment.Data {
  public data class OnPerProfile(
    public val owner: Owner,
    public val isVerified: Boolean,
    public val connectStatus: ConnectStatus,
    /**
     * Personal headline, including Title and Organization.
     */
    public val headline: Headline,
    /**
     * Display name of the personal profile, standard displayname or ENS, standard: 1-20 characters;
     * letters, numbers, and blanks only.
     */
    public val personalDisplayName: PersonalDisplayName,
    /**
     * Profile avatar picture, hash of IPFS address or owned NFT.
     */
    public val personalProfilePicture: PersonalProfilePicture,
  )

  public data class Owner(
    public val id: String,
    public val lightInfo: LightInfo,
  )

  public data class LightInfo(
    public val attestation: Attestation?,
    public val remark: String,
  )

  public data class Attestation(
    public val uid: String,
  )

  public data class Headline(
    public val title: String,
    public val twitterHandle: String,
    public val displayName: String,
  )

  public data class PersonalDisplayName(
    public val displayName: String,
  )

  public data class PersonalProfilePicture(
    public val picture: String?,
  )
}
