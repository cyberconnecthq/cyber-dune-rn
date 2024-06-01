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
import com.apollographql.apollo3.api.nullable
import com.apollographql.apollo3.api.obj
import com.cyberconnect.link3.MyPriceQuery
import com.cyberconnect.link3.type.ChatPriceStatus
import com.cyberconnect.link3.type.adapter.ChatPriceStatus_ResponseAdapter
import kotlin.String
import kotlin.Unit
import kotlin.collections.List

public object MyPriceQuery_ResponseAdapter {
  public object Data : Adapter<MyPriceQuery.Data> {
    public val RESPONSE_NAMES: List<String> = listOf("me")

    public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
        MyPriceQuery.Data {
      var _me: MyPriceQuery.Me? = null

      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> _me = Me.obj().fromJson(reader, customScalarAdapters)
          else -> break
        }
      }

      return MyPriceQuery.Data(
        me = _me!!
      )
    }

    public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: MyPriceQuery.Data,
    ): Unit {
      writer.name("me")
      Me.obj().toJson(writer, customScalarAdapters, value.me)
    }
  }

  public object Me : Adapter<MyPriceQuery.Me> {
    public val RESPONSE_NAMES: List<String> = listOf("data")

    public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
        MyPriceQuery.Me {
      var _data: MyPriceQuery.Data1? = null

      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> _data = Data1.obj().nullable().fromJson(reader, customScalarAdapters)
          else -> break
        }
      }

      return MyPriceQuery.Me(
        `data` = _data
      )
    }

    public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: MyPriceQuery.Me,
    ): Unit {
      writer.name("data")
      Data1.obj().nullable().toJson(writer, customScalarAdapters, value.`data`)
    }
  }

  public object Data1 : Adapter<MyPriceQuery.Data1> {
    public val RESPONSE_NAMES: List<String> = listOf("price")

    public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
        MyPriceQuery.Data1 {
      var _price: MyPriceQuery.Price? = null

      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> _price = Price.obj().fromJson(reader, customScalarAdapters)
          else -> break
        }
      }

      return MyPriceQuery.Data1(
        price = _price!!
      )
    }

    public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: MyPriceQuery.Data1,
    ): Unit {
      writer.name("price")
      Price.obj().toJson(writer, customScalarAdapters, value.price)
    }
  }

  public object Price : Adapter<MyPriceQuery.Price> {
    public val RESPONSE_NAMES: List<String> = listOf("priceStatus", "price")

    public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
        MyPriceQuery.Price {
      var _priceStatus: ChatPriceStatus? = null
      var _price: MyPriceQuery.Price1? = null

      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> _priceStatus = ChatPriceStatus_ResponseAdapter.fromJson(reader, customScalarAdapters)
          1 -> _price = Price1.obj(true).fromJson(reader, customScalarAdapters)
          else -> break
        }
      }

      return MyPriceQuery.Price(
        priceStatus = _priceStatus!!,
        price = _price!!
      )
    }

    public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: MyPriceQuery.Price,
    ): Unit {
      writer.name("priceStatus")
      ChatPriceStatus_ResponseAdapter.toJson(writer, customScalarAdapters, value.priceStatus)

      writer.name("price")
      Price1.obj(true).toJson(writer, customScalarAdapters, value.price)
    }
  }

  public object Price1 : Adapter<MyPriceQuery.Price1> {
    public val RESPONSE_NAMES: List<String> = listOf("__typename")

    public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
        MyPriceQuery.Price1 {
      var __typename: String? = null

      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> __typename = StringAdapter.fromJson(reader, customScalarAdapters)
          else -> break
        }
      }

      reader.rewind()
      val _price = com.cyberconnect.link3.fragment.PriceImpl_ResponseAdapter.Price.fromJson(reader,
          customScalarAdapters)

      return MyPriceQuery.Price1(
        __typename = __typename!!,
        price = _price
      )
    }

    public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: MyPriceQuery.Price1,
    ): Unit {
      writer.name("__typename")
      StringAdapter.toJson(writer, customScalarAdapters, value.__typename)

      com.cyberconnect.link3.fragment.PriceImpl_ResponseAdapter.Price.toJson(writer,
          customScalarAdapters, value.price)
    }
  }
}
