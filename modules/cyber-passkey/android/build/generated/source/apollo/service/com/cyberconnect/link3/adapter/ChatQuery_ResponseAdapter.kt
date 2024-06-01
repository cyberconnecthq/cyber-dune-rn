//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.2'.
//
package com.cyberconnect.link3.adapter

import com.apollographql.apollo3.api.Adapter
import com.apollographql.apollo3.api.BooleanAdapter
import com.apollographql.apollo3.api.CustomScalarAdapters
import com.apollographql.apollo3.api.StringAdapter
import com.apollographql.apollo3.api.json.JsonReader
import com.apollographql.apollo3.api.json.JsonWriter
import com.apollographql.apollo3.api.list
import com.apollographql.apollo3.api.nullable
import com.apollographql.apollo3.api.obj
import com.cyberconnect.link3.ChatQuery
import kotlin.Boolean
import kotlin.String
import kotlin.Unit

public object ChatQuery_ResponseAdapter {
  public object Data : Adapter<ChatQuery.Data> {
    public val RESPONSE_NAMES: kotlin.collections.List<String> = listOf("me")

    public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
        ChatQuery.Data {
      var _me: ChatQuery.Me? = null

      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> _me = Me.obj().fromJson(reader, customScalarAdapters)
          else -> break
        }
      }

