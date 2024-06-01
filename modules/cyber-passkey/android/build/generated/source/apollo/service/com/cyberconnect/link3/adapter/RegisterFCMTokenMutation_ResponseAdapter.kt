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
import com.cyberconnect.link3.RegisterFCMTokenMutation
import com.cyberconnect.link3.type.RegisterFCMTokenResponse_Status
import com.cyberconnect.link3.type.adapter.RegisterFCMTokenResponse_Status_ResponseAdapter
import kotlin.String
import kotlin.Unit
import kotlin.collections.List

public object RegisterFCMTokenMutation_ResponseAdapter {
  public object Data : Adapter<RegisterFCMTokenMutation.Data> {
    public val RESPONSE_NAMES: List<String> = listOf("registerFCMToken")

    public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
        RegisterFCMTokenMutation.Data {
      var _registerFCMToken: RegisterFCMTokenMutation.RegisterFCMToken? = null

      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> _registerFCMToken = RegisterFCMToken.obj().fromJson(reader, customScalarAdapters)
          else -> break
        }
      }

      return RegisterFCMTokenMutation.Data(
        registerFCMToken = _registerFCMToken!!
      )
    }

    public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: RegisterFCMTokenMutation.Data,
    ): Unit {
      writer.name("registerFCMToken")
      RegisterFCMToken.obj().toJson(writer, customScalarAdapters, value.registerFCMToken)
    }
  }

  public object RegisterFCMToken : Adapter<RegisterFCMTokenMutation.RegisterFCMToken> {
    public val RESPONSE_NAMES: List<String> = listOf("status")

    public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
        RegisterFCMTokenMutation.RegisterFCMToken {
      var _status: RegisterFCMTokenResponse_Status? = null

      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> _status = RegisterFCMTokenResponse_Status_ResponseAdapter.fromJson(reader,
              customScalarAdapters)
          else -> break
        }
      }

      return RegisterFCMTokenMutation.RegisterFCMToken(
        status = _status!!
      )
    }

    public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: RegisterFCMTokenMutation.RegisterFCMToken,
    ): Unit {
      writer.name("status")
      RegisterFCMTokenResponse_Status_ResponseAdapter.toJson(writer, customScalarAdapters,
          value.status)
    }
  }
}