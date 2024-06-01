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
import com.cyberconnect.link3.SendMessageMutation
import com.cyberconnect.link3.type.SendMessageResponse_Status
import com.cyberconnect.link3.type.adapter.SendMessageResponse_Status_ResponseAdapter
import kotlin.String
import kotlin.Unit
import kotlin.collections.List

public object SendMessageMutation_ResponseAdapter {
  public object Data : Adapter<SendMessageMutation.Data> {
    public val RESPONSE_NAMES: List<String> = listOf("sendMessage")

    public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
        SendMessageMutation.Data {
      var _sendMessage: SendMessageMutation.SendMessage? = null

      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> _sendMessage = SendMessage.obj().fromJson(reader, customScalarAdapters)
          else -> break
        }
      }

      return SendMessageMutation.Data(
        sendMessage = _sendMessage!!
      )
    }

    public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: SendMessageMutation.Data,
    ): Unit {
      writer.name("sendMessage")
      SendMessage.obj().toJson(writer, customScalarAdapters, value.sendMessage)
    }
  }

  public object SendMessage : Adapter<SendMessageMutation.SendMessage> {
    public val RESPONSE_NAMES: List<String> = listOf("status")

    public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
        SendMessageMutation.SendMessage {
      var _status: SendMessageResponse_Status? = null

      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> _status = SendMessageResponse_Status_ResponseAdapter.fromJson(reader,
              customScalarAdapters)
          else -> break
        }
      }

      return SendMessageMutation.SendMessage(
        status = _status!!
      )
    }

    public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: SendMessageMutation.SendMessage,
    ): Unit {
      writer.name("status")
      SendMessageResponse_Status_ResponseAdapter.toJson(writer, customScalarAdapters, value.status)
    }
  }
}