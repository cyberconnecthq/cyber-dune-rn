//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.2'.
//
package com.cyberconnect.link3.adapter

import com.apollographql.apollo3.api.Adapter
import com.apollographql.apollo3.api.CustomScalarAdapters
import com.apollographql.apollo3.api.IntAdapter
import com.apollographql.apollo3.api.StringAdapter
import com.apollographql.apollo3.api.json.JsonReader
import com.apollographql.apollo3.api.json.JsonWriter
import com.apollographql.apollo3.api.obj
import com.cyberconnect.link3.GetTwitterInfoByIdQuery
import com.cyberconnect.link3.type.GetTwitterHandleByIdResponse_Status
import com.cyberconnect.link3.type.adapter.GetTwitterHandleByIdResponse_Status_ResponseAdapter
import kotlin.Int
import kotlin.String
import kotlin.Unit
import kotlin.collections.List

public object GetTwitterInfoByIdQuery_ResponseAdapter {
  public object Data : Adapter<GetTwitterInfoByIdQuery.Data> {
    public val RESPONSE_NAMES: List<String> = listOf("getTwitterHandleById")

    public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
        GetTwitterInfoByIdQuery.Data {
      var _getTwitterHandleById: GetTwitterInfoByIdQuery.GetTwitterHandleById? = null

      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> _getTwitterHandleById = GetTwitterHandleById.obj().fromJson(reader,
              customScalarAdapters)
          else -> break
        }
      }

      return GetTwitterInfoByIdQuery.Data(
        getTwitterHandleById = _getTwitterHandleById!!
      )
    }

    public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: GetTwitterInfoByIdQuery.Data,
    ): Unit {
      writer.name("getTwitterHandleById")
      GetTwitterHandleById.obj().toJson(writer, customScalarAdapters, value.getTwitterHandleById)
    }
  }

  public object GetTwitterHandleById : Adapter<GetTwitterInfoByIdQuery.GetTwitterHandleById> {
    public val RESPONSE_NAMES: List<String> = listOf("status", "twitterHandle", "twitterId",
        "avatar", "displayName", "followersCount")

    public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
        GetTwitterInfoByIdQuery.GetTwitterHandleById {
      var _status: GetTwitterHandleByIdResponse_Status? = null
      var _twitterHandle: String? = null
      var _twitterId: String? = null
      var _avatar: String? = null
      var _displayName: String? = null
      var _followersCount: Int? = null

      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> _status = GetTwitterHandleByIdResponse_Status_ResponseAdapter.fromJson(reader,
              customScalarAdapters)
          1 -> _twitterHandle = StringAdapter.fromJson(reader, customScalarAdapters)
          2 -> _twitterId = StringAdapter.fromJson(reader, customScalarAdapters)
          3 -> _avatar = StringAdapter.fromJson(reader, customScalarAdapters)
          4 -> _displayName = StringAdapter.fromJson(reader, customScalarAdapters)
          5 -> _followersCount = IntAdapter.fromJson(reader, customScalarAdapters)
          else -> break
        }
      }

      return GetTwitterInfoByIdQuery.GetTwitterHandleById(
        status = _status!!,
        twitterHandle = _twitterHandle!!,
        twitterId = _twitterId!!,
        avatar = _avatar!!,
        displayName = _displayName!!,
        followersCount = _followersCount!!
      )
    }

    public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: GetTwitterInfoByIdQuery.GetTwitterHandleById,
    ): Unit {
      writer.name("status")
      GetTwitterHandleByIdResponse_Status_ResponseAdapter.toJson(writer, customScalarAdapters,
          value.status)

      writer.name("twitterHandle")
      StringAdapter.toJson(writer, customScalarAdapters, value.twitterHandle)

      writer.name("twitterId")
      StringAdapter.toJson(writer, customScalarAdapters, value.twitterId)

      writer.name("avatar")
      StringAdapter.toJson(writer, customScalarAdapters, value.avatar)

      writer.name("displayName")
      StringAdapter.toJson(writer, customScalarAdapters, value.displayName)

      writer.name("followersCount")
      IntAdapter.toJson(writer, customScalarAdapters, value.followersCount)
    }
  }
}
