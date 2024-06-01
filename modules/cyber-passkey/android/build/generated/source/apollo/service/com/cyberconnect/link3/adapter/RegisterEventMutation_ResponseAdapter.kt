//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.2'.
//
package com.cyberconnect.link3.adapter

import com.apollographql.apollo3.api.Adapter
import com.apollographql.apollo3.api.CustomScalarAdapters
import com.apollographql.apollo3.api.json.JsonReader
import com.apollographql.apollo3.api.json.JsonWriter
import com.apollographql.apollo3.api.obj
import com.cyberconnect.link3.RegisterEventMutation
import com.cyberconnect.link3.type.RegisterEventResponse_Status
import com.cyberconnect.link3.type.adapter.RegisterEventResponse_Status_ResponseAdapter
import kotlin.String
import kotlin.Unit
import kotlin.collections.List

public object RegisterEventMutation_ResponseAdapter {
  public object Data : Adapter<RegisterEventMutation.Data> {
    public val RESPONSE_NAMES: List<String> = listOf("registerEvent")

    public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
        RegisterEventMutation.Data {
      var _registerEvent: RegisterEventMutation.RegisterEvent? = null

      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> _registerEvent = RegisterEvent.obj().fromJson(reader, customScalarAdapters)
          else -> break
        }
      }

      return RegisterEventMutation.Data(
        registerEvent = _registerEvent!!
      )
    }

    public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: RegisterEventMutation.Data,
    ): Unit {
      writer.name("registerEvent")
      RegisterEvent.obj().toJson(writer, customScalarAdapters, value.registerEvent)
    }
  }

  public object RegisterEvent : Adapter<RegisterEventMutation.RegisterEvent> {
    public val RESPONSE_NAMES: List<String> = listOf("status")

    public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
        RegisterEventMutation.RegisterEvent {
      var _status: RegisterEventResponse_Status? = null

      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> _status = RegisterEventResponse_Status_ResponseAdapter.fromJson(reader,
              customScalarAdapters)
          else -> break
        }
      }

      return RegisterEventMutation.RegisterEvent(
        status = _status!!
      )
    }

    public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: RegisterEventMutation.RegisterEvent,
    ): Unit {
      writer.name("status")
      RegisterEventResponse_Status_ResponseAdapter.toJson(writer, customScalarAdapters,
          value.status)
    }
  }
}