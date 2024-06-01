//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.2'.
//
package com.cyberconnect.link3.fragment

import com.apollographql.apollo3.api.Adapter
import com.apollographql.apollo3.api.CustomScalarAdapters
import com.apollographql.apollo3.api.StringAdapter
import com.apollographql.apollo3.api.evaluate
import com.apollographql.apollo3.api.json.JsonReader
import com.apollographql.apollo3.api.json.JsonWriter
import com.apollographql.apollo3.api.list
import com.apollographql.apollo3.api.obj
import com.apollographql.apollo3.api.possibleTypes
import com.cyberconnect.link3.type.ProfileType
import com.cyberconnect.link3.type.adapter.ProfileType_ResponseAdapter
import kotlin.String
import kotlin.Unit
import kotlin.collections.List

public object ProfileImpl_ResponseAdapter {
  public object Profile : Adapter<com.cyberconnect.link3.fragment.Profile> {
    public val RESPONSE_NAMES: List<String> = listOf("__typename", "id", "handle", "type", "blocks")

    public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
        com.cyberconnect.link3.fragment.Profile {
      var __typename: String? = null
      var _id: String? = null
      var _handle: String? = null
      var _type: ProfileType? = null
      var _blocks: List<com.cyberconnect.link3.fragment.Profile.Block>? = null

      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> __typename = StringAdapter.fromJson(reader, customScalarAdapters)
          1 -> _id = StringAdapter.fromJson(reader, customScalarAdapters)
          2 -> _handle = StringAdapter.fromJson(reader, customScalarAdapters)
          3 -> _type = ProfileType_ResponseAdapter.fromJson(reader, customScalarAdapters)
          4 -> _blocks = Block.obj(true).list().fromJson(reader, customScalarAdapters)
          else -> break
        }
      }

      check(__typename != null) {
        "__typename was not found"
      }

      var _orgProfile: OrgProfile? = null
      if (possibleTypes("OrgProfile").evaluate(customScalarAdapters.adapterContext.variables(), __typename, customScalarAdapters.adapterContext, null)) {
        reader.rewind()
        _orgProfile = com.cyberconnect.link3.fragment.OrgProfileImpl_ResponseAdapter.OrgProfile.fromJson(reader,
            customScalarAdapters)
      }

      var _personalProfile: PersonalProfile? = null
      if (possibleTypes("PerProfile").evaluate(customScalarAdapters.adapterContext.variables(), __typename, customScalarAdapters.adapterContext, null)) {
        reader.rewind()
        _personalProfile = com.cyberconnect.link3.fragment.PersonalProfileImpl_ResponseAdapter.PersonalProfile.fromJson(reader,
            customScalarAdapters)
      }

      return com.cyberconnect.link3.fragment.Profile(
        __typename = __typename,
        id = _id!!,
        handle = _handle!!,
        type = _type!!,
        blocks = _blocks!!,
        orgProfile = _orgProfile,
        personalProfile = _personalProfile
      )
    }

    public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: com.cyberconnect.link3.fragment.Profile,
    ): Unit {
      writer.name("__typename")
      StringAdapter.toJson(writer, customScalarAdapters, value.__typename)

      writer.name("id")
      StringAdapter.toJson(writer, customScalarAdapters, value.id)

      writer.name("handle")
      StringAdapter.toJson(writer, customScalarAdapters, value.handle)

      writer.name("type")
      ProfileType_ResponseAdapter.toJson(writer, customScalarAdapters, value.type)

      writer.name("blocks")
      Block.obj(true).list().toJson(writer, customScalarAdapters, value.blocks)

      if (value.orgProfile != null) {
        com.cyberconnect.link3.fragment.OrgProfileImpl_ResponseAdapter.OrgProfile.toJson(writer,
            customScalarAdapters, value.orgProfile)
      }

      if (value.personalProfile != null) {
        com.cyberconnect.link3.fragment.PersonalProfileImpl_ResponseAdapter.PersonalProfile.toJson(writer,
            customScalarAdapters, value.personalProfile)
      }
    }
  }

  public object Block : Adapter<com.cyberconnect.link3.fragment.Profile.Block> {
    public val RESPONSE_NAMES: List<String> = listOf("__typename")

    public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
        com.cyberconnect.link3.fragment.Profile.Block {
      var __typename: String? = null

      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> __typename = StringAdapter.fromJson(reader, customScalarAdapters)
          else -> break
        }
      }

      reader.rewind()
      val _block = com.cyberconnect.link3.fragment.BlockImpl_ResponseAdapter.Block.fromJson(reader,
          customScalarAdapters)

      return com.cyberconnect.link3.fragment.Profile.Block(
        __typename = __typename!!,
        block = _block
      )
    }

    public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: com.cyberconnect.link3.fragment.Profile.Block,
    ): Unit {
      writer.name("__typename")
      StringAdapter.toJson(writer, customScalarAdapters, value.__typename)

      com.cyberconnect.link3.fragment.BlockImpl_ResponseAdapter.Block.toJson(writer,
          customScalarAdapters, value.block)
    }
  }
}
