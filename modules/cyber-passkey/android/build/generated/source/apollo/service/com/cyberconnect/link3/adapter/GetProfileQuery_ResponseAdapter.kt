//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.2'.
//
package com.cyberconnect.link3.adapter

import com.apollographql.apollo3.api.Adapter
import com.apollographql.apollo3.api.CustomScalarAdapters
import com.apollographql.apollo3.api.StringAdapter
import com.apollographql.apollo3.api.json.JsonReader
import com.apollographql.apollo3.api.json.JsonWriter
import com.apollographql.apollo3.api.nullable
import com.apollographql.apollo3.api.obj
import com.cyberconnect.link3.GetProfileQuery
import com.cyberconnect.link3.type.ProfileResponse_Status
import com.cyberconnect.link3.type.adapter.ProfileResponse_Status_ResponseAdapter
import kotlin.String
import kotlin.Unit
import kotlin.collections.List

public object GetProfileQuery_ResponseAdapter {
  public object Data : Adapter<GetProfileQuery.Data> {
    public val RESPONSE_NAMES: List<String> = listOf("profile")

    public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
        GetProfileQuery.Data {
      var _profile: GetProfileQuery.Profile? = null

      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> _profile = Profile.obj().fromJson(reader, customScalarAdapters)
          else -> break
        }
      }

      return GetProfileQuery.Data(
        profile = _profile!!
      )
    }

    public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: GetProfileQuery.Data,
    ): Unit {
      writer.name("profile")
      Profile.obj().toJson(writer, customScalarAdapters, value.profile)
    }
  }

  public object Profile : Adapter<GetProfileQuery.Profile> {
    public val RESPONSE_NAMES: List<String> = listOf("status", "message", "data")

    public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
        GetProfileQuery.Profile {
      var _status: ProfileResponse_Status? = null
      var _message: String? = null
      var _data: GetProfileQuery.Data1? = null

      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> _status = ProfileResponse_Status_ResponseAdapter.fromJson(reader,
              customScalarAdapters)
          1 -> _message = StringAdapter.fromJson(reader, customScalarAdapters)
          2 -> _data = Data1.obj(true).nullable().fromJson(reader, customScalarAdapters)
          else -> break
        }
      }

      return GetProfileQuery.Profile(
        status = _status!!,
        message = _message!!,
        `data` = _data
      )
    }

    public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: GetProfileQuery.Profile,
    ): Unit {
      writer.name("status")
      ProfileResponse_Status_ResponseAdapter.toJson(writer, customScalarAdapters, value.status)

      writer.name("message")
      StringAdapter.toJson(writer, customScalarAdapters, value.message)

      writer.name("data")
      Data1.obj(true).nullable().toJson(writer, customScalarAdapters, value.`data`)
    }
  }

  public object Data1 : Adapter<GetProfileQuery.Data1> {
    public val RESPONSE_NAMES: List<String> = listOf("__typename")

    public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
        GetProfileQuery.Data1 {
      var __typename: String? = null

      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> __typename = StringAdapter.fromJson(reader, customScalarAdapters)
          else -> break
        }
      }

      reader.rewind()
      val _profile = com.cyberconnect.link3.fragment.ProfileImpl_ResponseAdapter.Profile.fromJson(reader,
          customScalarAdapters)

      return GetProfileQuery.Data1(
        __typename = __typename!!,
        profile = _profile
      )
    }

    public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: GetProfileQuery.Data1,
    ): Unit {
      writer.name("__typename")
      StringAdapter.toJson(writer, customScalarAdapters, value.__typename)

      com.cyberconnect.link3.fragment.ProfileImpl_ResponseAdapter.Profile.toJson(writer,
          customScalarAdapters, value.profile)
    }
  }
}
