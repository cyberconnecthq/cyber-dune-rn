//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.2'.
//
package com.cyberconnect.link3.type.adapter

import com.apollographql.apollo3.api.Adapter
import com.apollographql.apollo3.api.CustomScalarAdapters
import com.apollographql.apollo3.api.StringAdapter
import com.apollographql.apollo3.api.json.JsonReader
import com.apollographql.apollo3.api.json.JsonWriter
import com.cyberconnect.link3.type.GalaxyCredInput
import kotlin.IllegalStateException
import kotlin.Unit

public object GalaxyCredInput_InputAdapter : Adapter<GalaxyCredInput> {
  public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
      GalaxyCredInput = throw IllegalStateException("Input type used in output position")

  public override fun toJson(
    writer: JsonWriter,
    customScalarAdapters: CustomScalarAdapters,
    `value`: GalaxyCredInput,
  ): Unit {
    writer.name("id")
    StringAdapter.toJson(writer, customScalarAdapters, value.id)
    writer.name("name")
    StringAdapter.toJson(writer, customScalarAdapters, value.name)
  }
}
