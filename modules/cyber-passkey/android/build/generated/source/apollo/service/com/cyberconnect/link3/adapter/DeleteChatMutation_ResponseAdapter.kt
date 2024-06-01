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
import com.cyberconnect.link3.DeleteChatMutation
import com.cyberconnect.link3.type.DeleteChatResponse_Status
import com.cyberconnect.link3.type.adapter.DeleteChatResponse_Status_ResponseAdapter
import kotlin.String
import kotlin.Unit
import kotlin.collections.List

public object DeleteChatMutation_ResponseAdapter {
  public object Data : Adapter<DeleteChatMutation.Data> {
    public val RESPONSE_NAMES: List<String> = listOf("deleteChat")

    public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
        DeleteChatMutation.Data {
      var _deleteChat: DeleteChatMutation.DeleteChat? = null

      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> _deleteChat = DeleteChat.obj().fromJson(reader, customScalarAdapters)
          else -> break
        }
      }

      return DeleteChatMutation.Data(
        deleteChat = _deleteChat!!
      )
    }

    public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: DeleteChatMutation.Data,
    ): Unit {
      writer.name("deleteChat")
      DeleteChat.obj().toJson(writer, customScalarAdapters, value.deleteChat)
    }
  }

  public object DeleteChat : Adapter<DeleteChatMutation.DeleteChat> {
    public val RESPONSE_NAMES: List<String> = listOf("status")

    public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
        DeleteChatMutation.DeleteChat {
      var _status: DeleteChatResponse_Status? = null

      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> _status = DeleteChatResponse_Status_ResponseAdapter.fromJson(reader,
              customScalarAdapters)
          else -> break
        }
      }

      return DeleteChatMutation.DeleteChat(
        status = _status!!
      )
    }

    public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: DeleteChatMutation.DeleteChat,
    ): Unit {
      writer.name("status")
      DeleteChatResponse_Status_ResponseAdapter.toJson(writer, customScalarAdapters, value.status)
    }
  }
}
