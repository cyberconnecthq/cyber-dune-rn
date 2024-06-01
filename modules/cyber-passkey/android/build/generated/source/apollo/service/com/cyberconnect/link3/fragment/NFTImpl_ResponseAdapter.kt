//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.2'.
//
package com.cyberconnect.link3.fragment

import com.apollographql.apollo3.api.Adapter
import com.apollographql.apollo3.api.AnyAdapter
import com.apollographql.apollo3.api.CustomScalarAdapters
import com.apollographql.apollo3.api.StringAdapter
import com.apollographql.apollo3.api.json.JsonReader
import com.apollographql.apollo3.api.json.JsonWriter
import com.cyberconnect.link3.type.ERCType
import com.cyberconnect.link3.type.adapter.ERCType_ResponseAdapter
import kotlin.Any
import kotlin.String
import kotlin.Unit
import kotlin.collections.List

public object NFTImpl_ResponseAdapter {
  public object NFT : Adapter<com.cyberconnect.link3.fragment.NFT> {
    public val RESPONSE_NAMES: List<String> = listOf("name", "contract", "tokenId", "imageUrl",
        "ercType", "owner")

    public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
        com.cyberconnect.link3.fragment.NFT {
      var _name: String? = null
      var _contract: String? = null
      var _tokenId: String? = null
      var _imageUrl: Any? = null
      var _ercType: ERCType? = null
      var _owner: String? = null

      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> _name = StringAdapter.fromJson(reader, customScalarAdapters)
          1 -> _contract = StringAdapter.fromJson(reader, customScalarAdapters)
          2 -> _tokenId = StringAdapter.fromJson(reader, customScalarAdapters)
          3 -> _imageUrl = AnyAdapter.fromJson(reader, customScalarAdapters)
          4 -> _ercType = ERCType_ResponseAdapter.fromJson(reader, customScalarAdapters)
          5 -> _owner = StringAdapter.fromJson(reader, customScalarAdapters)
          else -> break
        }
      }

      return com.cyberconnect.link3.fragment.NFT(
        name = _name!!,
        contract = _contract!!,
        tokenId = _tokenId!!,
        imageUrl = _imageUrl!!,
        ercType = _ercType!!,
        owner = _owner!!
      )
    }

    public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: com.cyberconnect.link3.fragment.NFT,
    ): Unit {
      writer.name("name")
      StringAdapter.toJson(writer, customScalarAdapters, value.name)

      writer.name("contract")
      StringAdapter.toJson(writer, customScalarAdapters, value.contract)

      writer.name("tokenId")
      StringAdapter.toJson(writer, customScalarAdapters, value.tokenId)

      writer.name("imageUrl")
      AnyAdapter.toJson(writer, customScalarAdapters, value.imageUrl)

      writer.name("ercType")
      ERCType_ResponseAdapter.toJson(writer, customScalarAdapters, value.ercType)

      writer.name("owner")
      StringAdapter.toJson(writer, customScalarAdapters, value.owner)
    }
  }
}
