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
import com.cyberconnect.link3.AttestationStatusQuery
import com.cyberconnect.link3.type.Attestation_Status
import com.cyberconnect.link3.type.MeResponse_Status
import com.cyberconnect.link3.type.adapter.Attestation_Status_ResponseAdapter
import com.cyberconnect.link3.type.adapter.MeResponse_Status_ResponseAdapter
import kotlin.String
import kotlin.Unit
import kotlin.collections.List

public object AttestationStatusQuery_ResponseAdapter {
  public object Data : Adapter<AttestationStatusQuery.Data> {
    public val RESPONSE_NAMES: List<String> = listOf("me")

    public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
        AttestationStatusQuery.Data {
      var _me: AttestationStatusQuery.Me? = null

      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> _me = Me.obj().fromJson(reader, customScalarAdapters)
          else -> break
        }
      }

      return AttestationStatusQuery.Data(
        me = _me!!
      )
    }

    public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: AttestationStatusQuery.Data,
    ): Unit {
      writer.name("me")
      Me.obj().toJson(writer, customScalarAdapters, value.me)
    }
  }

  public object Me : Adapter<AttestationStatusQuery.Me> {
    public val RESPONSE_NAMES: List<String> = listOf("status", "message", "data")

    public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
        AttestationStatusQuery.Me {
      var _status: MeResponse_Status? = null
      var _message: String? = null
      var _data: AttestationStatusQuery.Data1? = null

      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> _status = MeResponse_Status_ResponseAdapter.fromJson(reader, customScalarAdapters)
          1 -> _message = StringAdapter.fromJson(reader, customScalarAdapters)
          2 -> _data = Data1.obj().nullable().fromJson(reader, customScalarAdapters)
          else -> break
        }
      }

      return AttestationStatusQuery.Me(
        status = _status!!,
        message = _message!!,
        `data` = _data
      )
    }

    public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: AttestationStatusQuery.Me,
    ): Unit {
      writer.name("status")
      MeResponse_Status_ResponseAdapter.toJson(writer, customScalarAdapters, value.status)

      writer.name("message")
      StringAdapter.toJson(writer, customScalarAdapters, value.message)

      writer.name("data")
      Data1.obj().nullable().toJson(writer, customScalarAdapters, value.`data`)
    }
  }

  public object Data1 : Adapter<AttestationStatusQuery.Data1> {
    public val RESPONSE_NAMES: List<String> = listOf("lightInfo")

    public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
        AttestationStatusQuery.Data1 {
      var _lightInfo: AttestationStatusQuery.LightInfo? = null

      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> _lightInfo = LightInfo.obj().fromJson(reader, customScalarAdapters)
          else -> break
        }
      }

      return AttestationStatusQuery.Data1(
        lightInfo = _lightInfo!!
      )
    }

    public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: AttestationStatusQuery.Data1,
    ): Unit {
      writer.name("lightInfo")
      LightInfo.obj().toJson(writer, customScalarAdapters, value.lightInfo)
    }
  }

  public object LightInfo : Adapter<AttestationStatusQuery.LightInfo> {
    public val RESPONSE_NAMES: List<String> = listOf("attestation")

    public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
        AttestationStatusQuery.LightInfo {
      var _attestation: AttestationStatusQuery.Attestation? = null

      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> _attestation = Attestation.obj().nullable().fromJson(reader, customScalarAdapters)
          else -> break
        }
      }

      return AttestationStatusQuery.LightInfo(
        attestation = _attestation
      )
    }

    public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: AttestationStatusQuery.LightInfo,
    ): Unit {
      writer.name("attestation")
      Attestation.obj().nullable().toJson(writer, customScalarAdapters, value.attestation)
    }
  }

  public object Attestation : Adapter<AttestationStatusQuery.Attestation> {
    public val RESPONSE_NAMES: List<String> = listOf("status", "uid")

    public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
        AttestationStatusQuery.Attestation {
      var _status: Attestation_Status? = null
      var _uid: String? = null

      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> _status = Attestation_Status_ResponseAdapter.fromJson(reader, customScalarAdapters)
          1 -> _uid = StringAdapter.fromJson(reader, customScalarAdapters)
          else -> break
        }
      }

      return AttestationStatusQuery.Attestation(
        status = _status!!,
        uid = _uid!!
      )
    }

    public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: AttestationStatusQuery.Attestation,
    ): Unit {
      writer.name("status")
      Attestation_Status_ResponseAdapter.toJson(writer, customScalarAdapters, value.status)

      writer.name("uid")
      StringAdapter.toJson(writer, customScalarAdapters, value.uid)
    }
  }
}
