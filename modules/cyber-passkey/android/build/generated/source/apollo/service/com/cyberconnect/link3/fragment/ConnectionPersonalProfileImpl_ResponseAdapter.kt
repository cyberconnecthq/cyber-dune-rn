//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.2'.
//
package com.cyberconnect.link3.fragment

import com.apollographql.apollo3.api.Adapter
import com.apollographql.apollo3.api.BooleanAdapter
import com.apollographql.apollo3.api.CustomScalarAdapters
import com.apollographql.apollo3.api.IntAdapter
import com.apollographql.apollo3.api.NullableStringAdapter
import com.apollographql.apollo3.api.StringAdapter
import com.apollographql.apollo3.api.evaluate
import com.apollographql.apollo3.api.json.JsonReader
import com.apollographql.apollo3.api.json.JsonWriter
import com.apollographql.apollo3.api.list
import com.apollographql.apollo3.api.nullable
import com.apollographql.apollo3.api.obj
import com.apollographql.apollo3.api.possibleTypes
import com.cyberconnect.link3.type.ConnectStatus
import com.cyberconnect.link3.type.ConnectionDegree
import com.cyberconnect.link3.type.PersonalDisplayName_Type
import com.cyberconnect.link3.type.adapter.ConnectStatus_ResponseAdapter
import com.cyberconnect.link3.type.adapter.ConnectionDegree_ResponseAdapter
import com.cyberconnect.link3.type.adapter.PersonalDisplayName_Type_ResponseAdapter
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.Unit

public object ConnectionPersonalProfileImpl_ResponseAdapter {
  public object ConnectionPersonalProfile :
      Adapter<com.cyberconnect.link3.fragment.ConnectionPersonalProfile> {
    public val RESPONSE_NAMES: kotlin.collections.List<String> = listOf("id", "handle", "owner",
        "headline", "displayName", "profilePicture", "connectStatus", "connectionDegree",
        "reputation", "isVerified", "mutualConnections")

    public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
        com.cyberconnect.link3.fragment.ConnectionPersonalProfile {
      var _id: String? = null
      var _handle: String? = null
      var _owner: com.cyberconnect.link3.fragment.ConnectionPersonalProfile.Owner? = null
      var _headline: com.cyberconnect.link3.fragment.ConnectionPersonalProfile.Headline? = null
      var _displayName: com.cyberconnect.link3.fragment.ConnectionPersonalProfile.DisplayName? = null
      var _profilePicture: com.cyberconnect.link3.fragment.ConnectionPersonalProfile.ProfilePicture? = null
      var _connectStatus: ConnectStatus? = null
      var _connectionDegree: ConnectionDegree? = null
      var _reputation: com.cyberconnect.link3.fragment.ConnectionPersonalProfile.Reputation? = null
      var _isVerified: Boolean? = null
      var _mutualConnections: com.cyberconnect.link3.fragment.ConnectionPersonalProfile.MutualConnections? = null

      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> _id = StringAdapter.fromJson(reader, customScalarAdapters)
          1 -> _handle = StringAdapter.fromJson(reader, customScalarAdapters)
          2 -> _owner = Owner.obj().fromJson(reader, customScalarAdapters)
          3 -> _headline = Headline.obj().fromJson(reader, customScalarAdapters)
          4 -> _displayName = DisplayName.obj().fromJson(reader, customScalarAdapters)
          5 -> _profilePicture = ProfilePicture.obj().fromJson(reader, customScalarAdapters)
          6 -> _connectStatus = ConnectStatus_ResponseAdapter.fromJson(reader, customScalarAdapters)
          7 -> _connectionDegree = ConnectionDegree_ResponseAdapter.fromJson(reader,
              customScalarAdapters)
          8 -> _reputation = Reputation.obj().fromJson(reader, customScalarAdapters)
          9 -> _isVerified = BooleanAdapter.fromJson(reader, customScalarAdapters)
          10 -> _mutualConnections = MutualConnections.obj().fromJson(reader, customScalarAdapters)
          else -> break
        }
      }

