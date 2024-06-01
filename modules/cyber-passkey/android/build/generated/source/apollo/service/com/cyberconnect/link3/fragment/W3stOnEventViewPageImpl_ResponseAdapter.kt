//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.2'.
//
package com.cyberconnect.link3.fragment

import com.apollographql.apollo3.api.Adapter
import com.apollographql.apollo3.api.AnyAdapter
import com.apollographql.apollo3.api.BooleanAdapter
import com.apollographql.apollo3.api.CustomScalarAdapters
import com.apollographql.apollo3.api.IntAdapter
import com.apollographql.apollo3.api.NullableIntAdapter
import com.apollographql.apollo3.api.json.JsonReader
import com.apollographql.apollo3.api.json.JsonWriter
import com.apollographql.apollo3.api.list
import com.apollographql.apollo3.api.nullable
import com.apollographql.apollo3.api.obj
import com.cyberconnect.link3.type.W3STDeployStatus
import com.cyberconnect.link3.type.W3STRequirementType
import com.cyberconnect.link3.type.adapter.W3STDeployStatus_ResponseAdapter
import com.cyberconnect.link3.type.adapter.W3STRequirementType_ResponseAdapter
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.Unit
import kotlin.collections.List

public object W3stOnEventViewPageImpl_ResponseAdapter {
  public object W3stOnEventViewPage : Adapter<com.cyberconnect.link3.fragment.W3stOnEventViewPage> {
    public val RESPONSE_NAMES: List<String> = listOf("version", "gasless", "imageUrl",
        "contractInfo", "v3contractInfo", "requirements")

    public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
        com.cyberconnect.link3.fragment.W3stOnEventViewPage {
      var _version: Int? = null
      var _gasless: Boolean? = null
      var _imageUrl: Any? = null
      var _contractInfo: List<com.cyberconnect.link3.fragment.W3stOnEventViewPage.ContractInfo>? = null
      var _v3contractInfo: List<com.cyberconnect.link3.fragment.W3stOnEventViewPage.V3contractInfo>? = null
      var _requirements: List<com.cyberconnect.link3.fragment.W3stOnEventViewPage.Requirement>? = null

      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> _version = IntAdapter.fromJson(reader, customScalarAdapters)
          1 -> _gasless = BooleanAdapter.fromJson(reader, customScalarAdapters)
          2 -> _imageUrl = AnyAdapter.fromJson(reader, customScalarAdapters)
          3 -> _contractInfo = ContractInfo.obj().list().nullable().fromJson(reader,
              customScalarAdapters)
          4 -> _v3contractInfo = V3contractInfo.obj().list().nullable().fromJson(reader,
              customScalarAdapters)
          5 -> _requirements = Requirement.obj().list().fromJson(reader, customScalarAdapters)
          else -> break
        }
      }

