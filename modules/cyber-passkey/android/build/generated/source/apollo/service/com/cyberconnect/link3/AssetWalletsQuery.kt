//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.2'.
//
package com.cyberconnect.link3

import com.apollographql.apollo3.annotations.ApolloAdaptableWith
import com.apollographql.apollo3.api.Adapter
import com.apollographql.apollo3.api.CompiledField
import com.apollographql.apollo3.api.CustomScalarAdapters
import com.apollographql.apollo3.api.Query
import com.apollographql.apollo3.api.json.JsonWriter
import com.apollographql.apollo3.api.obj
import com.cyberconnect.link3.adapter.AssetWalletsQuery_ResponseAdapter
import com.cyberconnect.link3.selections.AssetWalletsQuerySelections
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.Unit
import kotlin.collections.List

public class AssetWalletsQuery() : Query<AssetWalletsQuery.Data> {
  public override fun equals(other: Any?): Boolean = other != null && other::class == this::class

  public override fun hashCode(): Int = this::class.hashCode()

  public override fun id(): String = OPERATION_ID

  public override fun document(): String = OPERATION_DOCUMENT

  public override fun name(): String = OPERATION_NAME

  public override fun serializeVariables(writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters): Unit {
    // This operation doesn't have any variable
  }

  public override fun adapter(): Adapter<Data> = AssetWalletsQuery_ResponseAdapter.Data.obj()

  public override fun rootField(): CompiledField = CompiledField.Builder(
    name = "data",
    type = com.cyberconnect.link3.type.Query.type
  )
  .selections(selections = AssetWalletsQuerySelections.__root)
  .build()

  @ApolloAdaptableWith(AssetWalletsQuery_ResponseAdapter.Data::class)
  public data class Data(
    public val me: Me,
  ) : Query.Data

  public data class Me(
    public val `data`: Data1?,
  )

  public data class Data1(
    public val privateInfo: PrivateInfo?,
  )

  public data class PrivateInfo(
    public val assetWallets: List<Any>?,
  )

  public companion object {
    public const val OPERATION_ID: String =
        "8291ed2d776c21c6127a163269dc784b420a9e0e9d7d600378faa5bf5c5d73d2"

    /**
     * The minimized GraphQL document being sent to the server to save a few bytes.
     * The un-minimized version is:
     *
     * query assetWallets {
     *   me {
     *     data {
     *       privateInfo {
     *         assetWallets
     *       }
     *     }
     *   }
     * }
     */
    public val OPERATION_DOCUMENT: String
      get() = "query assetWallets { me { data { privateInfo { assetWallets } } } }"

    public const val OPERATION_NAME: String = "assetWallets"
  }
}