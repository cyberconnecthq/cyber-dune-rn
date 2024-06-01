//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.2'.
//
package com.cyberconnect.link3.adapter

import com.apollographql.apollo3.api.Adapter
import com.apollographql.apollo3.api.CustomScalarAdapters
import com.apollographql.apollo3.api.StringAdapter
import com.apollographql.apollo3.api.evaluate
import com.apollographql.apollo3.api.json.JsonReader
import com.apollographql.apollo3.api.json.JsonWriter
import com.apollographql.apollo3.api.list
import com.apollographql.apollo3.api.nullable
import com.apollographql.apollo3.api.obj
import com.apollographql.apollo3.api.possibleTypes
import com.cyberconnect.link3.NotificationRecommendationQuery
import com.cyberconnect.link3.fragment.RecommendationNotification
import kotlin.String
import kotlin.Unit

public object NotificationRecommendationQuery_ResponseAdapter {
  public object Data : Adapter<NotificationRecommendationQuery.Data> {
    public val RESPONSE_NAMES: kotlin.collections.List<String> = listOf("me")

    public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
        NotificationRecommendationQuery.Data {
      var _me: NotificationRecommendationQuery.Me? = null

      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> _me = Me.obj().fromJson(reader, customScalarAdapters)
          else -> break
        }
      }

      return NotificationRecommendationQuery.Data(
        me = _me!!
      )
    }

    public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: NotificationRecommendationQuery.Data,
    ): Unit {
      writer.name("me")
      Me.obj().toJson(writer, customScalarAdapters, value.me)
    }
  }

  public object Me : Adapter<NotificationRecommendationQuery.Me> {
    public val RESPONSE_NAMES: kotlin.collections.List<String> = listOf("data")

    public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
        NotificationRecommendationQuery.Me {
      var _data: NotificationRecommendationQuery.Data1? = null

      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> _data = Data1.obj().nullable().fromJson(reader, customScalarAdapters)
          else -> break
        }
      }

      return NotificationRecommendationQuery.Me(
        `data` = _data
      )
    }

    public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: NotificationRecommendationQuery.Me,
    ): Unit {
      writer.name("data")
      Data1.obj().nullable().toJson(writer, customScalarAdapters, value.`data`)
    }
  }

  public object Data1 : Adapter<NotificationRecommendationQuery.Data1> {
    public val RESPONSE_NAMES: kotlin.collections.List<String> = listOf("notifications")

    public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
        NotificationRecommendationQuery.Data1 {
      var _notifications: NotificationRecommendationQuery.Notifications? = null

      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> _notifications = Notifications.obj().nullable().fromJson(reader,
              customScalarAdapters)
          else -> break
        }
      }

      return NotificationRecommendationQuery.Data1(
        notifications = _notifications
      )
    }

    public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: NotificationRecommendationQuery.Data1,
    ): Unit {
      writer.name("notifications")
      Notifications.obj().nullable().toJson(writer, customScalarAdapters, value.notifications)
    }
  }

  public object Notifications : Adapter<NotificationRecommendationQuery.Notifications> {
    public val RESPONSE_NAMES: kotlin.collections.List<String> = listOf("list", "pageInfo")

    public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
        NotificationRecommendationQuery.Notifications {
      var _list: kotlin.collections.List<NotificationRecommendationQuery.List>? = null
      var _pageInfo: NotificationRecommendationQuery.PageInfo? = null

      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> _list = List.obj(true).list().fromJson(reader, customScalarAdapters)
          1 -> _pageInfo = PageInfo.obj(true).fromJson(reader, customScalarAdapters)
          else -> break
        }
      }

      return NotificationRecommendationQuery.Notifications(
        list = _list!!,
        pageInfo = _pageInfo!!
      )
    }

    public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: NotificationRecommendationQuery.Notifications,
    ): Unit {
      writer.name("list")
      List.obj(true).list().toJson(writer, customScalarAdapters, value.list)

      writer.name("pageInfo")
      PageInfo.obj(true).toJson(writer, customScalarAdapters, value.pageInfo)
    }
  }

  public object List : Adapter<NotificationRecommendationQuery.List> {
    public val RESPONSE_NAMES: kotlin.collections.List<String> = listOf("__typename")

    public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
        NotificationRecommendationQuery.List {
      var __typename: String? = null

      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> __typename = StringAdapter.fromJson(reader, customScalarAdapters)
          else -> break
        }
      }

      check(__typename != null) {
        "__typename was not found"
      }

      var _recommendationNotification: RecommendationNotification? = null
      if (possibleTypes("RecommendationNotification").evaluate(customScalarAdapters.adapterContext.variables(), __typename, customScalarAdapters.adapterContext, null)) {
        reader.rewind()
        _recommendationNotification = com.cyberconnect.link3.fragment.RecommendationNotificationImpl_ResponseAdapter.RecommendationNotification.fromJson(reader,
            customScalarAdapters)
      }

      return NotificationRecommendationQuery.List(
        __typename = __typename,
        recommendationNotification = _recommendationNotification
      )
    }

    public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: NotificationRecommendationQuery.List,
    ): Unit {
      writer.name("__typename")
      StringAdapter.toJson(writer, customScalarAdapters, value.__typename)

      if (value.recommendationNotification != null) {
        com.cyberconnect.link3.fragment.RecommendationNotificationImpl_ResponseAdapter.RecommendationNotification.toJson(writer,
            customScalarAdapters, value.recommendationNotification)
      }
    }
  }

  public object PageInfo : Adapter<NotificationRecommendationQuery.PageInfo> {
    public val RESPONSE_NAMES: kotlin.collections.List<String> = listOf("__typename")

    public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
        NotificationRecommendationQuery.PageInfo {
      var __typename: String? = null

      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> __typename = StringAdapter.fromJson(reader, customScalarAdapters)
          else -> break
        }
      }

      reader.rewind()
      val _pageInfo = com.cyberconnect.link3.fragment.PageInfoImpl_ResponseAdapter.PageInfo.fromJson(reader,
          customScalarAdapters)

      return NotificationRecommendationQuery.PageInfo(
        __typename = __typename!!,
        pageInfo = _pageInfo
      )
    }

    public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: NotificationRecommendationQuery.PageInfo,
    ): Unit {
      writer.name("__typename")
      StringAdapter.toJson(writer, customScalarAdapters, value.__typename)

      com.cyberconnect.link3.fragment.PageInfoImpl_ResponseAdapter.PageInfo.toJson(writer,
          customScalarAdapters, value.pageInfo)
    }
  }
}
