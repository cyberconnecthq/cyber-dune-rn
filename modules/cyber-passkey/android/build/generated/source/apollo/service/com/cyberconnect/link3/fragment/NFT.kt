//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.2'.
//
package com.cyberconnect.link3.fragment

import com.apollographql.apollo3.api.Fragment
import com.cyberconnect.link3.type.ERCType
import kotlin.Any
import kotlin.String

public data class NFT(
  public val name: String,
  public val contract: String,
  public val tokenId: String,
  public val imageUrl: Any,
  public val ercType: ERCType,
  public val owner: String,
) : Fragment.Data
