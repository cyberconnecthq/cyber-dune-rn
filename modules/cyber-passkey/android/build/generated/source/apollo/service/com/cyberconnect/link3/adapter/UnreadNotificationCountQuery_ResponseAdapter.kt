//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.2'.
//
package com.cyberconnect.link3.adapter

import com.apollographql.apollo3.api.Adapter
import com.apollographql.apollo3.api.CustomScalarAdapters
import com.apollographql.apollo3.api.NullableIntAdapter
import com.apollographql.apollo3.api.json.JsonReader
import com.apollographql.apollo3.api.json.JsonWriter
import com.apollographql.apollo3.api.nullable
import com.apollographql.apollo3.api.obj
import com.cyberconnect.link3.UnreadNotificationCountQuery
import kotlin.Int
import kotlin.String
import kotlin.Unit
import kotlin.collections.List

public object UnreadNotificationCountQuery_ResponseAdapter {
  public object Data : Adapter<UnreadNotificationCountQuery.Data> {
    public val RESPONSE_NAMES: List<String> = listOf("me")

    public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
        UnreadNotificationCountQuery.Data {
      var _me: UnreadNotificationCountQuery.Me? = null

      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> _me = Me.obj().fromJson(reader, customScalarAdapters)
          else -> break
        }
      }

      return UnreadNotificationCountQuery.Data(
        me = _me!!
      )
    }

    public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: UnreadNotificationCountQuery.Data,
    ): Unit {
      writer.name("me")
      Me.obj().toJson(writer, customScalarAdapters, value.me)
    }
  }

  public object Me : Adapter<UnreadNotificationCountQuery.Me> {
    public val RESPONSE_NAMES: List<String> = listOf("data")

    public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
        UnreadNotificationCountQuery.Me {
      var _data: UnreadNotificationCountQuery.Data1? = null

      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> _data = Data1.obj().nullable().fromJson(reader, customScalarAdapters)
          else -> break
        }
      }

      return UnreadNotificationCountQuery.Me(
        `data` = _data
      )
    }

    public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: UnreadNotificationCountQuery.Me,
    ): Unit {
      writer.name("data")
      Data1.obj().nullable().toJson(writer, customScalarAdapters, value.`data`)
    }
  }

  public object Data1 : Adapter<UnreadNotificationCountQuery.Data1> {
    public val RESPONSE_NAMES: List<String> = listOf("unreadNotificationsCount")

    public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
        UnreadNotificationCountQuery.Data1 {
      var _unreadNotificationsCount: Int? = null

      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> _unreadNotificationsCount = NullableIntAdapter.fromJson(reader, customScalarAdapters)
          else -> break
        }
      }

      return UnreadNotificationCountQuery.Data1(
        unreadNotificationsCount = _unreadNotificationsCount
      )
    }

    public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: UnreadNotificationCountQuery.Data1,
    ): Unit {
      writer.name("unreadNotificationsCount")
      NullableIntAdapter.toJson(writer, customScalarAdapters, value.unreadNotificationsCount)
    }
  }
}