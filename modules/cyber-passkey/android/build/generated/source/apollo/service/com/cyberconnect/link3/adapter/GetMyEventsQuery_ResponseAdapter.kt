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
import com.apollographql.apollo3.api.list
import com.apollographql.apollo3.api.nullable
import com.apollographql.apollo3.api.obj
import com.cyberconnect.link3.GetMyEventsQuery
import kotlin.String
import kotlin.Unit

public object GetMyEventsQuery_ResponseAdapter {
  public object Data : Adapter<GetMyEventsQuery.Data> {
    public val RESPONSE_NAMES: kotlin.collections.List<String> = listOf("me")

    public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
        GetMyEventsQuery.Data {
      var _me: GetMyEventsQuery.Me? = null

      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> _me = Me.obj().fromJson(reader, customScalarAdapters)
          else -> break
        }
      }

      return GetMyEventsQuery.Data(
        me = _me!!
      )
    }

    public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: GetMyEventsQuery.Data,
    ): Unit {
      writer.name("me")
      Me.obj().toJson(writer, customScalarAdapters, value.me)
    }
  }

  public object Me : Adapter<GetMyEventsQuery.Me> {
    public val RESPONSE_NAMES: kotlin.collections.List<String> = listOf("data")

    public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
        GetMyEventsQuery.Me {
      var _data: GetMyEventsQuery.Data1? = null

      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> _data = Data1.obj().nullable().fromJson(reader, customScalarAdapters)
          else -> break
        }
      }

      return GetMyEventsQuery.Me(
        `data` = _data
      )
    }

    public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: GetMyEventsQuery.Me,
    ): Unit {
      writer.name("data")
      Data1.obj().nullable().toJson(writer, customScalarAdapters, value.`data`)
    }
  }

  public object Data1 : Adapter<GetMyEventsQuery.Data1> {
    public val RESPONSE_NAMES: kotlin.collections.List<String> = listOf("registeredEvents")

    public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
        GetMyEventsQuery.Data1 {
      var _registeredEvents: GetMyEventsQuery.RegisteredEvents? = null

      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> _registeredEvents = RegisteredEvents.obj().nullable().fromJson(reader,
              customScalarAdapters)
          else -> break
        }
      }

      return GetMyEventsQuery.Data1(
        registeredEvents = _registeredEvents
      )
    }

    public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: GetMyEventsQuery.Data1,
    ): Unit {
      writer.name("registeredEvents")
      RegisteredEvents.obj().nullable().toJson(writer, customScalarAdapters, value.registeredEvents)
    }
  }

  public object RegisteredEvents : Adapter<GetMyEventsQuery.RegisteredEvents> {
    public val RESPONSE_NAMES: kotlin.collections.List<String> = listOf("list", "pageInfo")

    public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
        GetMyEventsQuery.RegisteredEvents {
      var _list: kotlin.collections.List<GetMyEventsQuery.List>? = null
      var _pageInfo: GetMyEventsQuery.PageInfo? = null

      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> _list = List.obj(true).list().fromJson(reader, customScalarAdapters)
          1 -> _pageInfo = PageInfo.obj(true).fromJson(reader, customScalarAdapters)
          else -> break
        }
      }

      return GetMyEventsQuery.RegisteredEvents(
        list = _list!!,
        pageInfo = _pageInfo!!
      )
    }

    public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: GetMyEventsQuery.RegisteredEvents,
    ): Unit {
      writer.name("list")
      List.obj(true).list().toJson(writer, customScalarAdapters, value.list)

      writer.name("pageInfo")
      PageInfo.obj(true).toJson(writer, customScalarAdapters, value.pageInfo)
    }
  }

  public object List : Adapter<GetMyEventsQuery.List> {
    public val RESPONSE_NAMES: kotlin.collections.List<String> = listOf("__typename")

    public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
        GetMyEventsQuery.List {
      var __typename: String? = null

      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> __typename = StringAdapter.fromJson(reader, customScalarAdapters)
          else -> break
        }
      }

      reader.rewind()
      val _myEventCard = com.cyberconnect.link3.fragment.MyEventCardImpl_ResponseAdapter.MyEventCard.fromJson(reader,
          customScalarAdapters)

      return GetMyEventsQuery.List(
        __typename = __typename!!,
        myEventCard = _myEventCard
      )
    }

    public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: GetMyEventsQuery.List,
    ): Unit {
      writer.name("__typename")
      StringAdapter.toJson(writer, customScalarAdapters, value.__typename)

      com.cyberconnect.link3.fragment.MyEventCardImpl_ResponseAdapter.MyEventCard.toJson(writer,
          customScalarAdapters, value.myEventCard)
    }
  }

  public object PageInfo : Adapter<GetMyEventsQuery.PageInfo> {
    public val RESPONSE_NAMES: kotlin.collections.List<String> = listOf("__typename")

    public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
        GetMyEventsQuery.PageInfo {
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

      return GetMyEventsQuery.PageInfo(
        __typename = __typename!!,
        pageInfo = _pageInfo
      )
    }

    public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: GetMyEventsQuery.PageInfo,
    ): Unit {
      writer.name("__typename")
      StringAdapter.toJson(writer, customScalarAdapters, value.__typename)

      com.cyberconnect.link3.fragment.PageInfoImpl_ResponseAdapter.PageInfo.toJson(writer,
          customScalarAdapters, value.pageInfo)
    }
  }
}