      return com.cyberconnect.link3.fragment.ConnectionPersonalProfile(
        id = _id!!,
        handle = _handle!!,
        owner = _owner!!,
        headline = _headline!!,
        displayName = _displayName!!,
        profilePicture = _profilePicture!!,
        connectStatus = _connectStatus!!,
        connectionDegree = _connectionDegree!!,
        reputation = _reputation!!,
        isVerified = _isVerified!!,
        mutualConnections = _mutualConnections!!
      )
    }

    public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: com.cyberconnect.link3.fragment.ConnectionPersonalProfile,
    ): Unit {
      writer.name("id")
      StringAdapter.toJson(writer, customScalarAdapters, value.id)

      writer.name("handle")
      StringAdapter.toJson(writer, customScalarAdapters, value.handle)

      writer.name("owner")
      Owner.obj().toJson(writer, customScalarAdapters, value.owner)

      writer.name("headline")
      Headline.obj().toJson(writer, customScalarAdapters, value.headline)

      writer.name("displayName")
      DisplayName.obj().toJson(writer, customScalarAdapters, value.displayName)

      writer.name("profilePicture")
      ProfilePicture.obj().toJson(writer, customScalarAdapters, value.profilePicture)

      writer.name("connectStatus")
      ConnectStatus_ResponseAdapter.toJson(writer, customScalarAdapters, value.connectStatus)

      writer.name("connectionDegree")
      ConnectionDegree_ResponseAdapter.toJson(writer, customScalarAdapters, value.connectionDegree)

      writer.name("reputation")
      Reputation.obj().toJson(writer, customScalarAdapters, value.reputation)

      writer.name("isVerified")
      BooleanAdapter.toJson(writer, customScalarAdapters, value.isVerified)

      writer.name("mutualConnections")
      MutualConnections.obj().toJson(writer, customScalarAdapters, value.mutualConnections)
    }
  }

  public object Owner : Adapter<com.cyberconnect.link3.fragment.ConnectionPersonalProfile.Owner> {
    public val RESPONSE_NAMES: kotlin.collections.List<String> = listOf("id", "price", "lightInfo")

    public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
        com.cyberconnect.link3.fragment.ConnectionPersonalProfile.Owner {
      var _id: String? = null
      var _price: com.cyberconnect.link3.fragment.ConnectionPersonalProfile.Price? = null
      var _lightInfo: com.cyberconnect.link3.fragment.ConnectionPersonalProfile.LightInfo? = null

      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> _id = StringAdapter.fromJson(reader, customScalarAdapters)
          1 -> _price = Price.obj().fromJson(reader, customScalarAdapters)
          2 -> _lightInfo = LightInfo.obj().fromJson(reader, customScalarAdapters)
          else -> break
        }
      }

      return com.cyberconnect.link3.fragment.ConnectionPersonalProfile.Owner(
        id = _id!!,
        price = _price!!,
        lightInfo = _lightInfo!!
      )
    }

    public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: com.cyberconnect.link3.fragment.ConnectionPersonalProfile.Owner,
    ): Unit {
      writer.name("id")
      StringAdapter.toJson(writer, customScalarAdapters, value.id)

      writer.name("price")
      Price.obj().toJson(writer, customScalarAdapters, value.price)

      writer.name("lightInfo")
      LightInfo.obj().toJson(writer, customScalarAdapters, value.lightInfo)
    }
  }

  public object Price : Adapter<com.cyberconnect.link3.fragment.ConnectionPersonalProfile.Price> {
    public val RESPONSE_NAMES: kotlin.collections.List<String> = listOf("price")

    public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
        com.cyberconnect.link3.fragment.ConnectionPersonalProfile.Price {
      var _price: com.cyberconnect.link3.fragment.ConnectionPersonalProfile.Price1? = null

      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> _price = Price1.obj().fromJson(reader, customScalarAdapters)
          else -> break
        }
      }

      return com.cyberconnect.link3.fragment.ConnectionPersonalProfile.Price(
        price = _price!!
      )
    }

    public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: com.cyberconnect.link3.fragment.ConnectionPersonalProfile.Price,
    ): Unit {
      writer.name("price")
      Price1.obj().toJson(writer, customScalarAdapters, value.price)
    }
  }

  public object Price1 : Adapter<com.cyberconnect.link3.fragment.ConnectionPersonalProfile.Price1> {
    public val RESPONSE_NAMES: kotlin.collections.List<String> = listOf("value", "decimal")

    public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
        com.cyberconnect.link3.fragment.ConnectionPersonalProfile.Price1 {
      var _value: String? = null
      var _decimal: Int? = null

      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> _value = StringAdapter.fromJson(reader, customScalarAdapters)
          1 -> _decimal = IntAdapter.fromJson(reader, customScalarAdapters)
          else -> break
        }
      }

      return com.cyberconnect.link3.fragment.ConnectionPersonalProfile.Price1(
        `value` = _value!!,
        decimal = _decimal!!
      )
    }

    public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: com.cyberconnect.link3.fragment.ConnectionPersonalProfile.Price1,
    ): Unit {
      writer.name("value")
      StringAdapter.toJson(writer, customScalarAdapters, value.`value`)

      writer.name("decimal")
      IntAdapter.toJson(writer, customScalarAdapters, value.decimal)
    }
  }

  public object LightInfo :
      Adapter<com.cyberconnect.link3.fragment.ConnectionPersonalProfile.LightInfo> {
    public val RESPONSE_NAMES: kotlin.collections.List<String> = listOf("attestation")

    public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
        com.cyberconnect.link3.fragment.ConnectionPersonalProfile.LightInfo {
      var _attestation: com.cyberconnect.link3.fragment.ConnectionPersonalProfile.Attestation? = null

      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> _attestation = Attestation.obj().nullable().fromJson(reader, customScalarAdapters)
          else -> break
        }
      }

      return com.cyberconnect.link3.fragment.ConnectionPersonalProfile.LightInfo(
        attestation = _attestation
      )
    }

    public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: com.cyberconnect.link3.fragment.ConnectionPersonalProfile.LightInfo,
    ): Unit {
      writer.name("attestation")
      Attestation.obj().nullable().toJson(writer, customScalarAdapters, value.attestation)
    }
  }

  public object Attestation :
      Adapter<com.cyberconnect.link3.fragment.ConnectionPersonalProfile.Attestation> {
    public val RESPONSE_NAMES: kotlin.collections.List<String> = listOf("uid")

    public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
        com.cyberconnect.link3.fragment.ConnectionPersonalProfile.Attestation {
      var _uid: String? = null

      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> _uid = StringAdapter.fromJson(reader, customScalarAdapters)
          else -> break
        }
      }

      return com.cyberconnect.link3.fragment.ConnectionPersonalProfile.Attestation(
        uid = _uid!!
      )
    }

    public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: com.cyberconnect.link3.fragment.ConnectionPersonalProfile.Attestation,
    ): Unit {
      writer.name("uid")
      StringAdapter.toJson(writer, customScalarAdapters, value.uid)
    }
  }

  public object Headline :
      Adapter<com.cyberconnect.link3.fragment.ConnectionPersonalProfile.Headline> {
    public val RESPONSE_NAMES: kotlin.collections.List<String> = listOf("displayName", "title")

    public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
        com.cyberconnect.link3.fragment.ConnectionPersonalProfile.Headline {
      var _displayName: String? = null
      var _title: String? = null

      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> _displayName = StringAdapter.fromJson(reader, customScalarAdapters)
          1 -> _title = StringAdapter.fromJson(reader, customScalarAdapters)
          else -> break
        }
      }

      return com.cyberconnect.link3.fragment.ConnectionPersonalProfile.Headline(
        displayName = _displayName!!,
        title = _title!!
      )
    }

    public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: com.cyberconnect.link3.fragment.ConnectionPersonalProfile.Headline,
    ): Unit {
      writer.name("displayName")
      StringAdapter.toJson(writer, customScalarAdapters, value.displayName)

      writer.name("title")
      StringAdapter.toJson(writer, customScalarAdapters, value.title)
    }
  }

  public object DisplayName :
      Adapter<com.cyberconnect.link3.fragment.ConnectionPersonalProfile.DisplayName> {
    public val RESPONSE_NAMES: kotlin.collections.List<String> = listOf("displayName", "type")

    public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
        com.cyberconnect.link3.fragment.ConnectionPersonalProfile.DisplayName {
      var _displayName: String? = null
      var _type: PersonalDisplayName_Type? = null

      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> _displayName = StringAdapter.fromJson(reader, customScalarAdapters)
          1 -> _type = PersonalDisplayName_Type_ResponseAdapter.fromJson(reader,
              customScalarAdapters)
          else -> break
        }
      }

      return com.cyberconnect.link3.fragment.ConnectionPersonalProfile.DisplayName(
        displayName = _displayName!!,
        type = _type!!
      )
    }

    public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: com.cyberconnect.link3.fragment.ConnectionPersonalProfile.DisplayName,
    ): Unit {
      writer.name("displayName")
      StringAdapter.toJson(writer, customScalarAdapters, value.displayName)

      writer.name("type")
      PersonalDisplayName_Type_ResponseAdapter.toJson(writer, customScalarAdapters, value.type)
    }
  }

  public object ProfilePicture :
      Adapter<com.cyberconnect.link3.fragment.ConnectionPersonalProfile.ProfilePicture> {
    public val RESPONSE_NAMES: kotlin.collections.List<String> = listOf("picture")

    public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
        com.cyberconnect.link3.fragment.ConnectionPersonalProfile.ProfilePicture {
      var _picture: String? = null

      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> _picture = NullableStringAdapter.fromJson(reader, customScalarAdapters)
          else -> break
        }
      }

      return com.cyberconnect.link3.fragment.ConnectionPersonalProfile.ProfilePicture(
        picture = _picture
      )
    }

    public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: com.cyberconnect.link3.fragment.ConnectionPersonalProfile.ProfilePicture,
    ): Unit {
      writer.name("picture")
      NullableStringAdapter.toJson(writer, customScalarAdapters, value.picture)
    }
  }

  public object Reputation :
      Adapter<com.cyberconnect.link3.fragment.ConnectionPersonalProfile.Reputation> {
    public val RESPONSE_NAMES: kotlin.collections.List<String> = listOf("total")

    public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
        com.cyberconnect.link3.fragment.ConnectionPersonalProfile.Reputation {
      var _total: Int? = null

      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> _total = IntAdapter.fromJson(reader, customScalarAdapters)
          else -> break
        }
      }

      return com.cyberconnect.link3.fragment.ConnectionPersonalProfile.Reputation(
        total = _total!!
      )
    }

    public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: com.cyberconnect.link3.fragment.ConnectionPersonalProfile.Reputation,
    ): Unit {
      writer.name("total")
      IntAdapter.toJson(writer, customScalarAdapters, value.total)
    }
  }

  public object MutualConnections :
      Adapter<com.cyberconnect.link3.fragment.ConnectionPersonalProfile.MutualConnections> {
    public val RESPONSE_NAMES: kotlin.collections.List<String> = listOf("list")

    public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
        com.cyberconnect.link3.fragment.ConnectionPersonalProfile.MutualConnections {
      var _list: kotlin.collections.List<com.cyberconnect.link3.fragment.ConnectionPersonalProfile.List>? = null

      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> _list = List.obj(true).list().fromJson(reader, customScalarAdapters)
          else -> break
        }
      }

      return com.cyberconnect.link3.fragment.ConnectionPersonalProfile.MutualConnections(
        list = _list!!
      )
    }

    public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: com.cyberconnect.link3.fragment.ConnectionPersonalProfile.MutualConnections,
    ): Unit {
      writer.name("list")
      List.obj(true).list().toJson(writer, customScalarAdapters, value.list)
    }
  }

  public object List : Adapter<com.cyberconnect.link3.fragment.ConnectionPersonalProfile.List> {
    public val RESPONSE_NAMES: kotlin.collections.List<String> = listOf("__typename", "handle",
        "id")

    public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
        com.cyberconnect.link3.fragment.ConnectionPersonalProfile.List {
      var __typename: String? = null
      var _handle: String? = null
      var _id: String? = null

      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> __typename = StringAdapter.fromJson(reader, customScalarAdapters)
          1 -> _handle = StringAdapter.fromJson(reader, customScalarAdapters)
          2 -> _id = StringAdapter.fromJson(reader, customScalarAdapters)
          else -> break
        }
      }

      check(__typename != null) {
        "__typename was not found"
      }

      var _onPerProfile: com.cyberconnect.link3.fragment.ConnectionPersonalProfile.OnPerProfile? = null
      if (possibleTypes("PerProfile").evaluate(customScalarAdapters.adapterContext.variables(), __typename, customScalarAdapters.adapterContext, null)) {
        reader.rewind()
        _onPerProfile = com.cyberconnect.link3.fragment.ConnectionPersonalProfileImpl_ResponseAdapter.OnPerProfile.fromJson(reader,
            customScalarAdapters)
      }

      return com.cyberconnect.link3.fragment.ConnectionPersonalProfile.List(
        __typename = __typename,
        handle = _handle!!,
        id = _id!!,
        onPerProfile = _onPerProfile
      )
    }

    public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: com.cyberconnect.link3.fragment.ConnectionPersonalProfile.List,
    ): Unit {
      writer.name("__typename")
      StringAdapter.toJson(writer, customScalarAdapters, value.__typename)

      writer.name("handle")
      StringAdapter.toJson(writer, customScalarAdapters, value.handle)

      writer.name("id")
      StringAdapter.toJson(writer, customScalarAdapters, value.id)

      if (value.onPerProfile != null) {
        com.cyberconnect.link3.fragment.ConnectionPersonalProfileImpl_ResponseAdapter.OnPerProfile.toJson(writer,
            customScalarAdapters, value.onPerProfile)
      }
    }
  }

  public object OnPerProfile :
      Adapter<com.cyberconnect.link3.fragment.ConnectionPersonalProfile.OnPerProfile> {
    public val RESPONSE_NAMES: kotlin.collections.List<String> = listOf("profilePicture",
        "displayName")

    public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
        com.cyberconnect.link3.fragment.ConnectionPersonalProfile.OnPerProfile {
      var _profilePicture: com.cyberconnect.link3.fragment.ConnectionPersonalProfile.ProfilePicture1? = null
      var _displayName: com.cyberconnect.link3.fragment.ConnectionPersonalProfile.DisplayName1? = null

      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> _profilePicture = ProfilePicture1.obj().fromJson(reader, customScalarAdapters)
          1 -> _displayName = DisplayName1.obj().fromJson(reader, customScalarAdapters)
          else -> break
        }
      }

      return com.cyberconnect.link3.fragment.ConnectionPersonalProfile.OnPerProfile(
        profilePicture = _profilePicture!!,
        displayName = _displayName!!
      )
    }

    public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: com.cyberconnect.link3.fragment.ConnectionPersonalProfile.OnPerProfile,
    ): Unit {
      writer.name("profilePicture")
      ProfilePicture1.obj().toJson(writer, customScalarAdapters, value.profilePicture)

      writer.name("displayName")
      DisplayName1.obj().toJson(writer, customScalarAdapters, value.displayName)
    }
  }

  public object ProfilePicture1 :
      Adapter<com.cyberconnect.link3.fragment.ConnectionPersonalProfile.ProfilePicture1> {
    public val RESPONSE_NAMES: kotlin.collections.List<String> = listOf("picture")

    public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
        com.cyberconnect.link3.fragment.ConnectionPersonalProfile.ProfilePicture1 {
      var _picture: String? = null

      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> _picture = NullableStringAdapter.fromJson(reader, customScalarAdapters)
          else -> break
        }
      }

      return com.cyberconnect.link3.fragment.ConnectionPersonalProfile.ProfilePicture1(
        picture = _picture
      )
    }

    public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: com.cyberconnect.link3.fragment.ConnectionPersonalProfile.ProfilePicture1,
    ): Unit {
      writer.name("picture")
      NullableStringAdapter.toJson(writer, customScalarAdapters, value.picture)
    }
  }

  public object DisplayName1 :
      Adapter<com.cyberconnect.link3.fragment.ConnectionPersonalProfile.DisplayName1> {
    public val RESPONSE_NAMES: kotlin.collections.List<String> = listOf("displayName")

    public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
        com.cyberconnect.link3.fragment.ConnectionPersonalProfile.DisplayName1 {
      var _displayName: String? = null

      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> _displayName = StringAdapter.fromJson(reader, customScalarAdapters)
          else -> break
        }
      }

      return com.cyberconnect.link3.fragment.ConnectionPersonalProfile.DisplayName1(
        displayName = _displayName!!
      )
    }

    public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: com.cyberconnect.link3.fragment.ConnectionPersonalProfile.DisplayName1,
    ): Unit {
      writer.name("displayName")
      StringAdapter.toJson(writer, customScalarAdapters, value.displayName)
    }
  }
}
