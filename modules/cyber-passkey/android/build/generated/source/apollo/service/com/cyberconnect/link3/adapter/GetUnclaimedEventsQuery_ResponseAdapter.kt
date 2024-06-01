//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.2'.
//
package com.cyberconnect.link3.adapter

import com.apollographql.apollo3.api.Adapter
import com.apollographql.apollo3.api.AnyAdapter
import com.apollographql.apollo3.api.BooleanAdapter
import com.apollographql.apollo3.api.CustomScalarAdapters
import com.apollographql.apollo3.api.IntAdapter
import com.apollographql.apollo3.api.StringAdapter
import com.apollographql.apollo3.api.json.JsonReader
import com.apollographql.apollo3.api.json.JsonWriter
import com.apollographql.apollo3.api.list
import com.apollographql.apollo3.api.nullable
import com.apollographql.apollo3.api.obj
import com.cyberconnect.link3.GetUnclaimedEventsQuery
import com.cyberconnect.link3.type.EventRegisterStatus
import com.cyberconnect.link3.type.EventStatus
import com.cyberconnect.link3.type.MeResponse_Status
import com.cyberconnect.link3.type.adapter.EventRegisterStatus_ResponseAdapter
import com.cyberconnect.link3.type.adapter.EventStatus_ResponseAdapter
import com.cyberconnect.link3.type.adapter.MeResponse_Status_ResponseAdapter
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.Unit
import kotlin.collections.List

public object GetUnclaimedEventsQuery_ResponseAdapter {
  public object Data : Adapter<GetUnclaimedEventsQuery.Data> {
    public val RESPONSE_NAMES: List<String> = listOf("me")

    public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
        GetUnclaimedEventsQuery.Data {
      var _me: GetUnclaimedEventsQuery.Me? = null

      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> _me = Me.obj().fromJson(reader, customScalarAdapters)
          else -> break
        }
      }

