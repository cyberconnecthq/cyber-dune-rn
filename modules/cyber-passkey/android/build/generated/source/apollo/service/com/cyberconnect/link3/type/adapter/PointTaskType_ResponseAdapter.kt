//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.2'.
//
package com.cyberconnect.link3.type.adapter

import com.apollographql.apollo3.api.Adapter
import com.apollographql.apollo3.api.CustomScalarAdapters
import com.apollographql.apollo3.api.json.JsonReader
import com.apollographql.apollo3.api.json.JsonWriter
import com.cyberconnect.link3.type.PointTaskType
import kotlin.Unit

public object PointTaskType_ResponseAdapter : Adapter<PointTaskType> {
  public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
      PointTaskType {
    val rawValue = reader.nextString()!!
    return PointTaskType.safeValueOf(rawValue)
  }

  public override fun toJson(
    writer: JsonWriter,
    customScalarAdapters: CustomScalarAdapters,
    `value`: PointTaskType,
  ): Unit {
    writer.value(value.rawValue)
  }
}
