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
import com.apollographql.apollo3.api.StringAdapter
import com.apollographql.apollo3.api.json.JsonReader
import com.apollographql.apollo3.api.json.JsonWriter
import com.apollographql.apollo3.api.obj
import com.cyberconnect.link3.type.EventRegisterStatus
import com.cyberconnect.link3.type.EventStatus
import com.cyberconnect.link3.type.adapter.EventRegisterStatus_ResponseAdapter
import com.cyberconnect.link3.type.adapter.EventStatus_ResponseAdapter
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.Unit
import kotlin.collections.List

public object PosterEventCardImpl_ResponseAdapter {
  public object PosterEventCard : Adapter<com.cyberconnect.link3.fragment.PosterEventCard> {
    public val RESPONSE_NAMES: List<String> = listOf("id", "title", "posterUrl", "startTimestamp",
        "endTimestamp", "registerStatus", "registrantsCount", "status", "organizer", "lightInfo")

    public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
        com.cyberconnect.link3.fragment.PosterEventCard {
      var _id: String? = null
      var _title: String? = null
      var _posterUrl: Any? = null
      var _startTimestamp: Any? = null
      var _endTimestamp: Any? = null
      var _registerStatus: EventRegisterStatus? = null
      var _registrantsCount: Int? = null
      var _status: EventStatus? = null
      var _organizer: com.cyberconnect.link3.fragment.PosterEventCard.Organizer? = null
      var _lightInfo: com.cyberconnect.link3.fragment.PosterEventCard.LightInfo? = null

      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> _id = StringAdapter.fromJson(reader, customScalarAdapters)
          1 -> _title = StringAdapter.fromJson(reader, customScalarAdapters)
          2 -> _posterUrl = AnyAdapter.fromJson(reader, customScalarAdapters)
          3 -> _startTimestamp = AnyAdapter.fromJson(reader, customScalarAdapters)
          4 -> _endTimestamp = AnyAdapter.fromJson(reader, customScalarAdapters)
          5 -> _registerStatus = EventRegisterStatus_ResponseAdapter.fromJson(reader,
              customScalarAdapters)
          6 -> _registrantsCount = IntAdapter.fromJson(reader, customScalarAdapters)
          7 -> _status = EventStatus_ResponseAdapter.fromJson(reader, customScalarAdapters)
          8 -> _organizer = Organizer.obj(true).fromJson(reader, customScalarAdapters)
          9 -> _lightInfo = LightInfo.obj().fromJson(reader, customScalarAdapters)
          else -> break
        }
      }

      return com.cyberconnect.link3.fragment.PosterEventCard(
        id = _id!!,
        title = _title!!,
        posterUrl = _posterUrl!!,
        startTimestamp = _startTimestamp!!,
        endTimestamp = _endTimestamp!!,
        registerStatus = _registerStatus!!,
        registrantsCount = _registrantsCount!!,
        status = _status!!,
        organizer = _organizer!!,
        lightInfo = _lightInfo!!
      )
    }

    public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: com.cyberconnect.link3.fragment.PosterEventCard,
    ): Unit {
      writer.name("id")
      StringAdapter.toJson(writer, customScalarAdapters, value.id)

      writer.name("title")
      StringAdapter.toJson(writer, customScalarAdapters, value.title)

      writer.name("posterUrl")
      AnyAdapter.toJson(writer, customScalarAdapters, value.posterUrl)

      writer.name("startTimestamp")
      AnyAdapter.toJson(writer, customScalarAdapters, value.startTimestamp)

      writer.name("endTimestamp")
      AnyAdapter.toJson(writer, customScalarAdapters, value.endTimestamp)

      writer.name("registerStatus")
      EventRegisterStatus_ResponseAdapter.toJson(writer, customScalarAdapters, value.registerStatus)

      writer.name("registrantsCount")
      IntAdapter.toJson(writer, customScalarAdapters, value.registrantsCount)

      writer.name("status")
      EventStatus_ResponseAdapter.toJson(writer, customScalarAdapters, value.status)

      writer.name("organizer")
      Organizer.obj(true).toJson(writer, customScalarAdapters, value.organizer)

      writer.name("lightInfo")
      LightInfo.obj().toJson(writer, customScalarAdapters, value.lightInfo)
    }
  }

  public object Organizer : Adapter<com.cyberconnect.link3.fragment.PosterEventCard.Organizer> {
    public val RESPONSE_NAMES: List<String> = listOf("__typename")

    public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
        com.cyberconnect.link3.fragment.PosterEventCard.Organizer {
      var __typename: String? = null

      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> __typename = StringAdapter.fromJson(reader, customScalarAdapters)
          else -> break
        }
      }

      reader.rewind()
      val _organizerForV3EventCard = com.cyberconnect.link3.fragment.OrganizerForV3EventCardImpl_ResponseAdapter.OrganizerForV3EventCard.fromJson(reader,
          customScalarAdapters)

      return com.cyberconnect.link3.fragment.PosterEventCard.Organizer(
        __typename = __typename!!,
        organizerForV3EventCard = _organizerForV3EventCard
      )
    }

    public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: com.cyberconnect.link3.fragment.PosterEventCard.Organizer,
    ): Unit {
      writer.name("__typename")
      StringAdapter.toJson(writer, customScalarAdapters, value.__typename)

      com.cyberconnect.link3.fragment.OrganizerForV3EventCardImpl_ResponseAdapter.OrganizerForV3EventCard.toJson(writer,
          customScalarAdapters, value.organizerForV3EventCard)
    }
  }

  public object LightInfo : Adapter<com.cyberconnect.link3.fragment.PosterEventCard.LightInfo> {
    public val RESPONSE_NAMES: List<String> = listOf("hasRaffle", "hasW3ST")

    public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
        com.cyberconnect.link3.fragment.PosterEventCard.LightInfo {
      var _hasRaffle: Boolean? = null
      var _hasW3ST: Boolean? = null

      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> _hasRaffle = BooleanAdapter.fromJson(reader, customScalarAdapters)
          1 -> _hasW3ST = BooleanAdapter.fromJson(reader, customScalarAdapters)
          else -> break
        }
      }

      return com.cyberconnect.link3.fragment.PosterEventCard.LightInfo(
        hasRaffle = _hasRaffle!!,
        hasW3ST = _hasW3ST!!
      )
    }

    public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: com.cyberconnect.link3.fragment.PosterEventCard.LightInfo,
    ): Unit {
      writer.name("hasRaffle")
      BooleanAdapter.toJson(writer, customScalarAdapters, value.hasRaffle)

      writer.name("hasW3ST")
      BooleanAdapter.toJson(writer, customScalarAdapters, value.hasW3ST)
    }
  }
}