      return ChatQuery.Data(
        me = _me!!
      )
    }

    public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: ChatQuery.Data,
    ): Unit {
      writer.name("me")
      Me.obj().toJson(writer, customScalarAdapters, value.me)
    }
  }

  public object Me : Adapter<ChatQuery.Me> {
    public val RESPONSE_NAMES: kotlin.collections.List<String> = listOf("data")

    public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
        ChatQuery.Me {
      var _data: ChatQuery.Data1? = null

      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> _data = Data1.obj().nullable().fromJson(reader, customScalarAdapters)
          else -> break
        }
      }

      return ChatQuery.Me(
        `data` = _data
      )
    }

    public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: ChatQuery.Me,
    ): Unit {
      writer.name("data")
      Data1.obj().nullable().toJson(writer, customScalarAdapters, value.`data`)
    }
  }

  public object Data1 : Adapter<ChatQuery.Data1> {
    public val RESPONSE_NAMES: kotlin.collections.List<String> = listOf("chat")

    public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
        ChatQuery.Data1 {
      var _chat: ChatQuery.Chat? = null

      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> _chat = Chat.obj().nullable().fromJson(reader, customScalarAdapters)
          else -> break
        }
      }

      return ChatQuery.Data1(
        chat = _chat
      )
    }

    public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: ChatQuery.Data1,
    ): Unit {
      writer.name("chat")
      Chat.obj().nullable().toJson(writer, customScalarAdapters, value.chat)
    }
  }

  public object Chat : Adapter<ChatQuery.Chat> {
    public val RESPONSE_NAMES: kotlin.collections.List<String> = listOf("receiverDeleted",
        "lastMessage", "messages")

    public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
        ChatQuery.Chat {
      var _receiverDeleted: Boolean? = null
      var _lastMessage: ChatQuery.LastMessage? = null
      var _messages: ChatQuery.Messages? = null

      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> _receiverDeleted = BooleanAdapter.fromJson(reader, customScalarAdapters)
          1 -> _lastMessage = LastMessage.obj(true).nullable().fromJson(reader,
              customScalarAdapters)
          2 -> _messages = Messages.obj().fromJson(reader, customScalarAdapters)
          else -> break
        }
      }

      return ChatQuery.Chat(
        receiverDeleted = _receiverDeleted!!,
        lastMessage = _lastMessage,
        messages = _messages!!
      )
    }

    public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: ChatQuery.Chat,
    ): Unit {
      writer.name("receiverDeleted")
      BooleanAdapter.toJson(writer, customScalarAdapters, value.receiverDeleted)

      writer.name("lastMessage")
      LastMessage.obj(true).nullable().toJson(writer, customScalarAdapters, value.lastMessage)

      writer.name("messages")
      Messages.obj().toJson(writer, customScalarAdapters, value.messages)
    }
  }

  public object LastMessage : Adapter<ChatQuery.LastMessage> {
    public val RESPONSE_NAMES: kotlin.collections.List<String> = listOf("__typename")

    public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
        ChatQuery.LastMessage {
      var __typename: String? = null

      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> __typename = StringAdapter.fromJson(reader, customScalarAdapters)
          else -> break
        }
      }

      reader.rewind()
      val _perMessage = com.cyberconnect.link3.fragment.PerMessageImpl_ResponseAdapter.PerMessage.fromJson(reader,
          customScalarAdapters)

      return ChatQuery.LastMessage(
        __typename = __typename!!,
        perMessage = _perMessage
      )
    }

    public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: ChatQuery.LastMessage,
    ): Unit {
      writer.name("__typename")
      StringAdapter.toJson(writer, customScalarAdapters, value.__typename)

      com.cyberconnect.link3.fragment.PerMessageImpl_ResponseAdapter.PerMessage.toJson(writer,
          customScalarAdapters, value.perMessage)
    }
  }

  public object Messages : Adapter<ChatQuery.Messages> {
    public val RESPONSE_NAMES: kotlin.collections.List<String> = listOf("list", "pageInfo")

    public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
        ChatQuery.Messages {
      var _list: kotlin.collections.List<ChatQuery.List>? = null
      var _pageInfo: ChatQuery.PageInfo? = null

      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> _list = List.obj(true).list().fromJson(reader, customScalarAdapters)
          1 -> _pageInfo = PageInfo.obj(true).fromJson(reader, customScalarAdapters)
          else -> break
        }
      }

      return ChatQuery.Messages(
        list = _list!!,
        pageInfo = _pageInfo!!
      )
    }

    public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: ChatQuery.Messages,
    ): Unit {
      writer.name("list")
      List.obj(true).list().toJson(writer, customScalarAdapters, value.list)

      writer.name("pageInfo")
      PageInfo.obj(true).toJson(writer, customScalarAdapters, value.pageInfo)
    }
  }

  public object List : Adapter<ChatQuery.List> {
    public val RESPONSE_NAMES: kotlin.collections.List<String> = listOf("__typename")

    public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
        ChatQuery.List {
      var __typename: String? = null

      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> __typename = StringAdapter.fromJson(reader, customScalarAdapters)
          else -> break
        }
      }

      reader.rewind()
      val _perMessage = com.cyberconnect.link3.fragment.PerMessageImpl_ResponseAdapter.PerMessage.fromJson(reader,
          customScalarAdapters)

      return ChatQuery.List(
        __typename = __typename!!,
        perMessage = _perMessage
      )
    }

    public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: ChatQuery.List,
    ): Unit {
      writer.name("__typename")
      StringAdapter.toJson(writer, customScalarAdapters, value.__typename)

      com.cyberconnect.link3.fragment.PerMessageImpl_ResponseAdapter.PerMessage.toJson(writer,
          customScalarAdapters, value.perMessage)
    }
  }

  public object PageInfo : Adapter<ChatQuery.PageInfo> {
    public val RESPONSE_NAMES: kotlin.collections.List<String> = listOf("__typename")

    public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
        ChatQuery.PageInfo {
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

      return ChatQuery.PageInfo(
        __typename = __typename!!,
        pageInfo = _pageInfo
      )
    }

    public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: ChatQuery.PageInfo,
    ): Unit {
      writer.name("__typename")
      StringAdapter.toJson(writer, customScalarAdapters, value.__typename)

      com.cyberconnect.link3.fragment.PageInfoImpl_ResponseAdapter.PageInfo.toJson(writer,
          customScalarAdapters, value.pageInfo)
    }
  }
}