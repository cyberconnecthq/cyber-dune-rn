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
import com.cyberconnect.link3.type.Chain
import kotlin.Unit

public object Chain_ResponseAdapter : Adapter<Chain> {
  public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
      Chain {
    val rawValue = reader.nextString()!!
    return Chain.safeValueOf(rawValue)
  }

  public override fun toJson(
    writer: JsonWriter,
    customScalarAdapters: CustomScalarAdapters,
    `value`: Chain,
  ): Unit {
    writer.value(value.rawValue)
  }
}