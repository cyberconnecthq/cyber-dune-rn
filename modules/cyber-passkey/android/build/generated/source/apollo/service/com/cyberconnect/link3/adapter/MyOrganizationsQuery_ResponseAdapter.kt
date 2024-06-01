//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.2'.
//
package com.cyberconnect.link3.adapter

import com.apollographql.apollo3.api.Adapter
import com.apollographql.apollo3.api.CustomScalarAdapters
import com.apollographql.apollo3.api.StringAdapter
import com.apollographql.apollo3.api.evaluate
import com.apollographql.apollo3.api.json.JsonReader
import com.apollographql.apollo3.api.json.JsonWriter
import com.apollographql.apollo3.api.list
import com.apollographql.apollo3.api.nullable
import com.apollographql.apollo3.api.obj
import com.apollographql.apollo3.api.possibleTypes
import com.cyberconnect.link3.MyOrganizationsQuery
import com.cyberconnect.link3.fragment.FollowingOrgs
import com.cyberconnect.link3.type.MeResponse_Status
import com.cyberconnect.link3.type.adapter.MeResponse_Status_ResponseAdapter
import kotlin.String
import kotlin.Unit
import kotlin.collections.List

public object MyOrganizationsQuery_ResponseAdapter {
  public object Data : Adapter<MyOrganizationsQuery.Data> {
    public val RESPONSE_NAMES: List<String> = listOf("me")

    public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
        MyOrganizationsQuery.Data {
      var _me: MyOrganizationsQuery.Me? = null

      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> _me = Me.obj().fromJson(reader, customScalarAdapters)
          else -> break
        }
      }

      return MyOrganizationsQuery.Data(
        me = _me!!
      )
    }

    public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: MyOrganizationsQuery.Data,
    ): Unit {
      writer.name("me")
      Me.obj().toJson(writer, customScalarAdapters, value.me)
    }
  }

  public object Me : Adapter<MyOrganizationsQuery.Me> {
    public val RESPONSE_NAMES: List<String> = listOf("status", "message", "data")

    public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
        MyOrganizationsQuery.Me {
      var _status: MeResponse_Status? = null
      var _message: String? = null
      var _data: MyOrganizationsQuery.Data1? = null

      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> _status = MeResponse_Status_ResponseAdapter.fromJson(reader, customScalarAdapters)
          1 -> _message = StringAdapter.fromJson(reader, customScalarAdapters)
          2 -> _data = Data1.obj().nullable().fromJson(reader, customScalarAdapters)
          else -> break
        }
      }

      return MyOrganizationsQuery.Me(
        status = _status!!,
        message = _message!!,
        `data` = _data
      )
    }

    public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: MyOrganizationsQuery.Me,
    ): Unit {
      writer.name("status")
      MeResponse_Status_ResponseAdapter.toJson(writer, customScalarAdapters, value.status)

      writer.name("message")
      StringAdapter.toJson(writer, customScalarAdapters, value.message)

      writer.name("data")
      Data1.obj().nullable().toJson(writer, customScalarAdapters, value.`data`)
    }
  }

  public object Data1 : Adapter<MyOrganizationsQuery.Data1> {
    public val RESPONSE_NAMES: List<String> = listOf("organizations")

    public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
        MyOrganizationsQuery.Data1 {
      var _organizations: List<MyOrganizationsQuery.Organization>? = null

      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> _organizations = Organization.obj().list().nullable().fromJson(reader,
              customScalarAdapters)
          else -> break
        }
      }

      return MyOrganizationsQuery.Data1(
        organizations = _organizations
      )
    }

    public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: MyOrganizationsQuery.Data1,
    ): Unit {
      writer.name("organizations")
      Organization.obj().list().nullable().toJson(writer, customScalarAdapters, value.organizations)
    }
  }

  public object Organization : Adapter<MyOrganizationsQuery.Organization> {
    public val RESPONSE_NAMES: List<String> = listOf("profile")

    public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
        MyOrganizationsQuery.Organization {
      var _profile: MyOrganizationsQuery.Profile? = null

      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> _profile = Profile.obj(true).fromJson(reader, customScalarAdapters)
          else -> break
        }
      }

      return MyOrganizationsQuery.Organization(
        profile = _profile!!
      )
    }

    public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: MyOrganizationsQuery.Organization,
    ): Unit {
      writer.name("profile")
      Profile.obj(true).toJson(writer, customScalarAdapters, value.profile)
    }
  }

  public object Profile : Adapter<MyOrganizationsQuery.Profile> {
    public val RESPONSE_NAMES: List<String> = listOf("__typename")

    public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
        MyOrganizationsQuery.Profile {
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

      var _followingOrgs: FollowingOrgs? = null
      if (possibleTypes("OrgProfile").evaluate(customScalarAdapters.adapterContext.variables(), __typename, customScalarAdapters.adapterContext, null)) {
        reader.rewind()
        _followingOrgs = com.cyberconnect.link3.fragment.FollowingOrgsImpl_ResponseAdapter.FollowingOrgs.fromJson(reader,
            customScalarAdapters)
      }

      return MyOrganizationsQuery.Profile(
        __typename = __typename,
        followingOrgs = _followingOrgs
      )
    }

    public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: MyOrganizationsQuery.Profile,
    ): Unit {
      writer.name("__typename")
      StringAdapter.toJson(writer, customScalarAdapters, value.__typename)

      if (value.followingOrgs != null) {
        com.cyberconnect.link3.fragment.FollowingOrgsImpl_ResponseAdapter.FollowingOrgs.toJson(writer,
            customScalarAdapters, value.followingOrgs)
      }
    }
  }
}