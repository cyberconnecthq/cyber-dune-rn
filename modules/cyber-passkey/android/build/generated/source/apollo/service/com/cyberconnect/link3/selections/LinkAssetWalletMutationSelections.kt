//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.2'.
//
package com.cyberconnect.link3.selections

import com.apollographql.apollo3.api.CompiledArgument
import com.apollographql.apollo3.api.CompiledField
import com.apollographql.apollo3.api.CompiledSelection
import com.apollographql.apollo3.api.CompiledVariable
import com.apollographql.apollo3.api.notNull
import com.cyberconnect.link3.type.LinkAssetWalletResponse
import com.cyberconnect.link3.type.LinkAssetWalletResponse_Status
import kotlin.collections.List

public object LinkAssetWalletMutationSelections {
  private val __linkAssetWallet: List<CompiledSelection> = listOf(
        CompiledField.Builder(
          name = "status",
          type = LinkAssetWalletResponse_Status.type.notNull()
        ).build()
      )

  public val __root: List<CompiledSelection> = listOf(
        CompiledField.Builder(
          name = "linkAssetWallet",
          type = LinkAssetWalletResponse.type.notNull()
        ).arguments(listOf(
          CompiledArgument.Builder("input", mapOf(
            "address" to CompiledVariable("address"),
            "nonce" to CompiledVariable("nonce"),
            "token" to CompiledVariable("token"),
            "signature" to CompiledVariable("signature")
          )).build()
        ))
        .selections(__linkAssetWallet)
        .build()
      )
}
