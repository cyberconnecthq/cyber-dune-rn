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
import com.cyberconnect.link3.SearchProfilesQuery
import com.cyberconnect.link3.type.adapter.SearchProfilesInput_InputAdapter
import kotlin.IllegalStateException
import kotlin.Unit

public object SearchProfilesQuery_VariablesAdapter : Adapter<SearchProfilesQuery> {
  public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
      SearchProfilesQuery = throw IllegalStateException("Input type used in output position")

  public override fun toJson(
    writer: JsonWriter,
    customScalarAdapters: CustomScalarAdapters,
    `value`: SearchProfilesQuery,
  ): Unit {
    writer.name("input")
    SearchProfilesInput_InputAdapter.obj().toJson(writer, customScalarAdapters, value.input)
  }
}
