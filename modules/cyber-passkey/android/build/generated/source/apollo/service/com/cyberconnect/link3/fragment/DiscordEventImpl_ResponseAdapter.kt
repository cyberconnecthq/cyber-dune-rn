//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.2'.
//
package com.cyberconnect.link3.fragment

import com.apollographql.apollo3.api.Adapter
import com.apollographql.apollo3.api.BooleanAdapter
import com.apollographql.apollo3.api.CustomScalarAdapters
import com.apollographql.apollo3.api.StringAdapter
import com.apollographql.apollo3.api.json.JsonReader
import com.apollographql.apollo3.api.json.JsonWriter
import kotlin.Boolean
import kotlin.String
import kotlin.Unit
import kotlin.collections.List

public object DiscordEventImpl_ResponseAdapter {
  public object DiscordEvent : Adapter<com.cyberconnect.link3.fragment.DiscordEvent> {
    public val RESPONSE_NAMES: List<String> = listOf("server", "serverName", "channel",
        "channelName", "autoSync")

    public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
        com.cyberconnect.link3.fragment.DiscordEvent {
      var _server: String? = null
      var _serverName: String? = null
      var _channel: String? = null
      var _channelName: String? = null
      var _autoSync: Boolean? = null

      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> _server = StringAdapter.fromJson(reader, customScalarAdapters)
          1 -> _serverName = StringAdapter.fromJson(reader, customScalarAdapters)
          2 -> _channel = StringAdapter.fromJson(reader, customScalarAdapters)
          3 -> _channelName = StringAdapter.fromJson(reader, customScalarAdapters)
          4 -> _autoSync = BooleanAdapter.fromJson(reader, customScalarAdapters)
          else -> break
        }
      }

      return com.cyberconnect.link3.fragment.DiscordEvent(
        server = _server!!,
        serverName = _serverName!!,
        channel = _channel!!,
        channelName = _channelName!!,
        autoSync = _autoSync!!
      )
    }

    public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: com.cyberconnect.link3.fragment.DiscordEvent,
    ): Unit {
      writer.name("server")
      StringAdapter.toJson(writer, customScalarAdapters, value.server)

      writer.name("serverName")
      StringAdapter.toJson(writer, customScalarAdapters, value.serverName)

      writer.name("channel")
      StringAdapter.toJson(writer, customScalarAdapters, value.channel)

      writer.name("channelName")
      StringAdapter.toJson(writer, customScalarAdapters, value.channelName)

      writer.name("autoSync")
      BooleanAdapter.toJson(writer, customScalarAdapters, value.autoSync)
    }
  }
}