      return GetUnclaimedEventsQuery.Data(
        me = _me!!
      )
    }

    public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: GetUnclaimedEventsQuery.Data,
    ): Unit {
      writer.name("me")
      Me.obj().toJson(writer, customScalarAdapters, value.me)
    }
  }

  public object Me : Adapter<GetUnclaimedEventsQuery.Me> {
    public val RESPONSE_NAMES: List<String> = listOf("status", "message", "data")

    public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
        GetUnclaimedEventsQuery.Me {
      var _status: MeResponse_Status? = null
      var _message: String? = null
      var _data: GetUnclaimedEventsQuery.Data1? = null

      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> _status = MeResponse_Status_ResponseAdapter.fromJson(reader, customScalarAdapters)
          1 -> _message = StringAdapter.fromJson(reader, customScalarAdapters)
          2 -> _data = Data1.obj().nullable().fromJson(reader, customScalarAdapters)
          else -> break
        }
      }

      return GetUnclaimedEventsQuery.Me(
        status = _status!!,
        message = _message!!,
        `data` = _data
      )
    }

    public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: GetUnclaimedEventsQuery.Me,
    ): Unit {
      writer.name("status")
      MeResponse_Status_ResponseAdapter.toJson(writer, customScalarAdapters, value.status)

      writer.name("message")
      StringAdapter.toJson(writer, customScalarAdapters, value.message)

      writer.name("data")
      Data1.obj().nullable().toJson(writer, customScalarAdapters, value.`data`)
    }
  }

  public object Data1 : Adapter<GetUnclaimedEventsQuery.Data1> {
    public val RESPONSE_NAMES: List<String> = listOf("unclaimedEvents")

    public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
        GetUnclaimedEventsQuery.Data1 {
      var _unclaimedEvents: List<GetUnclaimedEventsQuery.UnclaimedEvent>? = null

      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> _unclaimedEvents = UnclaimedEvent.obj().list().nullable().fromJson(reader,
              customScalarAdapters)
          else -> break
        }
      }

      return GetUnclaimedEventsQuery.Data1(
        unclaimedEvents = _unclaimedEvents
      )
    }

    public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: GetUnclaimedEventsQuery.Data1,
    ): Unit {
      writer.name("unclaimedEvents")
      UnclaimedEvent.obj().list().nullable().toJson(writer, customScalarAdapters,
          value.unclaimedEvents)
    }
  }

  public object UnclaimedEvent : Adapter<GetUnclaimedEventsQuery.UnclaimedEvent> {
    public val RESPONSE_NAMES: List<String> = listOf("id", "info", "title", "posterUrl",
        "startTimestamp", "endTimestamp", "status", "registrantsCount", "registerStatus",
        "organizer", "lightInfo")

    public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
        GetUnclaimedEventsQuery.UnclaimedEvent {
      var _id: String? = null
      var _info: String? = null
      var _title: String? = null
      var _posterUrl: Any? = null
      var _startTimestamp: Any? = null
      var _endTimestamp: Any? = null
      var _status: EventStatus? = null
      var _registrantsCount: Int? = null
      var _registerStatus: EventRegisterStatus? = null
      var _organizer: GetUnclaimedEventsQuery.Organizer? = null
      var _lightInfo: GetUnclaimedEventsQuery.LightInfo? = null

      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> _id = StringAdapter.fromJson(reader, customScalarAdapters)
          1 -> _info = StringAdapter.fromJson(reader, customScalarAdapters)
          2 -> _title = StringAdapter.fromJson(reader, customScalarAdapters)
          3 -> _posterUrl = AnyAdapter.fromJson(reader, customScalarAdapters)
          4 -> _startTimestamp = AnyAdapter.fromJson(reader, customScalarAdapters)
          5 -> _endTimestamp = AnyAdapter.fromJson(reader, customScalarAdapters)
          6 -> _status = EventStatus_ResponseAdapter.fromJson(reader, customScalarAdapters)
          7 -> _registrantsCount = IntAdapter.fromJson(reader, customScalarAdapters)
          8 -> _registerStatus = EventRegisterStatus_ResponseAdapter.fromJson(reader,
              customScalarAdapters)
          9 -> _organizer = Organizer.obj(true).fromJson(reader, customScalarAdapters)
          10 -> _lightInfo = LightInfo.obj().fromJson(reader, customScalarAdapters)
          else -> break
        }
      }

      return GetUnclaimedEventsQuery.UnclaimedEvent(
        id = _id!!,
        info = _info!!,
        title = _title!!,
        posterUrl = _posterUrl!!,
        startTimestamp = _startTimestamp!!,
        endTimestamp = _endTimestamp!!,
        status = _status!!,
        registrantsCount = _registrantsCount!!,
        registerStatus = _registerStatus!!,
        organizer = _organizer!!,
        lightInfo = _lightInfo!!
      )
    }

    public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: GetUnclaimedEventsQuery.UnclaimedEvent,
    ): Unit {
      writer.name("id")
      StringAdapter.toJson(writer, customScalarAdapters, value.id)

      writer.name("info")
      StringAdapter.toJson(writer, customScalarAdapters, value.info)

      writer.name("title")
      StringAdapter.toJson(writer, customScalarAdapters, value.title)

      writer.name("posterUrl")
      AnyAdapter.toJson(writer, customScalarAdapters, value.posterUrl)

      writer.name("startTimestamp")
      AnyAdapter.toJson(writer, customScalarAdapters, value.startTimestamp)

      writer.name("endTimestamp")
      AnyAdapter.toJson(writer, customScalarAdapters, value.endTimestamp)

      writer.name("status")
      EventStatus_ResponseAdapter.toJson(writer, customScalarAdapters, value.status)

      writer.name("registrantsCount")
      IntAdapter.toJson(writer, customScalarAdapters, value.registrantsCount)

      writer.name("registerStatus")
      EventRegisterStatus_ResponseAdapter.toJson(writer, customScalarAdapters, value.registerStatus)

      writer.name("organizer")
      Organizer.obj(true).toJson(writer, customScalarAdapters, value.organizer)

      writer.name("lightInfo")
      LightInfo.obj().toJson(writer, customScalarAdapters, value.lightInfo)
    }
  }

  public object Organizer : Adapter<GetUnclaimedEventsQuery.Organizer> {
    public val RESPONSE_NAMES: List<String> = listOf("__typename")

    public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
        GetUnclaimedEventsQuery.Organizer {
      var __typename: String? = null

      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> __typename = StringAdapter.fromJson(reader, customScalarAdapters)
          else -> break
        }
      }

      reader.rewind()
      val _organizer = com.cyberconnect.link3.fragment.OrganizerImpl_ResponseAdapter.Organizer.fromJson(reader,
          customScalarAdapters)

      return GetUnclaimedEventsQuery.Organizer(
        __typename = __typename!!,
        organizer = _organizer
      )
    }

    public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: GetUnclaimedEventsQuery.Organizer,
    ): Unit {
      writer.name("__typename")
      StringAdapter.toJson(writer, customScalarAdapters, value.__typename)

      com.cyberconnect.link3.fragment.OrganizerImpl_ResponseAdapter.Organizer.toJson(writer,
          customScalarAdapters, value.organizer)
    }
  }

  public object LightInfo : Adapter<GetUnclaimedEventsQuery.LightInfo> {
    public val RESPONSE_NAMES: List<String> = listOf("hasRaffle", "hasW3ST")

    public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
        GetUnclaimedEventsQuery.LightInfo {
      var _hasRaffle: Boolean? = null
      var _hasW3ST: Boolean? = null

      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> _hasRaffle = BooleanAdapter.fromJson(reader, customScalarAdapters)
          1 -> _hasW3ST = BooleanAdapter.fromJson(reader, customScalarAdapters)
          else -> break
        }
      }

      return GetUnclaimedEventsQuery.LightInfo(
        hasRaffle = _hasRaffle!!,
        hasW3ST = _hasW3ST!!
      )
    }

    public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: GetUnclaimedEventsQuery.LightInfo,
    ): Unit {
      writer.name("hasRaffle")
      BooleanAdapter.toJson(writer, customScalarAdapters, value.hasRaffle)

      writer.name("hasW3ST")
      BooleanAdapter.toJson(writer, customScalarAdapters, value.hasW3ST)
    }
  }
}