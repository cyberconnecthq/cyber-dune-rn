//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.2'.
//
package com.cyberconnect.link3.adapter

import com.apollographql.apollo3.api.Adapter
import com.apollographql.apollo3.api.CustomScalarAdapters
import com.apollographql.apollo3.api.json.JsonReader
import com.apollographql.apollo3.api.json.JsonWriter
import com.apollographql.apollo3.api.obj
import com.cyberconnect.link3.UnlinkAssetWalletMutation
import com.cyberconnect.link3.type.UnlinkAssetWalletResponse_Status
import com.cyberconnect.link3.type.adapter.UnlinkAssetWalletResponse_Status_ResponseAdapter
import kotlin.String
import kotlin.Unit
import kotlin.collections.List

public object UnlinkAssetWalletMutation_ResponseAdapter {
  public object Data : Adapter<UnlinkAssetWalletMutation.Data> {
    public val RESPONSE_NAMES: List<String> = listOf("unlinkAssetWallet")

    public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
        UnlinkAssetWalletMutation.Data {
      var _unlinkAssetWallet: UnlinkAssetWalletMutation.UnlinkAssetWallet? = null

      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> _unlinkAssetWallet = UnlinkAssetWallet.obj().fromJson(reader, customScalarAdapters)
          else -> break
        }
      }

      return UnlinkAssetWalletMutation.Data(
        unlinkAssetWallet = _unlinkAssetWallet!!
      )
    }

    public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: UnlinkAssetWalletMutation.Data,
    ): Unit {
      writer.name("unlinkAssetWallet")
      UnlinkAssetWallet.obj().toJson(writer, customScalarAdapters, value.unlinkAssetWallet)
    }
  }

  public object UnlinkAssetWallet : Adapter<UnlinkAssetWalletMutation.UnlinkAssetWallet> {
    public val RESPONSE_NAMES: List<String> = listOf("status")

    public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
        UnlinkAssetWalletMutation.UnlinkAssetWallet {
      var _status: UnlinkAssetWalletResponse_Status? = null

      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> _status = UnlinkAssetWalletResponse_Status_ResponseAdapter.fromJson(reader,
              customScalarAdapters)
          else -> break
        }
      }

      return UnlinkAssetWalletMutation.UnlinkAssetWallet(
        status = _status!!
      )
    }

    public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: UnlinkAssetWalletMutation.UnlinkAssetWallet,
    ): Unit {
      writer.name("status")
      UnlinkAssetWalletResponse_Status_ResponseAdapter.toJson(writer, customScalarAdapters,
          value.status)
    }
  }
}
