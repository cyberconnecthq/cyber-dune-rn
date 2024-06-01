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
import com.cyberconnect.link3.TurnkeyUserRegisterMutation
import com.cyberconnect.link3.type.RegisterTurnkeyUserResponse_Status
import com.cyberconnect.link3.type.adapter.RegisterTurnkeyUserResponse_Status_ResponseAdapter
import kotlin.String
import kotlin.Unit
import kotlin.collections.List

public object TurnkeyUserRegisterMutation_ResponseAdapter {
  public object Data : Adapter<TurnkeyUserRegisterMutation.Data> {
    public val RESPONSE_NAMES: List<String> = listOf("turnkeyUserRegister")

    public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
        TurnkeyUserRegisterMutation.Data {
      var _turnkeyUserRegister: TurnkeyUserRegisterMutation.TurnkeyUserRegister? = null

      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> _turnkeyUserRegister = TurnkeyUserRegister.obj().fromJson(reader,
              customScalarAdapters)
          else -> break
        }
      }

      return TurnkeyUserRegisterMutation.Data(
        turnkeyUserRegister = _turnkeyUserRegister!!
      )
    }

    public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: TurnkeyUserRegisterMutation.Data,
    ): Unit {
      writer.name("turnkeyUserRegister")
      TurnkeyUserRegister.obj().toJson(writer, customScalarAdapters, value.turnkeyUserRegister)
    }
  }

  public object TurnkeyUserRegister : Adapter<TurnkeyUserRegisterMutation.TurnkeyUserRegister> {
    public val RESPONSE_NAMES: List<String> = listOf("status")

    public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
        TurnkeyUserRegisterMutation.TurnkeyUserRegister {
      var _status: RegisterTurnkeyUserResponse_Status? = null

      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> _status = RegisterTurnkeyUserResponse_Status_ResponseAdapter.fromJson(reader,
              customScalarAdapters)
          else -> break
        }
      }

      return TurnkeyUserRegisterMutation.TurnkeyUserRegister(
        status = _status!!
      )
    }

    public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: TurnkeyUserRegisterMutation.TurnkeyUserRegister,
    ): Unit {
      writer.name("status")
      RegisterTurnkeyUserResponse_Status_ResponseAdapter.toJson(writer, customScalarAdapters,
          value.status)
    }
  }
}