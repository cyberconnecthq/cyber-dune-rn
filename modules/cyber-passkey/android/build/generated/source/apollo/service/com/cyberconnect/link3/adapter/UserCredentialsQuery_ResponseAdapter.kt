//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.2'.
//
package com.cyberconnect.link3.adapter

import com.apollographql.apollo3.api.Adapter
import com.apollographql.apollo3.api.CustomScalarAdapters
import com.apollographql.apollo3.api.IntAdapter
import com.apollographql.apollo3.api.StringAdapter
import com.apollographql.apollo3.api.json.JsonReader
import com.apollographql.apollo3.api.json.JsonWriter
import com.apollographql.apollo3.api.list
import com.apollographql.apollo3.api.obj
import com.cyberconnect.link3.UserCredentialsQuery
import com.cyberconnect.link3.type.Chain
import com.cyberconnect.link3.type.adapter.Chain_ResponseAdapter
import kotlin.Int
import kotlin.String
import kotlin.Unit

public object UserCredentialsQuery_ResponseAdapter {
  public object Data : Adapter<UserCredentialsQuery.Data> {
    public val RESPONSE_NAMES: kotlin.collections.List<String> = listOf("addressInfo")

    public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
        UserCredentialsQuery.Data {
      var _addressInfo: UserCredentialsQuery.AddressInfo? = null

      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> _addressInfo = AddressInfo.obj().fromJson(reader, customScalarAdapters)
          else -> break
        }
      }

      return UserCredentialsQuery.Data(
        addressInfo = _addressInfo!!
      )
    }

    public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: UserCredentialsQuery.Data,
    ): Unit {
      writer.name("addressInfo")
      AddressInfo.obj().toJson(writer, customScalarAdapters, value.addressInfo)
    }
  }

  public object AddressInfo : Adapter<UserCredentialsQuery.AddressInfo> {
    public val RESPONSE_NAMES: kotlin.collections.List<String> =
        listOf("addressEligibleCredentials")

    public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
        UserCredentialsQuery.AddressInfo {
      var _addressEligibleCredentials: UserCredentialsQuery.AddressEligibleCredentials? = null

      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> _addressEligibleCredentials = AddressEligibleCredentials.obj().fromJson(reader,
              customScalarAdapters)
          else -> break
        }
      }

      return UserCredentialsQuery.AddressInfo(
        addressEligibleCredentials = _addressEligibleCredentials!!
      )
    }

    public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: UserCredentialsQuery.AddressInfo,
    ): Unit {
      writer.name("addressEligibleCredentials")
      AddressEligibleCredentials.obj().toJson(writer, customScalarAdapters,
          value.addressEligibleCredentials)
    }
  }

  public object AddressEligibleCredentials :
      Adapter<UserCredentialsQuery.AddressEligibleCredentials> {
    public val RESPONSE_NAMES: kotlin.collections.List<String> = listOf("list")

    public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
        UserCredentialsQuery.AddressEligibleCredentials {
      var _list: kotlin.collections.List<UserCredentialsQuery.List>? = null

      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> _list = List.obj().list().fromJson(reader, customScalarAdapters)
          else -> break
        }
      }

      return UserCredentialsQuery.AddressEligibleCredentials(
        list = _list!!
      )
    }

    public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: UserCredentialsQuery.AddressEligibleCredentials,
    ): Unit {
      writer.name("list")
      List.obj().list().toJson(writer, customScalarAdapters, value.list)
    }
  }

  public object List : Adapter<UserCredentialsQuery.List> {
    public val RESPONSE_NAMES: kotlin.collections.List<String> = listOf("id", "name", "description",
        "chain", "itemCount")

    public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
        UserCredentialsQuery.List {
      var _id: String? = null
      var _name: String? = null
      var _description: String? = null
      var _chain: Chain? = null
      var _itemCount: Int? = null

      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> _id = StringAdapter.fromJson(reader, customScalarAdapters)
          1 -> _name = StringAdapter.fromJson(reader, customScalarAdapters)
          2 -> _description = StringAdapter.fromJson(reader, customScalarAdapters)
          3 -> _chain = Chain_ResponseAdapter.fromJson(reader, customScalarAdapters)
          4 -> _itemCount = IntAdapter.fromJson(reader, customScalarAdapters)
          else -> break
        }
      }

      return UserCredentialsQuery.List(
        id = _id!!,
        name = _name!!,
        description = _description!!,
        chain = _chain!!,
        itemCount = _itemCount!!
      )
    }

    public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: UserCredentialsQuery.List,
    ): Unit {
      writer.name("id")
      StringAdapter.toJson(writer, customScalarAdapters, value.id)

      writer.name("name")
      StringAdapter.toJson(writer, customScalarAdapters, value.name)

      writer.name("description")
      StringAdapter.toJson(writer, customScalarAdapters, value.description)

      writer.name("chain")
      Chain_ResponseAdapter.toJson(writer, customScalarAdapters, value.chain)

      writer.name("itemCount")
      IntAdapter.toJson(writer, customScalarAdapters, value.itemCount)
    }
  }
}