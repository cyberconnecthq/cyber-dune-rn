//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.2'.
//
package com.cyberconnect.link3.selections

import com.apollographql.apollo3.api.CompiledField
import com.apollographql.apollo3.api.CompiledSelection
import com.apollographql.apollo3.api.notNull
import com.cyberconnect.link3.type.GenerateLinkAssetWalletTokenResponse
import com.cyberconnect.link3.type.GenerateLinkAssetWalletTokenResponse_Status
import com.cyberconnect.link3.type.GraphQLString
import kotlin.collections.List

public object GenerateLinkAssetWalletTokenMutationSelections {
  private val __generateLinkAssetWalletToken: List<CompiledSelection> = listOf(
        CompiledField.Builder(
          name = "status",
          type = GenerateLinkAssetWalletTokenResponse_Status.type.notNull()
        ).build(),
        CompiledField.Builder(
          name = "token",
          type = GraphQLString.type.notNull()
        ).build()
      )

  public val __root: List<CompiledSelection> = listOf(
        CompiledField.Builder(
          name = "generateLinkAssetWalletToken",
          type = GenerateLinkAssetWalletTokenResponse.type.notNull()
        ).selections(__generateLinkAssetWalletToken)
        .build()
      )
}