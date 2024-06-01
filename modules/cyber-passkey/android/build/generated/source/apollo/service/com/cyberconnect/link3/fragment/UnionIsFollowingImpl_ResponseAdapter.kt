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
import com.apollographql.apollo3.api.evaluate
import com.apollographql.apollo3.api.json.JsonReader
import com.apollographql.apollo3.api.json.JsonWriter
import com.apollographql.apollo3.api.possibleTypes
import kotlin.Boolean
import kotlin.String
import kotlin.Unit
import kotlin.collections.List

public object UnionIsFollowingImpl_ResponseAdapter {
  public object UnionIsFollowing : Adapter<com.cyberconnect.link3.fragment.UnionIsFollowing> {
    public val RESPONSE_NAMES: List<String> = listOf("__typename")

    public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
        com.cyberconnect.link3.fragment.UnionIsFollowing {
      var __typename: String? = null

      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> __typename = StringAdapter.fromJson(reader, customScalarAdapters)
          else -> break
        }
      }

      check(__typename != null) {
        "__typename was not found"
      }

      var _onOrgProfile: com.cyberconnect.link3.fragment.UnionIsFollowing.OnOrgProfile? = null
      if (possibleTypes("OrgProfile").evaluate(customScalarAdapters.adapterContext.variables(), __typename, customScalarAdapters.adapterContext, null)) {
        reader.rewind()
        _onOrgProfile = com.cyberconnect.link3.fragment.UnionIsFollowingImpl_ResponseAdapter.OnOrgProfile.fromJson(reader,
            customScalarAdapters)
      }

      var _onPerProfile: com.cyberconnect.link3.fragment.UnionIsFollowing.OnPerProfile? = null
      if (possibleTypes("PerProfile").evaluate(customScalarAdapters.adapterContext.variables(), __typename, customScalarAdapters.adapterContext, null)) {
        reader.rewind()
        _onPerProfile = com.cyberconnect.link3.fragment.UnionIsFollowingImpl_ResponseAdapter.OnPerProfile.fromJson(reader,
            customScalarAdapters)
      }

      return com.cyberconnect.link3.fragment.UnionIsFollowing(
        __typename = __typename,
        onOrgProfile = _onOrgProfile,
        onPerProfile = _onPerProfile
      )
    }

    public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: com.cyberconnect.link3.fragment.UnionIsFollowing,
    ): Unit {
      writer.name("__typename")
      StringAdapter.toJson(writer, customScalarAdapters, value.__typename)

      if (value.onOrgProfile != null) {
        com.cyberconnect.link3.fragment.UnionIsFollowingImpl_ResponseAdapter.OnOrgProfile.toJson(writer,
            customScalarAdapters, value.onOrgProfile)
      }

      if (value.onPerProfile != null) {
        com.cyberconnect.link3.fragment.UnionIsFollowingImpl_ResponseAdapter.OnPerProfile.toJson(writer,
            customScalarAdapters, value.onPerProfile)
      }
    }
  }

  public object OnOrgProfile :
      Adapter<com.cyberconnect.link3.fragment.UnionIsFollowing.OnOrgProfile> {
    public val RESPONSE_NAMES: List<String> = listOf("isFollowing")

    public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
        com.cyberconnect.link3.fragment.UnionIsFollowing.OnOrgProfile {
      var _isFollowing: Boolean? = null

      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> _isFollowing = BooleanAdapter.fromJson(reader, customScalarAdapters)
          else -> break
        }
      }

      return com.cyberconnect.link3.fragment.UnionIsFollowing.OnOrgProfile(
        isFollowing = _isFollowing!!
      )
    }

    public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: com.cyberconnect.link3.fragment.UnionIsFollowing.OnOrgProfile,
    ): Unit {
      writer.name("isFollowing")
      BooleanAdapter.toJson(writer, customScalarAdapters, value.isFollowing)
    }
  }

  public object OnPerProfile :
      Adapter<com.cyberconnect.link3.fragment.UnionIsFollowing.OnPerProfile> {
    public val RESPONSE_NAMES: List<String> = listOf("isFollowing")

    public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
        com.cyberconnect.link3.fragment.UnionIsFollowing.OnPerProfile {
      var _isFollowing: Boolean? = null

      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> _isFollowing = BooleanAdapter.fromJson(reader, customScalarAdapters)
          else -> break
        }
      }

      return com.cyberconnect.link3.fragment.UnionIsFollowing.OnPerProfile(
        isFollowing = _isFollowing!!
      )
    }

    public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: com.cyberconnect.link3.fragment.UnionIsFollowing.OnPerProfile,
    ): Unit {
      writer.name("isFollowing")
      BooleanAdapter.toJson(writer, customScalarAdapters, value.isFollowing)
    }
  }
}
