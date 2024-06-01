//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.2'.
//
package com.cyberconnect.link3.type.adapter

import com.apollographql.apollo3.api.Adapter
import com.apollographql.apollo3.api.CustomScalarAdapters
import com.apollographql.apollo3.api.IntAdapter
import com.apollographql.apollo3.api.NullableBooleanAdapter
import com.apollographql.apollo3.api.NullableStringAdapter
import com.apollographql.apollo3.api.Optional
import com.apollographql.apollo3.api.StringAdapter
import com.apollographql.apollo3.api.json.JsonReader
import com.apollographql.apollo3.api.json.JsonWriter
import com.apollographql.apollo3.api.present
import com.cyberconnect.link3.type.SearchProfilesInput
import kotlin.IllegalStateException
import kotlin.Unit

public object SearchProfilesInput_InputAdapter : Adapter<SearchProfilesInput> {
  public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
      SearchProfilesInput = throw IllegalStateException("Input type used in output position")

  public override fun toJson(
    writer: JsonWriter,
    customScalarAdapters: CustomScalarAdapters,
    `value`: SearchProfilesInput,
  ): Unit {
    writer.name("query")
    StringAdapter.toJson(writer, customScalarAdapters, value.query)
    writer.name("limit")
    IntAdapter.toJson(writer, customScalarAdapters, value.limit)
    if (value.after is Optional.Present) {
      writer.name("after")
      NullableStringAdapter.present().toJson(writer, customScalarAdapters, value.after)
    }
    if (value.includeMember is Optional.Present) {
      writer.name("includeMember")
      NullableBooleanAdapter.present().toJson(writer, customScalarAdapters, value.includeMember)
    }
  }
}