      return com.cyberconnect.link3.fragment.W3stOnEventViewPage(
        version = _version!!,
        gasless = _gasless!!,
        imageUrl = _imageUrl!!,
        contractInfo = _contractInfo,
        v3contractInfo = _v3contractInfo,
        requirements = _requirements!!
      )
    }

    public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: com.cyberconnect.link3.fragment.W3stOnEventViewPage,
    ): Unit {
      writer.name("version")
      IntAdapter.toJson(writer, customScalarAdapters, value.version)

      writer.name("gasless")
      BooleanAdapter.toJson(writer, customScalarAdapters, value.gasless)

      writer.name("imageUrl")
      AnyAdapter.toJson(writer, customScalarAdapters, value.imageUrl)

      writer.name("contractInfo")
      ContractInfo.obj().list().nullable().toJson(writer, customScalarAdapters, value.contractInfo)

      writer.name("v3contractInfo")
      V3contractInfo.obj().list().nullable().toJson(writer, customScalarAdapters,
          value.v3contractInfo)

      writer.name("requirements")
      Requirement.obj().list().toJson(writer, customScalarAdapters, value.requirements)
    }
  }

  public object ContractInfo :
      Adapter<com.cyberconnect.link3.fragment.W3stOnEventViewPage.ContractInfo> {
    public val RESPONSE_NAMES: List<String> = listOf("deployStatus", "chainId", "essenceAddress",
        "tokenHoldersCount")

    public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
        com.cyberconnect.link3.fragment.W3stOnEventViewPage.ContractInfo {
      var _deployStatus: W3STDeployStatus? = null
      var _chainId: Int? = null
      var _essenceAddress: Any? = null
      var _tokenHoldersCount: Int? = null

      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> _deployStatus = W3STDeployStatus_ResponseAdapter.fromJson(reader,
              customScalarAdapters)
          1 -> _chainId = IntAdapter.fromJson(reader, customScalarAdapters)
          2 -> _essenceAddress = AnyAdapter.fromJson(reader, customScalarAdapters)
          3 -> _tokenHoldersCount = IntAdapter.fromJson(reader, customScalarAdapters)
          else -> break
        }
      }

      return com.cyberconnect.link3.fragment.W3stOnEventViewPage.ContractInfo(
        deployStatus = _deployStatus!!,
        chainId = _chainId!!,
        essenceAddress = _essenceAddress!!,
        tokenHoldersCount = _tokenHoldersCount!!
      )
    }

    public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: com.cyberconnect.link3.fragment.W3stOnEventViewPage.ContractInfo,
    ): Unit {
      writer.name("deployStatus")
      W3STDeployStatus_ResponseAdapter.toJson(writer, customScalarAdapters, value.deployStatus)

      writer.name("chainId")
      IntAdapter.toJson(writer, customScalarAdapters, value.chainId)

      writer.name("essenceAddress")
      AnyAdapter.toJson(writer, customScalarAdapters, value.essenceAddress)

      writer.name("tokenHoldersCount")
      IntAdapter.toJson(writer, customScalarAdapters, value.tokenHoldersCount)
    }
  }

  public object V3contractInfo :
      Adapter<com.cyberconnect.link3.fragment.W3stOnEventViewPage.V3contractInfo> {
    public val RESPONSE_NAMES: List<String> = listOf("deployStatus", "chainId", "w3stAddress",
        "tokenHoldersCount", "cyberAccount", "tokenId")

    public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
        com.cyberconnect.link3.fragment.W3stOnEventViewPage.V3contractInfo {
      var _deployStatus: W3STDeployStatus? = null
      var _chainId: Int? = null
      var _w3stAddress: Any? = null
      var _tokenHoldersCount: Int? = null
      var _cyberAccount: Any? = null
      var _tokenId: Int? = null

      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> _deployStatus = W3STDeployStatus_ResponseAdapter.fromJson(reader,
              customScalarAdapters)
          1 -> _chainId = IntAdapter.fromJson(reader, customScalarAdapters)
          2 -> _w3stAddress = AnyAdapter.fromJson(reader, customScalarAdapters)
          3 -> _tokenHoldersCount = IntAdapter.fromJson(reader, customScalarAdapters)
          4 -> _cyberAccount = AnyAdapter.fromJson(reader, customScalarAdapters)
          5 -> _tokenId = IntAdapter.fromJson(reader, customScalarAdapters)
          else -> break
        }
      }

      return com.cyberconnect.link3.fragment.W3stOnEventViewPage.V3contractInfo(
        deployStatus = _deployStatus!!,
        chainId = _chainId!!,
        w3stAddress = _w3stAddress!!,
        tokenHoldersCount = _tokenHoldersCount!!,
        cyberAccount = _cyberAccount!!,
        tokenId = _tokenId!!
      )
    }

    public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: com.cyberconnect.link3.fragment.W3stOnEventViewPage.V3contractInfo,
    ): Unit {
      writer.name("deployStatus")
      W3STDeployStatus_ResponseAdapter.toJson(writer, customScalarAdapters, value.deployStatus)

      writer.name("chainId")
      IntAdapter.toJson(writer, customScalarAdapters, value.chainId)

      writer.name("w3stAddress")
      AnyAdapter.toJson(writer, customScalarAdapters, value.w3stAddress)

      writer.name("tokenHoldersCount")
      IntAdapter.toJson(writer, customScalarAdapters, value.tokenHoldersCount)

      writer.name("cyberAccount")
      AnyAdapter.toJson(writer, customScalarAdapters, value.cyberAccount)

      writer.name("tokenId")
      IntAdapter.toJson(writer, customScalarAdapters, value.tokenId)
    }
  }

  public object Requirement :
      Adapter<com.cyberconnect.link3.fragment.W3stOnEventViewPage.Requirement> {
    public val RESPONSE_NAMES: List<String> = listOf("type", "value")

    public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
        com.cyberconnect.link3.fragment.W3stOnEventViewPage.Requirement {
      var _type: W3STRequirementType? = null
      var _value: Int? = null

      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> _type = W3STRequirementType_ResponseAdapter.fromJson(reader, customScalarAdapters)
          1 -> _value = NullableIntAdapter.fromJson(reader, customScalarAdapters)
          else -> break
        }
      }

      return com.cyberconnect.link3.fragment.W3stOnEventViewPage.Requirement(
        type = _type!!,
        `value` = _value
      )
    }

    public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: com.cyberconnect.link3.fragment.W3stOnEventViewPage.Requirement,
    ): Unit {
      writer.name("type")
      W3STRequirementType_ResponseAdapter.toJson(writer, customScalarAdapters, value.type)

      writer.name("value")
      NullableIntAdapter.toJson(writer, customScalarAdapters, value.`value`)
    }
  }
}