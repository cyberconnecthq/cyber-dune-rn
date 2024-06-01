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
import com.cyberconnect.link3.ReadMessagesMutation
import com.cyberconnect.link3.type.ReadMessagesResponse_Status
import com.cyberconnect.link3.type.adapter.ReadMessagesResponse_Status_ResponseAdapter
import kotlin.String
import kotlin.Unit
import kotlin.collections.List

public object ReadMessagesMutation_ResponseAdapter {
  public object Data : Adapter<ReadMessagesMutation.Data> {
    public val RESPONSE_NAMES: List<String> = listOf("readMessages")

    public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
        ReadMessagesMutation.Data {
      var _readMessages: ReadMessagesMutation.ReadMessages? = null

      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> _readMessages = ReadMessages.obj().fromJson(reader, customScalarAdapters)
          else -> break
        }
      }

      return ReadMessagesMutation.Data(
        readMessages = _readMessages!!
      )
    }

    public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: ReadMessagesMutation.Data,
    ): Unit {
      writer.name("readMessages")
      ReadMessages.obj().toJson(writer, customScalarAdapters, value.readMessages)
    }
  }

  public object ReadMessages : Adapter<ReadMessagesMutation.ReadMessages> {
    public val RESPONSE_NAMES: List<String> = listOf("status")

    public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
        ReadMessagesMutation.ReadMessages {
      var _status: ReadMessagesResponse_Status? = null

      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> _status = ReadMessagesResponse_Status_ResponseAdapter.fromJson(reader,
              customScalarAdapters)
          else -> break
        }
      }

      return ReadMessagesMutation.ReadMessages(
        status = _status!!
      )
    }

    public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: ReadMessagesMutation.ReadMessages,
    ): Unit {
      writer.name("status")
      ReadMessagesResponse_Status_ResponseAdapter.toJson(writer, customScalarAdapters, value.status)
    }
  }
}
