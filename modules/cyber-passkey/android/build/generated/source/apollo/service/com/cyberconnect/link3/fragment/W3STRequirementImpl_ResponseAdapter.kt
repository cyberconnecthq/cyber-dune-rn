//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.2'.
//
package com.cyberconnect.link3.fragment

import com.apollographql.apollo3.api.Adapter
import com.apollographql.apollo3.api.CustomScalarAdapters
import com.apollographql.apollo3.api.NullableIntAdapter
import com.apollographql.apollo3.api.json.JsonReader
import com.apollographql.apollo3.api.json.JsonWriter
import com.cyberconnect.link3.type.W3STRequirementType
import com.cyberconnect.link3.type.adapter.W3STRequirementType_ResponseAdapter
import kotlin.Int
import kotlin.String
import kotlin.Unit
import kotlin.collections.List

public object W3STRequirementImpl_ResponseAdapter {
  public object W3STRequirement : Adapter<com.cyberconnect.link3.fragment.W3STRequirement> {
    public val RESPONSE_NAMES: List<String> = listOf("type", "value")

    public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
        com.cyberconnect.link3.fragment.W3STRequirement {
      var _type: W3STRequirementType? = null
      var _value: Int? = null

      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> _type = W3STRequirementType_ResponseAdapter.fromJson(reader, customScalarAdapters)
          1 -> _value = NullableIntAdapter.fromJson(reader, customScalarAdapters)
          else -> break
        }
      }

      return com.cyberconnect.link3.fragment.W3STRequirement(
        type = _type!!,
        `value` = _value
      )
    }

    public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: com.cyberconnect.link3.fragment.W3STRequirement,
    ): Unit {
      writer.name("type")
      W3STRequirementType_ResponseAdapter.toJson(writer, customScalarAdapters, value.type)

      writer.name("value")
      NullableIntAdapter.toJson(writer, customScalarAdapters, value.`value`)
    }
  }
}
