//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.2'.
//
package com.cyberconnect.link3.adapter

import com.apollographql.apollo3.api.Adapter
import com.apollographql.apollo3.api.AnyAdapter
import com.apollographql.apollo3.api.CustomScalarAdapters
import com.apollographql.apollo3.api.StringAdapter
import com.apollographql.apollo3.api.json.JsonReader
import com.apollographql.apollo3.api.json.JsonWriter
import com.cyberconnect.link3.LinkAssetWalletMutation
import kotlin.IllegalStateException
import kotlin.Unit

public object LinkAssetWalletMutation_VariablesAdapter : Adapter<LinkAssetWalletMutation> {
  public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
      LinkAssetWalletMutation = throw IllegalStateException("Input type used in output position")

  public override fun toJson(
    writer: JsonWriter,
    customScalarAdapters: CustomScalarAdapters,
    `value`: LinkAssetWalletMutation,
  ): Unit {
    writer.name("address")
    AnyAdapter.toJson(writer, customScalarAdapters, value.address)
    writer.name("nonce")
    StringAdapter.toJson(writer, customScalarAdapters, value.nonce)
    writer.name("token")
    StringAdapter.toJson(writer, customScalarAdapters, value.token)
    writer.name("signature")
    StringAdapter.toJson(writer, customScalarAdapters, value.signature)
  }
}