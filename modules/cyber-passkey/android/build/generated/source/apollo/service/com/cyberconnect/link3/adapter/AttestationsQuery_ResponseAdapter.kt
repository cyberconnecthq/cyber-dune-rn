//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.2'.
//
package com.cyberconnect.link3.adapter

import com.apollographql.apollo3.api.Adapter
import com.apollographql.apollo3.api.BooleanAdapter
import com.apollographql.apollo3.api.CustomScalarAdapters
import com.apollographql.apollo3.api.IntAdapter
import com.apollographql.apollo3.api.StringAdapter
import com.apollographql.apollo3.api.json.JsonReader
import com.apollographql.apollo3.api.json.JsonWriter
import com.apollographql.apollo3.api.nullable
import com.apollographql.apollo3.api.obj
import com.cyberconnect.link3.AttestationsQuery
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.Unit
import kotlin.collections.List

public object AttestationsQuery_ResponseAdapter {
  public object Data : Adapter<AttestationsQuery.Data> {
    public val RESPONSE_NAMES: List<String> = listOf("getAttestation")

    public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
        AttestationsQuery.Data {
      var _getAttestation: AttestationsQuery.GetAttestation? = null

      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> _getAttestation = GetAttestation.obj().nullable().fromJson(reader,
              customScalarAdapters)
          else -> break
        }
      }

      return AttestationsQuery.Data(
        getAttestation = _getAttestation
      )
    }

    public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: AttestationsQuery.Data,
    ): Unit {
      writer.name("getAttestation")
      GetAttestation.obj().nullable().toJson(writer, customScalarAdapters, value.getAttestation)
    }
  }

  public object GetAttestation : Adapter<AttestationsQuery.GetAttestation> {
    public val RESPONSE_NAMES: List<String> = listOf("id", "revoked", "recipient", "attester",
        "decodedDataJson", "timeCreated", "refUID")

    public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
        AttestationsQuery.GetAttestation {
      var _id: String? = null
      var _revoked: Boolean? = null
      var _recipient: String? = null
      var _attester: String? = null
      var _decodedDataJson: String? = null
      var _timeCreated: Int? = null
      var _refUID: String? = null

      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> _id = StringAdapter.fromJson(reader, customScalarAdapters)
          1 -> _revoked = BooleanAdapter.fromJson(reader, customScalarAdapters)
          2 -> _recipient = StringAdapter.fromJson(reader, customScalarAdapters)
          3 -> _attester = StringAdapter.fromJson(reader, customScalarAdapters)
          4 -> _decodedDataJson = StringAdapter.fromJson(reader, customScalarAdapters)
          5 -> _timeCreated = IntAdapter.fromJson(reader, customScalarAdapters)
          6 -> _refUID = StringAdapter.fromJson(reader, customScalarAdapters)
          else -> break
        }
      }

      return AttestationsQuery.GetAttestation(
        id = _id!!,
        revoked = _revoked!!,
        recipient = _recipient!!,
        attester = _attester!!,
        decodedDataJson = _decodedDataJson!!,
        timeCreated = _timeCreated!!,
        refUID = _refUID!!
      )
    }

    public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: AttestationsQuery.GetAttestation,
    ): Unit {
      writer.name("id")
      StringAdapter.toJson(writer, customScalarAdapters, value.id)

      writer.name("revoked")
      BooleanAdapter.toJson(writer, customScalarAdapters, value.revoked)

      writer.name("recipient")
      StringAdapter.toJson(writer, customScalarAdapters, value.recipient)

      writer.name("attester")
      StringAdapter.toJson(writer, customScalarAdapters, value.attester)

      writer.name("decodedDataJson")
      StringAdapter.toJson(writer, customScalarAdapters, value.decodedDataJson)

      writer.name("timeCreated")
      IntAdapter.toJson(writer, customScalarAdapters, value.timeCreated)

      writer.name("refUID")
      StringAdapter.toJson(writer, customScalarAdapters, value.refUID)
    }
  }
}