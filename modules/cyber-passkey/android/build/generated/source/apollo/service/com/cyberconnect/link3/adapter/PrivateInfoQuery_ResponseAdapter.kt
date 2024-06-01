//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.2'.
//
package com.cyberconnect.link3.adapter

import com.apollographql.apollo3.api.Adapter
import com.apollographql.apollo3.api.BooleanAdapter
import com.apollographql.apollo3.api.CustomScalarAdapters
import com.apollographql.apollo3.api.StringAdapter
import com.apollographql.apollo3.api.json.JsonReader
import com.apollographql.apollo3.api.json.JsonWriter
import com.apollographql.apollo3.api.nullable
import com.apollographql.apollo3.api.obj
import com.cyberconnect.link3.PrivateInfoQuery
import com.cyberconnect.link3.type.MeResponse_Status
import com.cyberconnect.link3.type.adapter.MeResponse_Status_ResponseAdapter
import kotlin.Boolean
import kotlin.String
import kotlin.Unit
import kotlin.collections.List

public object PrivateInfoQuery_ResponseAdapter {
  public object Data : Adapter<PrivateInfoQuery.Data> {
    public val RESPONSE_NAMES: List<String> = listOf("me")

    public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
        PrivateInfoQuery.Data {
      var _me: PrivateInfoQuery.Me? = null

      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> _me = Me.obj().fromJson(reader, customScalarAdapters)
          else -> break
        }
      }

      return PrivateInfoQuery.Data(
        me = _me!!
      )
    }

    public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: PrivateInfoQuery.Data,
    ): Unit {
      writer.name("me")
      Me.obj().toJson(writer, customScalarAdapters, value.me)
    }
  }

  public object Me : Adapter<PrivateInfoQuery.Me> {
    public val RESPONSE_NAMES: List<String> = listOf("status", "message", "data")

    public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
        PrivateInfoQuery.Me {
      var _status: MeResponse_Status? = null
      var _message: String? = null
      var _data: PrivateInfoQuery.Data1? = null

      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> _status = MeResponse_Status_ResponseAdapter.fromJson(reader, customScalarAdapters)
          1 -> _message = StringAdapter.fromJson(reader, customScalarAdapters)
          2 -> _data = Data1.obj().nullable().fromJson(reader, customScalarAdapters)
          else -> break
        }
      }

      return PrivateInfoQuery.Me(
        status = _status!!,
        message = _message!!,
        `data` = _data
      )
    }

    public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: PrivateInfoQuery.Me,
    ): Unit {
      writer.name("status")
      MeResponse_Status_ResponseAdapter.toJson(writer, customScalarAdapters, value.status)

      writer.name("message")
      StringAdapter.toJson(writer, customScalarAdapters, value.message)

      writer.name("data")
      Data1.obj().nullable().toJson(writer, customScalarAdapters, value.`data`)
    }
  }

  public object Data1 : Adapter<PrivateInfoQuery.Data1> {
    public val RESPONSE_NAMES: List<String> = listOf("privateInfo")

    public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
        PrivateInfoQuery.Data1 {
      var _privateInfo: PrivateInfoQuery.PrivateInfo? = null

      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> _privateInfo = PrivateInfo.obj().nullable().fromJson(reader, customScalarAdapters)
          else -> break
        }
      }

      return PrivateInfoQuery.Data1(
        privateInfo = _privateInfo
      )
    }

    public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: PrivateInfoQuery.Data1,
    ): Unit {
      writer.name("privateInfo")
      PrivateInfo.obj().nullable().toJson(writer, customScalarAdapters, value.privateInfo)
    }
  }

  public object PrivateInfo : Adapter<PrivateInfoQuery.PrivateInfo> {
    public val RESPONSE_NAMES: List<String> = listOf("accessToken", "twitterId", "discordId",
        "email", "twitterAuthorized")

    public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
        PrivateInfoQuery.PrivateInfo {
      var _accessToken: String? = null
      var _twitterId: String? = null
      var _discordId: String? = null
      var _email: String? = null
      var _twitterAuthorized: Boolean? = null

      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> _accessToken = StringAdapter.fromJson(reader, customScalarAdapters)
          1 -> _twitterId = StringAdapter.fromJson(reader, customScalarAdapters)
          2 -> _discordId = StringAdapter.fromJson(reader, customScalarAdapters)
          3 -> _email = StringAdapter.fromJson(reader, customScalarAdapters)
          4 -> _twitterAuthorized = BooleanAdapter.fromJson(reader, customScalarAdapters)
          else -> break
        }
      }

      return PrivateInfoQuery.PrivateInfo(
        accessToken = _accessToken!!,
        twitterId = _twitterId!!,
        discordId = _discordId!!,
        email = _email!!,
        twitterAuthorized = _twitterAuthorized!!
      )
    }

    public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: PrivateInfoQuery.PrivateInfo,
    ): Unit {
      writer.name("accessToken")
      StringAdapter.toJson(writer, customScalarAdapters, value.accessToken)

      writer.name("twitterId")
      StringAdapter.toJson(writer, customScalarAdapters, value.twitterId)

      writer.name("discordId")
      StringAdapter.toJson(writer, customScalarAdapters, value.discordId)

      writer.name("email")
      StringAdapter.toJson(writer, customScalarAdapters, value.email)

      writer.name("twitterAuthorized")
      BooleanAdapter.toJson(writer, customScalarAdapters, value.twitterAuthorized)
    }
  }
}