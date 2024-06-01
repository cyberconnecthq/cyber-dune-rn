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
import com.apollographql.apollo3.api.StringAdapter
import com.apollographql.apollo3.api.json.JsonReader
import com.apollographql.apollo3.api.json.JsonWriter
import com.apollographql.apollo3.api.obj
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.Unit
import kotlin.collections.List

public object ConnectionOrgProfileImpl_ResponseAdapter {
  public object ConnectionOrgProfile : Adapter<com.cyberconnect.link3.fragment.ConnectionOrgProfile>
      {
    public val RESPONSE_NAMES: List<String> = listOf("id", "handle", "bio", "displayName",
        "profilePicture", "isFollowing", "organization")

    public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
        com.cyberconnect.link3.fragment.ConnectionOrgProfile {
      var _id: String? = null
      var _handle: String? = null
      var _bio: String? = null
      var _displayName: String? = null
      var _profilePicture: String? = null
      var _isFollowing: Boolean? = null
      var _organization: com.cyberconnect.link3.fragment.ConnectionOrgProfile.Organization? = null

      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> _id = StringAdapter.fromJson(reader, customScalarAdapters)
          1 -> _handle = StringAdapter.fromJson(reader, customScalarAdapters)
          2 -> _bio = StringAdapter.fromJson(reader, customScalarAdapters)
          3 -> _displayName = StringAdapter.fromJson(reader, customScalarAdapters)
          4 -> _profilePicture = StringAdapter.fromJson(reader, customScalarAdapters)
          5 -> _isFollowing = BooleanAdapter.fromJson(reader, customScalarAdapters)
          6 -> _organization = Organization.obj().fromJson(reader, customScalarAdapters)
          else -> break
        }
      }

      return com.cyberconnect.link3.fragment.ConnectionOrgProfile(
        id = _id!!,
        handle = _handle!!,
        bio = _bio!!,
        displayName = _displayName!!,
        profilePicture = _profilePicture!!,
        isFollowing = _isFollowing!!,
        organization = _organization!!
      )
    }

    public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: com.cyberconnect.link3.fragment.ConnectionOrgProfile,
    ): Unit {
      writer.name("id")
      StringAdapter.toJson(writer, customScalarAdapters, value.id)

      writer.name("handle")
      StringAdapter.toJson(writer, customScalarAdapters, value.handle)

      writer.name("bio")
      StringAdapter.toJson(writer, customScalarAdapters, value.bio)

      writer.name("displayName")
      StringAdapter.toJson(writer, customScalarAdapters, value.displayName)

      writer.name("profilePicture")
      StringAdapter.toJson(writer, customScalarAdapters, value.profilePicture)

      writer.name("isFollowing")
      BooleanAdapter.toJson(writer, customScalarAdapters, value.isFollowing)

      writer.name("organization")
      Organization.obj().toJson(writer, customScalarAdapters, value.organization)
    }
  }

  public object Organization :
      Adapter<com.cyberconnect.link3.fragment.ConnectionOrgProfile.Organization> {
    public val RESPONSE_NAMES: List<String> = listOf("followersCount")

    public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
        com.cyberconnect.link3.fragment.ConnectionOrgProfile.Organization {
      var _followersCount: Int? = null

      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> _followersCount = IntAdapter.fromJson(reader, customScalarAdapters)
          else -> break
        }
      }

      return com.cyberconnect.link3.fragment.ConnectionOrgProfile.Organization(
        followersCount = _followersCount!!
      )
    }

    public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: com.cyberconnect.link3.fragment.ConnectionOrgProfile.Organization,
    ): Unit {
      writer.name("followersCount")
      IntAdapter.toJson(writer, customScalarAdapters, value.followersCount)
    }
  }
}