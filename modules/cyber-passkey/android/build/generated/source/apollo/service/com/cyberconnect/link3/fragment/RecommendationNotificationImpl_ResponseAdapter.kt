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
import com.apollographql.apollo3.api.StringAdapter
import com.apollographql.apollo3.api.json.JsonReader
import com.apollographql.apollo3.api.json.JsonWriter
import com.apollographql.apollo3.api.obj
import com.cyberconnect.link3.type.NotificationType
import com.cyberconnect.link3.type.adapter.NotificationType_ResponseAdapter
import kotlin.Any
import kotlin.Boolean
import kotlin.String
import kotlin.Unit
import kotlin.collections.List

public object RecommendationNotificationImpl_ResponseAdapter {
  public object RecommendationNotification :
      Adapter<com.cyberconnect.link3.fragment.RecommendationNotification> {
    public val RESPONSE_NAMES: List<String> = listOf("__typename", "hasRead", "id", "timestamp",
        "type", "content", "from")

    public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
        com.cyberconnect.link3.fragment.RecommendationNotification {
      var __typename: String? = null
      var _hasRead: Boolean? = null
      var _id: String? = null
      var _timestamp: Any? = null
      var _type: NotificationType? = null
      var _content: com.cyberconnect.link3.fragment.RecommendationNotification.Content? = null
      var _from: com.cyberconnect.link3.fragment.RecommendationNotification.From? = null

      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> __typename = StringAdapter.fromJson(reader, customScalarAdapters)
          1 -> _hasRead = BooleanAdapter.fromJson(reader, customScalarAdapters)
          2 -> _id = StringAdapter.fromJson(reader, customScalarAdapters)
          3 -> _timestamp = AnyAdapter.fromJson(reader, customScalarAdapters)
          4 -> _type = NotificationType_ResponseAdapter.fromJson(reader, customScalarAdapters)
          5 -> _content = Content.obj().fromJson(reader, customScalarAdapters)
          6 -> _from = From.obj().fromJson(reader, customScalarAdapters)
          else -> break
        }
      }

      return com.cyberconnect.link3.fragment.RecommendationNotification(
        __typename = __typename!!,
        hasRead = _hasRead!!,
        id = _id!!,
        timestamp = _timestamp!!,
        type = _type!!,
        content = _content!!,
        from = _from!!
      )
    }

    public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: com.cyberconnect.link3.fragment.RecommendationNotification,
    ): Unit {
      writer.name("__typename")
      StringAdapter.toJson(writer, customScalarAdapters, value.__typename)

      writer.name("hasRead")
      BooleanAdapter.toJson(writer, customScalarAdapters, value.hasRead)

      writer.name("id")
      StringAdapter.toJson(writer, customScalarAdapters, value.id)

      writer.name("timestamp")
      AnyAdapter.toJson(writer, customScalarAdapters, value.timestamp)

      writer.name("type")
      NotificationType_ResponseAdapter.toJson(writer, customScalarAdapters, value.type)

      writer.name("content")
      Content.obj().toJson(writer, customScalarAdapters, value.content)

      writer.name("from")
      From.obj().toJson(writer, customScalarAdapters, value.from)
    }
  }

  public object Content :
      Adapter<com.cyberconnect.link3.fragment.RecommendationNotification.Content> {
    public val RESPONSE_NAMES: List<String> = listOf("content", "hidden")

    public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
        com.cyberconnect.link3.fragment.RecommendationNotification.Content {
      var _content: String? = null
      var _hidden: Boolean? = null

      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> _content = StringAdapter.fromJson(reader, customScalarAdapters)
          1 -> _hidden = BooleanAdapter.fromJson(reader, customScalarAdapters)
          else -> break
        }
      }

      return com.cyberconnect.link3.fragment.RecommendationNotification.Content(
        content = _content!!,
        hidden = _hidden!!
      )
    }

    public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: com.cyberconnect.link3.fragment.RecommendationNotification.Content,
    ): Unit {
      writer.name("content")
      StringAdapter.toJson(writer, customScalarAdapters, value.content)

      writer.name("hidden")
      BooleanAdapter.toJson(writer, customScalarAdapters, value.hidden)
    }
  }

  public object From : Adapter<com.cyberconnect.link3.fragment.RecommendationNotification.From> {
    public val RESPONSE_NAMES: List<String> = listOf("lightInfo")

    public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
        com.cyberconnect.link3.fragment.RecommendationNotification.From {
      var _lightInfo: com.cyberconnect.link3.fragment.RecommendationNotification.LightInfo? = null

      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> _lightInfo = LightInfo.obj().fromJson(reader, customScalarAdapters)
          else -> break
        }
      }

      return com.cyberconnect.link3.fragment.RecommendationNotification.From(
        lightInfo = _lightInfo!!
      )
    }

    public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: com.cyberconnect.link3.fragment.RecommendationNotification.From,
    ): Unit {
      writer.name("lightInfo")
      LightInfo.obj().toJson(writer, customScalarAdapters, value.lightInfo)
    }
  }

  public object LightInfo :
      Adapter<com.cyberconnect.link3.fragment.RecommendationNotification.LightInfo> {
    public val RESPONSE_NAMES: List<String> = listOf("avatar", "displayName", "handle", "profileId")

    public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
        com.cyberconnect.link3.fragment.RecommendationNotification.LightInfo {
      var _avatar: String? = null
      var _displayName: String? = null
      var _handle: String? = null
      var _profileId: String? = null

      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> _avatar = StringAdapter.fromJson(reader, customScalarAdapters)
          1 -> _displayName = StringAdapter.fromJson(reader, customScalarAdapters)
          2 -> _handle = StringAdapter.fromJson(reader, customScalarAdapters)
          3 -> _profileId = StringAdapter.fromJson(reader, customScalarAdapters)
          else -> break
        }
      }

      return com.cyberconnect.link3.fragment.RecommendationNotification.LightInfo(
        avatar = _avatar!!,
        displayName = _displayName!!,
        handle = _handle!!,
        profileId = _profileId!!
      )
    }

    public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: com.cyberconnect.link3.fragment.RecommendationNotification.LightInfo,
    ): Unit {
      writer.name("avatar")
      StringAdapter.toJson(writer, customScalarAdapters, value.avatar)

      writer.name("displayName")
      StringAdapter.toJson(writer, customScalarAdapters, value.displayName)

      writer.name("handle")
      StringAdapter.toJson(writer, customScalarAdapters, value.handle)

      writer.name("profileId")
      StringAdapter.toJson(writer, customScalarAdapters, value.profileId)
    }
  }
}
