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
import com.cyberconnect.link3.type.ImageUsage
import kotlin.Unit

public object ImageUsage_ResponseAdapter : Adapter<ImageUsage> {
  public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
      ImageUsage {
    val rawValue = reader.nextString()!!
    return ImageUsage.safeValueOf(rawValue)
  }

  public override fun toJson(
    writer: JsonWriter,
    customScalarAdapters: CustomScalarAdapters,
    `value`: ImageUsage,
  ): Unit {
    writer.value(value.rawValue)
  }
}
